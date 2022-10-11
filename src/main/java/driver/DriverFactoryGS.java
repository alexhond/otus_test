package driver;

import com.google.inject.Inject;
import driver.impl.ChromeDriverImpl;
import driver.impl.FirefoxDriverImpl;
import driver.impl.OperaDriverImpl;
import exceptions.DriverTypeNotSupported;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import support.GuiceScoped;

public class DriverFactoryGS implements IDriverFactory {

  public GuiceScoped guiceScoped;

  @Inject
  public DriverFactoryGS(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
  }

  @Override
  public EventFiringWebDriver getDriver() {
    switch (guiceScoped.browserName) {
      case CHROME:
        return new EventFiringWebDriver(new ChromeDriverImpl().newDriver());
      case FIREFOX:
        return new EventFiringWebDriver(new FirefoxDriverImpl().newDriver());
      case OPERA:
        return new EventFiringWebDriver(new OperaDriverImpl().newDriver());
      default:
        try {
          throw new DriverTypeNotSupported(guiceScoped.browserName.getName());
        } catch (DriverTypeNotSupported ex) {
          ex.printStackTrace();
          return null;
        }
    }
  }

}
