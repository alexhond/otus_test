package pages;

import annotations.PagePath;
import annotations.Url;
import annotations.UrlTemplate;
import com.google.inject.Inject;
import components.Courses;
import io.cucumber.java.ht.Le;
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

@Url({
    @UrlTemplate(name = "lesson", template = "{1}")
})
@PagePath("/lessons")
public class LessonPageCucumber extends BasePage<LessonPageCucumber> {
  private static final Logger LOG = LoggerFactory.getLogger(LessonPageCucumber.class);

  @Inject
  public LessonPageCucumber(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }

  @FindBy(css = ".course-header2__title")
  private WebElement pageTitle;

  @FindBy(css = ".lessons__new-item-start")
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

    dateCourses.stream().map(WebElement::getText).map(text -> {
          Matcher matcher = pattern.matcher(text);
          if (matcher.find()) {
            Date dateMatcher = null;
            try {
              dateMatcher = simpleDateFormat.parse(matcher.group());
              if(dateMatcher.equals(parse) || dateMatcher.compareTo(parse) > 0) {
                System.out.println(text);
              }
            } catch (ParseException e) {
              e.printStackTrace();
            }
            return dateMatcher;
          }
          return null;
        }).forEach(System.out::println);


    return this;
  }

}
