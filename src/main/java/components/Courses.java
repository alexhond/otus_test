package components;

import java.util.Date;

public class Courses {
  private String name;
  private final Date date;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDate() {
    return date;
  }

  public Courses(String name, Date date) {
    this.name = name;
    this.date = date;
  }
}
