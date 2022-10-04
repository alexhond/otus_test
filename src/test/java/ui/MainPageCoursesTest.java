package ui;

import annotations.Driver;
import components.PopularCourses;
import components.RecommendationCourses;
import components.SpecializationCourses;
import extensions.UIExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import waiters.StandartWaiter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ExtendWith(UIExtension.class)
public class MainPageCoursesTest {
  private final String errorMsg = "Не удалось получить заголовок страницы";
  private final String buttonOnMainPage = "//button[@class='js-cookie-accept cookies__button']";

  @Driver
  public WebDriver driver;

  @Test
  @Tag("check_popular_course")
  @DisplayName("Популярные курсы - метод фильтр по названию курса")
  void click_popular_course() {
    new MainPage(driver).open();
    String name = "Выбор профессии в IT";

    StandartWaiter waiter = new StandartWaiter(driver);
    waiter.waitForElementVisibleAndClick(driver.findElement(By.xpath(buttonOnMainPage)));

    Boolean title = new PopularCourses(driver)
        .clickLessonItem(name)
        .getPageTitle(name);
    Assertions.assertTrue(title, errorMsg);
  }

  @Test
  @Tag("check_recommendation_course")
  @DisplayName("Рекоммендации - метод фильтр по названию курса")
  void click_recommendation_course() {
    new MainPage(driver).open();
    String name = "Специализация QA Automation Engineer";

    StandartWaiter waiter = new StandartWaiter(driver);
    waiter.waitForElementVisibleAndClick(driver.findElement(By.xpath(buttonOnMainPage)));

    Boolean title = new RecommendationCourses(driver)
        .clickLessonItem(name)
        .getPageTitle(name);
    Assertions.assertTrue(title, errorMsg);
  }

  @Test
  @Tag("check_specialization_course")
  @DisplayName("Специализации - метод фильтр по названию курса")
  void click_specialization_course() {
    new MainPage(driver).open();
    String name = "Специализация С++";

    StandartWaiter waiter = new StandartWaiter(driver);
    waiter.waitForElementVisibleAndClick(driver.findElement(By.xpath(buttonOnMainPage)));

    Boolean title = new SpecializationCourses(driver)
        .clickLessonItem(name)
        .getPageTitle(name);
    Assertions.assertTrue(title, errorMsg);
  }

  @Test
  @Tag("test_max_date_specialization_courses")
  @DisplayName("Специализации - поиск курса стартующего позже всех")
  void test_max_date_specializations_courses() {
    new MainPage(driver).open();
    new SpecializationCourses(driver).getMaxDate();
  }

  @Test
  @Tag("test_min_date_specializations_courses")
  @DisplayName("Специализации - поиск курса стартующего раньше всех")
  void test_min_date_specializations_courses() {
    new MainPage(driver).open();
    new SpecializationCourses(driver).getMinDate();
  }

  @Test
  @Tag("test_max_date_recommendation_courses")
  @DisplayName("Рекоммендации - поиск курса стартующего позже всех")
  void test_max_date_recommendation_courses() {
    new MainPage(driver).open();
    new RecommendationCourses(driver).getMaxDate();
  }

  @Test
  @Tag("test_min_date_recommendation_courses")
  @DisplayName("Рекоммендации - поиск курса стартующего раньше всех")
  void test_min_date_recommendation_courses() {
    new MainPage(driver).open();
    new RecommendationCourses(driver).getMinDate();
  }

  @Test
  @Tag("test_max_date_popular_courses")
  @DisplayName("Популярные курсы - поиск курса стартующего позже всех")
  void test_max_date_popular_courses() {
    new MainPage(driver).open();
    new PopularCourses(driver).getMaxDate();
  }

  @Test
  @Tag("test_min_date_popular_courses")
  @DisplayName("Популярные курсы - поиск курса стартующего раньше всех")
  void test_min_date_popular_courses() {
    new MainPage(driver).open();
    new PopularCourses(driver).getMinDate();
  }
}
