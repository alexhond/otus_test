package restassured.util.endpoints;

public enum EndPoints {

  PET("pet"),
  STORE("store"),
  USER("user");

  private final String endPointName;

  public String getEndPointName() {
    return endPointName;
  }

  EndPoints(String endPointName) {
    this.endPointName = endPointName;
  }
}
