package wiremock.stubs;

import edu.emory.mathcs.backport.java.util.Arrays;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import wiremock.stubs.dto.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class UsersStub {
  private final String basePath = "/user";

  {
    registerUsersStub();
  }

  private void registerUsersStub() {
    List<User> user = new ArrayList<>();
    user.add(new User(1, "QA MOCK", "mock2@mail.ru", "LeonidMock"));
    user.add(new User(2, "Java MOCK", "mock1@mail.ru", "KolyaMock"));

    stubFor(get(urlEqualTo(String.format("%s/get/all", basePath)))
        .willReturn(aResponse()
            .withBody(JSONArray.toJSONString(user))
            .withStatus(200)));
  }
}
