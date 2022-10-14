package cucumber.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import pages.OnlinePageCucumber;

public class OnlinePageSteps {

  @Inject
  public OnlinePageCucumber onlinePage;

  @Если("Открыть страницу подготовительных курсов")
  public void getOnlineCourses() throws Exception {
    onlinePage.open("online");
  }

  @Тогда("Найти самый дешевый курс и вывести информацию на консоль")
  public void getMinPriceCourse() {
    onlinePage.getOnlineCourses().getMinPriceCourse();
  }

  @Тогда("Найти самый дорогой курс и вывести информацию на консоль")
  public void getMaxPriceCourse() {
    onlinePage.getOnlineCourses().getMaxPriceCourse();
  }
}
