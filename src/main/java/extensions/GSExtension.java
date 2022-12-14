package extensions;

import annotations.Driver;
import driver.DriverFactoryGS;
import listeners.MouseListener;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import support.GuiceScoped;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashSet;
import java.util.Set;

public class GSExtension implements BeforeEachCallback, AfterEachCallback {
  private static final Logger LOG = LoggerFactory.getLogger(GSExtension.class);

  private EventFiringWebDriver driver = null;
  public GuiceScoped guiceScoped;


  private Set<Field> getAnnotatedFields(Class<? extends Annotation> annotation, ExtensionContext extensionContext) {
    Set<Field> set = new HashSet<>();
    Class<?> testClass = extensionContext.getTestClass().get();
    while (testClass != null) {
      for (Field field : testClass.getDeclaredFields()) {
        if (field.isAnnotationPresent(annotation)) {
          set.add(field);
        }
      }
      testClass = testClass.getSuperclass();
    }
    return set;
  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) {
    driver = new DriverFactoryGS(guiceScoped).getDriver();
    driver.register(new MouseListener());
    driver.manage().window().maximize();
    Set<Field> fields = getAnnotatedFields(Driver.class, extensionContext);

    for (Field field : fields) {
      if (field.getType().getName().equals(WebDriver.class.getName())) {
        AccessController.doPrivileged((PrivilegedAction<Void>)
            () -> {
              try {
                field.setAccessible(true);
                field.set(extensionContext.getTestInstance().get(), driver);
              } catch (IllegalAccessException e) {
                throw new Error(String.format("Could not access or set webdriver in field: %s - is this field public?", field), e);
              }
              return null;
            }
        );
      }
    }
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) {
    String testResult = extensionContext.getExecutionException().isPresent() ? "FAILED" : "OK";
    LOG.info("???????????? ??????????: " + testResult);
    if (driver != null) {
      driver.close();
      try {
        driver.quit();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
