package cucumber.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import pages.LessonPageCucumber;

import java.text.ParseException;

public class LessonPageSteps {

  @Inject
  public LessonPageCucumber lessonPage;

  @Пусть("Открыть страницу урока {string}")
  public void openLessonPage(String lesson) throws Exception {
    lessonPage.open("lesson", lesson);
  }

  @Тогда("Страница урока {string} открыта")
  public void lessonPageShouldBeOpened(String lessonName) {
    lessonPage.pageTitleShouldBeSameAs(lessonName);
  }

  @Если("Открыть страницу курсов программирования")
  public void openLessonPage() throws Exception {
    lessonPage.open("lesson");
  }

  @И("Найти курс стартующий (.+)$")
  public void clickCourseByDate(String date) throws ParseException {
    lessonPage.getDatesCourses(date);
  }
}
