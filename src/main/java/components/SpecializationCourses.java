package components;

import annotations.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Lessons;

import java.util.List;

@Component("//*[contains(@class, 'container-lessons')]/div[text()='Специализации']//following-sibling::div")
public class SpecializationCourses extends AnyComponentAbs<SpecializationCourses> {

    @FindBy(xpath = "//*[contains(@class, 'container-lessons')]/div[text()='Специализации']//following-sibling::div/a")
    private List<WebElement> lessons;

    public SpecializationCourses(WebDriver driver) {
        super(driver);
    }

    public Lessons clickLessonItem(String name) {
        lessons.stream()
                .filter(s -> s.getText().contains(name))
                .findFirst()
                .ifPresent(WebElement::click);

        return new Lessons(driver);
    }

}
