package wiremock.stubs;

import net.minidev.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class CourcesStub {
  private final String basePath = "/cource";

  {
    registerCourcesStub();
  }

  private void registerCourcesStub() {
    Map<String, String> map = new HashMap<>();
    map.put("C PLUS", "3311");
    map.put("JAVASCRIPT", "2211");

    stubFor(get(urlEqualTo(String.format("%s/get/all", basePath)))
        .willReturn(aResponse()
            .withBody(new JSONObject(map).toJSONString())
            .withStatus(200)));
  }
}
