package ui.courses;

import annotations.Driver;
import components.PopularCourses;
import components.RecommendationCourses;
import components.SpecializationCourses;
import extensions.UIExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
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
  @Tag("check_popular_course")
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
  @Tag("check_recommendation_course")
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
  @Tag("check_specialization_course")
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
  @Tag("test_max_date_specialization_courses")
  void test_max_date_specialization_courses() {
    new MainPage(driver).open();
    new SpecializationCourses(driver).getMaxDate();
  }

  @Test
  @Tag("void test_min_date_specializations_courses() {\n")
  void test_min_date_specializations_courses() {
    new MainPage(driver).open();
    new SpecializationCourses(driver).getMinDate();
  }

  @Test
  @Tag("test_max_date_recommendation_courses")
  void test_max_date_recommendation_courses() {
    new MainPage(driver).open();
    new RecommendationCourses(driver).getMaxDate();
  }

  @Test
  @Tag("test_min_date_recommendation_courses")
  void test_min_date_recommendation_courses() {
    new MainPage(driver).open();
    new RecommendationCourses(driver).getMinDate();
  }

  @Test
  @Tag("test_max_date_popular_courses")
  void test_max_date_popular_courses() {
    new MainPage(driver).open();
    new PopularCourses(driver).getMaxDate();
  }

  @Test
  @Tag("test_min_date_popular_courses")
  void test_min_date_popular_courses() {
    new MainPage(driver).open();
    new PopularCourses(driver).getMinDate();
  }
}
