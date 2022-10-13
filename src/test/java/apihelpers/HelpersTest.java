package apihelpers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wiremock.stubs.CourcesStub;
import wiremock.stubs.GradeStubs;
import wiremock.stubs.UsersStub;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static io.restassured.RestAssured.given;

public class HelpersTest {

  {
    new GradeStubs();
    new UsersStub();
    new CourcesStub();
  }

  @BeforeAll
  public static void startWireMock() {
    configureFor(9991);
  }


  @Test
  void test1() {
    given()
        .log().all()
        .baseUri("http://127.0.0.1:9991/cource/get/all")
        .get()
        .then()
        .log().all();

  }

  @Test
  @DisplayName("Тест http-helper")
  void testHttpHelper() {

  }

}
