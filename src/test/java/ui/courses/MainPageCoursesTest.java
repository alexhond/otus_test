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
  void compare_date_test() {
    new MainPage(driver).open();
    new SpecializationCourses(driver).getLessonsDate();
  }
}
