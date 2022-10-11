package driver;

import driver.impl.ChromeDriverImpl;
import driver.impl.FirefoxDriverImpl;
import driver.impl.OperaDriverImpl;
import exceptions.DriverTypeNotSupported;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Locale;

public class DriverFactoryUI implements IDriverFactory {

  private final String browserType = System.getProperty("browser").toLowerCase(Locale.ROOT);
  private static final String CHROME = "chrome";
  private static final String FIREFOX = "firefox";
  private static final String OPERA = "opera";
  private final String driverName = System.getProperty("browser");

  @Override
  public EventFiringWebDriver getDriver() {
    switch (driverName.toLowerCase(Locale.ROOT)) {
      case CHROME:
        return new EventFiringWebDriver(new ChromeDriverImpl().newDriver());
      case FIREFOX:
        return new EventFiringWebDriver(new FirefoxDriverImpl().newDriver());
      case OPERA:
        return new EventFiringWebDriver(new OperaDriverImpl().newDriver());
      default:
        try {
          throw new DriverTypeNotSupported(this.browserType);
        } catch (DriverTypeNotSupported ex) {
          ex.printStackTrace();
          return null;
        }
    }
  }

}