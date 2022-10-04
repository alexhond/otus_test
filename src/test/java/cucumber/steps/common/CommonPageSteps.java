package cucumber.steps.common;

import com.google.inject.Inject;
import data.BrowserData;
import driver.DriverFactory;
import io.cucumber.java.ru.Пусть;
import support.GuiceScoped;

import java.util.Locale;

public class CommonPageSteps {

  @Inject
  private DriverFactory driverFactory;
  @Inject
  private GuiceScoped guiceScoped;

  @Пусть("Я открываю браузер {string}")
  public void initBrowser(String browserName) {
    guiceScoped.browserName = BrowserData.valueOf(browserName.toUpperCase(Locale.ROOT));
    guiceScoped.driver = driverFactory.getDriver();
  }
}
