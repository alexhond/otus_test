package pages;

import annotations.PagePath;
import annotations.Url;
import annotations.UrlTemplate;
import com.google.inject.Inject;
import components.Courses;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import support.GuiceScoped;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Url({
    @UrlTemplate(name = "lesson", template = "{1}")
})
@PagePath("/lessons")
public class LessonPageCucumber extends BasePage<LessonPageCucumber> {
  private static final Logger LOG = LoggerFactory.getLogger(LessonPageCucumber.class);
  private static List<Courses> courses = new ArrayList<>();

  @Inject
  public LessonPageCucumber(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }

  @FindBy(css = ".course-header2__title")
  private WebElement pageTitle;

  @FindBy(css = ".lessons__new-item-container")
  private List<WebElement> dateCourses;

  public LessonPageCucumber pageTitleShouldBeSameAs(String pageName) {
    Assertions.assertThat(pageTitle.getText())
        .as("Page title should be {}", pageName)
        .isEqualTo(pageName);

    return this;
  }

  public LessonPageCucumber getDatesCourses(String date) throws ParseException {
    Locale locale = new Locale("ru");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM", locale);
    Pattern pattern = Pattern.compile("\\d{1,2}\\s[a-zA-Zа-яА-Я]+");
    Matcher matcherDateReq = pattern.matcher(date);
    String group = null;
    if (matcherDateReq.find()) {
      group = matcherDateReq.group();
    }
    Date parse = simpleDateFormat.parse(group);

    courses = dateCourses.stream()
        .map(webElement -> {
          String text = webElement.findElement(By.cssSelector(".lessons__new-item-bottom")).getText();
          Matcher matcher = pattern.matcher(text);
          if (matcher.find()) {
            Date dateMatcher = null;
            try {
              dateMatcher = simpleDateFormat.parse(matcher.group());
            } catch (ParseException ignored) {
              LOG.error("Error");
            }
            if (dateMatcher != null && (dateMatcher.equals(parse) || dateMatcher.compareTo(parse) > 0)) {
              String text1 = webElement.findElement(By.cssSelector(".lessons__new-item-title")).getText();
              return new Courses(text1, dateMatcher);
            }
          }
          return null;
        }).filter(Objects::nonNull)
        .filter(s -> s.getDate() != null)
        .collect(Collectors.toList());

    return this;
  }

  public void viewCourse() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM");

    courses.forEach(s -> {
      String formatted = formatter.format(s.getDate());
      LOG.info("Название курса: {}, дата курса {},", s.getName(), formatted);
    });
  }
}
