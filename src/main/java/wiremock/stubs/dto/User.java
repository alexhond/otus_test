
package wiremock.stubs.dto;

public class User {

  public int age;
  public String cource;
  public String email;

  public User() {
  }

  public User(Integer age, String cource, String email, String name) {
    this.age = age;
    this.cource = cource;
    this.email = email;
    this.name = name;
  }

  private String name;

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getCource() {
    return cource;
  }

  public void setCource(String cource) {
    this.cource = cource;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
