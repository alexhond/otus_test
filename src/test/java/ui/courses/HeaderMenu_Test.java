package ui.courses;

import annotations.Driver;
import components.HeaderMenuComponent;
import data.menu.CoursesData;
import data.menu.MenuItemData;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class HeaderMenu_Test {

    @Driver
    public WebDriver driver;

    @Test
    public void selectCourseFromMenu() {
        new MainPage(driver).open();

        new HeaderMenuComponent(driver)
                .checkSubMenuListNotVisible(MenuItemData.Courses)
                .moveToMenuItem(MenuItemData.Courses)
                .checkSubMenuListVisible(MenuItemData.Courses)
                .clickCourseItem(CoursesData.Highload_Architect);
    }

}
