package cucumber.steps.components;

import com.google.inject.Inject;
import components.ReviewsBlock;
import exceptions.ComponentLocatorException;
import io.cucumber.java.ru.Тогда;

public class ReviewBlockSteps {

  @Inject
  private ReviewsBlock reviewsBlock;

  @Тогда("Блок отзывов отображается на странице")
  public void reviewBlockShouldBePresent() throws ComponentLocatorException {
    reviewsBlock.validateComponent();
  }
}
