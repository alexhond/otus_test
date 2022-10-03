package driver.impl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class OperaDriverImpl implements IDriver {

  @Override
  public WebDriver newDriver() {
    OperaOptions operaOptions = new OperaOptions();
    operaOptions.addArguments("--disable-notifications");
    operaOptions.addArguments("--disable-popup-blocking");
    WebDriverManager.operadriver().setup();
    return new OperaDriver(operaOptions);
  }
}
