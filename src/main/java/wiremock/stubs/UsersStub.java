package wiremock.stubs;

import net.minidev.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class UsersStub {
  private final String basePath = "/user";

  {
    registerUsersStub();
  }

  private void registerUsersStub() {
    Map<String, String> map = new HashMap<>();
    map.put("name", "Leonid");
    map.put("score", "222");

    stubFor(get(urlEqualTo(String.format("%s/get/all", basePath)))
        .willReturn(aResponse()
            .withBody(new JSONObject(map).toJSONString())
            .withStatus(200)));
  }
}
