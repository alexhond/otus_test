package apihelpers;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import wiremock.stubs.GradeStubs;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static io.restassured.RestAssured.given;

public class HelpersTest {
  private static WireMockServer wireMock;

  {
    new GradeStubs();
  }

  @BeforeAll
  public static void startWireMock() {
    configureFor(9991);
  }


  @Test
  void test1() {
    given()
        .log().all()
        .baseUri("http://127.0.0.1:9991/user/get/id")
        .get()
        .then()
        .log().all();

  }

}
