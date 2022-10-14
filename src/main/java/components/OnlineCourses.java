package components;

import java.util.ArrayList;
import java.util.List;

public class OnlineCourses {
  private String name;
  private int price;

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OnlineCourses(String name, String price) {
    this.name = name;
    this.price = Integer.parseInt(price);
  }

  public static int compare(OnlineCourses one, OnlineCourses two) {
    if (one.getPrice() > two.getPrice())
      return 1;
    return -1;
  }
}
