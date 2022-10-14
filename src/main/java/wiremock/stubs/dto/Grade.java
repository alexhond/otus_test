
package wiremock.stubs.dto;

public class Grade {

  public String name;
  public Long score;

  public Grade() {
  }

  public Grade(String name, Long score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }

}
