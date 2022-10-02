package components;

import java.util.Calendar;

public class Courses {
  private String name;
  private final Calendar date;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Calendar getDate() {
    return date;
  }

  public Courses(String name, Calendar date) {
    this.name = name;
    this.date = date;
  }
}
