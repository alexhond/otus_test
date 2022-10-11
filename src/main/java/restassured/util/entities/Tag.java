package restassured.util.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {
  @JsonProperty("id")
  public int getId() {
    return this.id;
  }

  public Tag() {
  }

  public Tag(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public void setId(int id) {
    this.id = id;
  }

  int id;

  @JsonProperty("name")
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  String name;
}