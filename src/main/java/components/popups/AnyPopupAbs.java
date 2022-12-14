package components.popups;

import actions.CommonActions;
import org.openqa.selenium.WebDriver;

public abstract class AnyPopupAbs<T> extends CommonActions<T> implements IPopup<T> {

  public AnyPopupAbs(WebDriver driver) {
    super(driver);
  }
}
