
package wiremock.stubs.dto;

public class Cources {
  public String name;
  public Integer price;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Cources() {
  }

  public Cources(String name, Integer price) {
    this.name = name;
    this.price = price;
  }
}
