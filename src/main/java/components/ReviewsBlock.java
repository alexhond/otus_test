package components;

import annotations.Component;
import com.google.inject.Inject;
import exceptions.ComponentLocatorException;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.GuiceScoped;

@Component(".course-reviews__box")
public class ReviewsBlock extends BaseComponent<ReviewsBlock> {

  @Inject
  public ReviewsBlock(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }

  public ReviewsBlock reviewActiveItemShouldBePresent() throws ComponentLocatorException {
    WebElement itemElement = this.getComponentEntity()
        .findElement(By.xpath((".//*[contains(@class, 'swiper-slide-active')]/*[contains(@class, 'js-review')]")));
    Assertions.assertThat(itemElement.isDisplayed())
        .as("Item in review slider not active")
        .isTrue();

    return this;
  }


}
