package components;

import annotations.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Lessons;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component("//*[contains(@class, 'container-lessons')]//div[text()='Специализации']//following-sibling::div")
public class SpecializationCourses extends AnyComponentAbs<SpecializationCourses> {

  @FindBy(xpath = "//*[contains(@class, 'container-lessons')]//div[text()='Специализации']//following-sibling::div/a")
  private List<WebElement> lessons;

  @FindBy(xpath = "//*[contains(@class, 'container-lessons')]//div[text()='Специализации']//following-sibling::div/a//div[@class='lessons__new-item-time']")
  private List<WebElement> dates;

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

  public Lessons getLessonsDate() throws ParseException {
    Pattern pattern = Pattern.compile("^\\d{1,2}\\s[a-zA-Zа-яА-Я]+");
    Map<String, String> months = new HashMap<>();
    months.put("янв", "01");
    months.put("фев", "02");
    months.put("мар", "03");
    months.put("апр", "04");
    months.put("ма", "05");
    months.put("июн", "06");
    months.put("июл", "07");
    months.put("август", "08");
    months.put("сентябр", "09");
    months.put("октябр", "10");
    months.put("ноябр", "11 ");
    months.put("декабр", "12");

    List<String> collect = dates.stream().map(s -> pattern.matcher(s.getText()))
        .filter(Matcher::find)
        .map(Matcher::group)
        .map(x -> {
          String a = "";
          for (Map.Entry<String, String> entry : months.entrySet()) {
            if (x.contains(entry.getKey())) {
              Pattern newPat = Pattern.compile("[a-zA-Zа-яА-Я]+");
              Matcher m = newPat.matcher(x);
              if (m.find()) {
                String group = m.group();
                a = x.replaceAll(group, entry.getValue());
              }
            }
          }
          return a;
        }).collect(Collectors.toList());

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM");
    Date date1 = simpleDateFormat.parse(collect.get(1));
    Date date2 = simpleDateFormat.parse(collect.get(2));
    int res = date1.compareTo(date2);
    System.out.println("res - " + res);


    return new Lessons(driver);
  }

}
