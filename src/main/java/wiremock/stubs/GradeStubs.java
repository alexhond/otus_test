package wiremock.stubs;

import net.minidev.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class GradeStubs {
  private final String basePath = "/user";

  {
    registerGradeStub();
  }

  private void registerGradeStub() {
    Map<String, Object> map = new HashMap<>();
    map.put("name", "LeonidMock");
    map.put("score", 222);

    stubFor(get(urlEqualTo(String.format("%s/get/\\d+", basePath)))
        .willReturn(aResponse()
            .withBody(new JSONObject(map).toJSONString())
            .withStatus(200)));
  }
}
