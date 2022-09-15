package components;

import annotations.Component;
import data.menu.CoursesData;
import data.menu.MenuItemData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LessonsPage;

@Component("//*[contains(@class, 'header2-menu_main')]")
public class HeaderMenuComponent extends AnyComponentAbs<HeaderMenuComponent> {

    public HeaderMenuComponent(WebDriver driver) {
        super(driver);
    }

    private String menuItemLocator = baseLocator + "//*[contains(@class, 'header2-menu__item_dropdown')][.//*[contains(@class, 'header2-menu__item')][text()='%s']]";
    private String menuItemDropdownListLocator = menuItemLocator + "//*[@class='header2-menu__dropdown']";

    public HeaderMenuComponent moveToMenuItem(MenuItemData menuItemData) {
        WebElement menuItemElement = driver.findElement(By.xpath(String.format(menuItemLocator, menuItemData.getName())));
        actions.moveToElement(menuItemElement).build().perform();

        return this;
    }

    public HeaderMenuComponent checkSubMenuListVisible(MenuItemData menuItemData) {
        assert standartWaiter.waitForElementVisible(
                driver.findElement(By.xpath(String.format(menuItemDropdownListLocator, menuItemData.getName())))
        ) : "Sub menu not visible";

        return this;
    }

    public HeaderMenuComponent checkSubMenuListNotVisible(MenuItemData menuItemData) {
        assert standartWaiter.waitForElementNotVisible(
                driver.findElement(By.xpath(String.format(menuItemDropdownListLocator, menuItemData.getName())))
        ) : "Sub menu visible";

        return this;
    }

    public LessonsPage clickCourseItem(CoursesData coursesData) {
        String baseCourseTypeLocator = menuItemDropdownListLocator + "/*[contains(@class, 'header2-menu__subdropdown-wrapper')][.//a[@title='%s']]";
        WebElement baseCourseElement = driver.findElement(By.xpath(String.format(baseCourseTypeLocator, MenuItemData.Courses.getName(), coursesData.getCourceTypeData().getName())));

        actions.moveToElement(baseCourseElement).build().perform();
        assert standartWaiter.waitForCondition(ExpectedConditions.attributeContains(baseCourseElement, "class", "header2-menu__dropdown-wrapper_open")) : "";

        baseCourseElement.findElement(By.xpath(String.format(".//a[@title='%s']", coursesData.getName()))).click();

        return new LessonsPage(driver);
    }

}
