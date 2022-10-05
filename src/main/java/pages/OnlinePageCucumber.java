package pages;

import annotations.PagePath;
import annotations.Url;
import annotations.UrlTemplate;
import com.google.inject.Inject;
import components.OnlineCourses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import support.GuiceScoped;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Url({
    @UrlTemplate(name = "online", template = "{1}")
})
@PagePath("/online")
public class OnlinePageCucumber extends BasePage<OnlinePageCucumber> {
  private static final Logger LOG = LoggerFactory.getLogger(OnlinePageCucumber.class);
  private static List<OnlineCourses> courses = new ArrayList<>();

  @Inject
  public OnlinePageCucumber(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }

  @FindBy(css = ".course-header2__title")
  private WebElement pageTitle;

  @FindBy(css = ".lessons__new-item-container")
  private List<WebElement> onlineCourses;


  public OnlinePageCucumber getOnlineCourses() {
    courses = onlineCourses.stream()
        .map(webElement -> {
          String text = webElement.findElement(By.cssSelector(".lessons__new-item-price")).getText();
          Pattern pattern = Pattern.compile("\\d+");
          Matcher matcher = pattern.matcher(text);
          if (matcher.find()) {
            String price = matcher.group();
            if (price != null) {
              String name = webElement.findElement(By.cssSelector(".lessons__new-item-title")).getText();
              return new OnlineCourses(name, price);
            }
          }
          return null;
        })
        .filter(Objects::nonNull)
        .filter(s -> s.getPrice() != 0)
        .collect(Collectors.toList());

    return this;
  }

  public void getMinPriceCourse() {
    OnlineCourses onlineCourses = courses.stream().min(OnlineCourses::compare).get();
    LOG.info("Самый дешевый курс: {}, цена {}", onlineCourses.getName(), onlineCourses.getPrice());
  }

  public void getMaxPriceCourse() {
    OnlineCourses onlineCourses = courses.stream().max(OnlineCourses::compare).get();
    LOG.info("Самый дорогой курс: {}, цена {}", onlineCourses.getName(), onlineCourses.getPrice());
  }

}
