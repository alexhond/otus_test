package apihelpers;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestRunner;
import com.consol.citrus.message.MessageType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import wiremock.stubs.CourcesStub;
import wiremock.stubs.GradeStubs;
import wiremock.stubs.UsersStub;
import wiremock.stubs.dto.Cources;
import wiremock.stubs.dto.Grade;
import wiremock.stubs.dto.User;

import java.util.Arrays;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

public class TestHTTPHelpersTest extends JUnit4CitrusTestRunner {

  private TestContext context;

  {
    new GradeStubs();
    new UsersStub();
    new CourcesStub();
  }

  @BeforeClass
  public static void startWireMock() {
    configureFor(9991);
  }


  @Test
  @CitrusTest
  public void getAllCourses() {
    this.context = citrus.createTestContext();
    http(httpActionBuilder -> httpActionBuilder
        .client("restClient")
        .send()
        .get("cource/get/all")
    );

    http(httpActionBuilder -> httpActionBuilder
        .client("restClient")
        .receive()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload(getCourceData(), "objectMapper")
        .jsonSchema("json-schema/citrus-cource.json"));
  }

  private List<Cources> getCourceData() {
    return Arrays.asList(
        new Cources("C ++ MOCK", 3311),
        new Cources("JAVASCRIPT MOCK", 2211)
    );
  }

  @Test
  @CitrusTest
  public void getAllUsers() {
    this.context = citrus.createTestContext();
    http(httpActionBuilder -> httpActionBuilder
        .client("restClient")
        .send()
        .get("user/get/all")
    );

    http(httpActionBuilder -> httpActionBuilder
        .client("restClient")
        .receive()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload(getUserData(), "objectMapper")
        .jsonSchema("json-schema/citrus-user.json"));
  }

  private List<User> getUserData() {
    return Arrays.asList(
        new User(1, "QA MOCK", "mock2@mail.ru", "LeonidMock"),
        new User(2, "Java MOCK", "mock1@mail.ru", "KolyaMock")
    );
  }

  @Test
  @CitrusTest
  public void getGradeUser() {
    this.context = citrus.createTestContext();
    http(httpActionBuilder -> httpActionBuilder
        .client("restClient")
        .send()
        .get("user/get/1")
    );

    http(httpActionBuilder -> httpActionBuilder
        .client("restClient")
        .receive()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload(getGradeData(), "objectMapper")
        .jsonSchema("json-schema/citrus-grade.json"));
  }

  private Grade getGradeData() {
    return new Grade("LeonidMock", 222L);
  }
}
