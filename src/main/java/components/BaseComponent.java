package components;

import annotations.Component;
import exceptions.ComponentLocatorException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import support.GuiceScoped;

public abstract class BaseComponent<T> {

  protected GuiceScoped guiceScoped;

  public BaseComponent(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
    PageFactory.initElements(guiceScoped.driver, this);
    try {
      validateComponent();
    } catch (ComponentLocatorException e) {
      throw new RuntimeException(e);
    }
  }

  private By getComponentLocator() throws ComponentLocatorException {
    Class<? extends BaseComponent> clazz = this.getClass();
    if (clazz.isAnnotationPresent(Component.class)) {
      Component component = clazz.getAnnotation(Component.class);
      return this.locatorAnalyzer(component.value());
    }

    throw new ComponentLocatorException();
  }

  public WebElement getComponentEntity() throws ComponentLocatorException {
    return guiceScoped.driver.findElement(getComponentLocator());
  }

  public void validateComponent() throws ComponentLocatorException {
    Assertions.assertThat(this.getComponentEntity().isDisplayed())
        .as("Component not displayed")
        .isTrue();
  }

  private By locatorAnalyzer(String locatorStr) {
    if (locatorStr.startsWith("/")) {
      return By.xpath(locatorStr);
    } else if (locatorStr.startsWith("id:")) {
      return By.id(locatorStr.replace("id:", ""));
    }

    return By.cssSelector(locatorStr);
  }

}
