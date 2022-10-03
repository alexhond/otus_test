package components;

import java.util.Date;

public class Courses {
  private String name;
  private Date date;

  public void setDate(Date date) {
    this.date = new Date(date.getTime());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDate() {
    return new Date(date.getTime());
  }

  public Courses(String name, Date date) {
    this.date = new Date(date.getTime());
    this.name = name;
  }
}
