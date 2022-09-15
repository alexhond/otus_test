package components;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Lessons;

import java.util.List;

@Component("//*[contains(@class, 'container-lessons')]/div[text()='Рекомендации для вас']//following-sibling::div")
public class RecommendationCourses extends AnyComponentAbs<RecommendationCourses> {

    @FindBy(xpath = "//*[contains(@class, 'container-lessons')]/div[text()='Рекомендации для вас']//following-sibling::div/a")
    private List<WebElement> lessons;

    public RecommendationCourses(WebDriver driver) {
        super(driver);
    }

    public Lessons clickLessonItem(String name) {
        lessons
                .forEach(s -> s.findElement(By.xpath("//div[contains(text(),'Специализация QA Automation Engineer')]")).click());

        return new Lessons(driver);
    }

}
