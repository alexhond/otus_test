package apihelpers;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class HelpersTest {
  private static WireMockServer wireMock;

  @BeforeAll
  public static void startWireMock() {
//    wireMock = new WireMockServer(9999);
//    wireMock.start();
    configureFor(9190);
  }

//  @AfterAll
//  public static void stopWireMock() {
//    wireMock.stop();
//  }

  @Test
  void test1() {
    given()
        .log().all()
        .baseUri("http://127.0.0.1:9190/user/get/id")
        .get()
        .then()
        .log().all();

  }

}
