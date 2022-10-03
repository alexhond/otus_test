package components;

import annotations.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Lessons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("//*[contains(@class, 'container-lessons')]//div[text()='Специализации']//following-sibling::div")
public class SpecializationCourses extends AnyComponentAbs<SpecializationCourses> {
  private static final Logger LOG = LoggerFactory.getLogger(SpecializationCourses.class);

  @FindBy(xpath = "//*[contains(@class, 'container-lessons')]//div[text()='Специализации']//following-sibling::div/a")
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

  public void getMaxDate() {
    Locale locale = new Locale("ru");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM", locale);

    String maxName = lessons.stream().map(WebElement::getText).map(text -> {
          Pattern pattern = Pattern.compile("\\d{1,2}\\s[a-zA-Zа-яА-Я]+");
          Matcher matcher = pattern.matcher(text);
          if (matcher.find()) {
            Date dateMatcher = null;
            try {
              dateMatcher = simpleDateFormat.parse(matcher.group());
            } catch (ParseException e) {
              e.printStackTrace();
            }
            if (dateMatcher != null)
              return new Courses(text, dateMatcher);
          }
          return null;
        }).filter(Objects::nonNull)
        .filter(s -> s.getDate() != null)
        .reduce(BinaryOperator.maxBy(Comparator.comparing(Courses::getDate)))
        .map(Courses::getName).get();
    LOG.info("Специализации. Курс стартующий позже всех: " + maxName);
  }

  public void getMinDate() {
    Locale locale = new Locale("ru");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM", locale);

    String minName = lessons.stream().map(WebElement::getText).map(text -> {
          Pattern pattern = Pattern.compile("\\d{1,2}\\s[a-zA-Zа-яА-Я]+");
          Matcher matcher = pattern.matcher(text);
          if (matcher.find()) {
            Date dateMatcher = null;
            try {
              dateMatcher = simpleDateFormat.parse(matcher.group());
            } catch (ParseException e) {
              e.printStackTrace();
            }
            if (dateMatcher != null)
              return new Courses(text, dateMatcher);
          }
          return null;
        }).filter(Objects::nonNull)
        .reduce(BinaryOperator.minBy(Comparator.comparing(Courses::getDate)))
        .map(Courses::getName).get();
    LOG.info("Специализации. Курс стартующий позже всех: " + minName);
  }
}

