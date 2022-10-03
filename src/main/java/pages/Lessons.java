package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Lessons extends AnyPageAbs<Lessons> {

  public Lessons(WebDriver driver) {
    super(driver);
  }

  public String getPageTitle() {
    return driver.getTitle();
  }

  public Boolean getPageTitle(String name) {
    return standartWaiter.waitForCondition(ExpectedConditions.titleIs(name));
  }
}
