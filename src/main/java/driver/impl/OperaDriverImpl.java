package driver.impl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaDriverImpl implements IDriver {

    @Override
    public WebDriver newDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}
