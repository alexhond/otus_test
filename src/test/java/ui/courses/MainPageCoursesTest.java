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
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class MainPageCoursesTest {

    @Driver
    public WebDriver driver;

    @Test
    public void click_popular_course() {
        new MainPage(driver).open();

        String title = new PopularCourses(driver)
                .clickLessonItem("MS SQL Server Developer")
                .getPageTitle();
        Assertions.assertEquals("Курсы MS SQL Server разработчик. Обучение Microsoft SQL Server для инженеров и администраторов баз данных", title);
    }

    @Test
    public void click_recommendation_course() {
        new MainPage(driver).open();

        String title = new RecommendationCourses(driver)
                .clickLessonItem("Java QA Engineer. Professional")
                .getPageTitle();
        Assertions.assertEquals("Курсы MS SQL Server разработчик. Обучение Microsoft SQL Server для инженеров и администраторов баз данных", title);
    }

    @Test
    public void click_specialization_course() {
        new MainPage(driver).open();

        new SpecializationCourses(driver)
                .clickLessonItem("Специализация С++")
                .getPageTitle();
    }

}
