package ui.courses;

import annotations.Driver;
import components.PopularCourses;
import components.RecommendationCourses;
import components.SpecializationCourses;
import extensions.UIExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.MainPage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ExtendWith(UIExtension.class)
public class MainPageCoursesTest {
  private static final Logger LOG = LoggerFactory.getLogger(MainPageCoursesTest.class);

  @Driver
  public WebDriver driver;

  @Test
  void click_popular_course() {
    new MainPage(driver).open();
    String name = "Выбор профессии в IT";

    String title = new PopularCourses(driver)
        .clickLessonItem(name)
        .getPageTitle();
    LOG.info("Заголовок: " + title);
    Assertions.assertEquals(name, title);
  }

  @Test
  public void click_recommendation_course() {
    new MainPage(driver).open();
    String name = "Специализация QA Automation Engineer";

    String title = new RecommendationCourses(driver)
        .clickLessonItem(name)
        .getPageTitle();
    LOG.info("Заголовок: " + title);
    Assertions.assertEquals(name, title);
  }

  @Test
  void click_specialization_course() {
    new MainPage(driver).open();
    String name = "Специализация С++";

    String title = new SpecializationCourses(driver)
        .clickLessonItem(name)
        .getPageTitle();
    LOG.info("Заголовок: " + title);
    Assertions.assertEquals(name, title);
  }

  @Test
  void compare_date_test() throws ParseException {
    new MainPage(driver).open();
    new SpecializationCourses(driver).getLessonsDate();
  }

  @Test
  void gg () {
    List<String> list = new ArrayList<>();
    list.add("27 сентября 10 месяцев");
    list.add("28 сентября 15 месяцев");
    list.add("В октябре 2023 года 9 месяцев");
    list.add("О дате старта будет объявлено позже");

    Pattern pattern = Pattern.compile("^\\d{1,2}\\s[a-zA-Zа-яА-Я]+");

    list.stream().map(pattern::matcher)
        .filter(Matcher::find)
        .map(Matcher::group)
        .forEach(System.out::println);
  }
}
