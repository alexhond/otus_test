package pages;

import annotations.PagePath;
import annotations.Url;
import annotations.UrlTemplate;
import com.google.inject.Inject;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.GuiceScoped;

@Url({
    @UrlTemplate(name = "lesson", template = "{1}")
})
@PagePath("/lessons")
public class LessonPageCucumber extends BasePage<LessonPageCucumber> {

  @Inject
  public LessonPageCucumber(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }

  @FindBy(css = ".course-header2__title")
  private WebElement pageTitle;

  public LessonPageCucumber pageTitleShouldBeSameAs(String pageName) {
    Assertions.assertThat(pageTitle.getText())
        .as("Page title should be {}", pageName)
        .isEqualTo(pageName);

    return this;
  }

}
