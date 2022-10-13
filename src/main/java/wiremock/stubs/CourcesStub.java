package wiremock.stubs;

import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class CourcesStub {
  private final String basePath = "/cource";

  {
    registerCourcesStub();
  }

  private void registerCourcesStub() {
    Map<String, Object> mapOne = new HashMap<>();
    mapOne.put("name", "C ++ MOCK");
    mapOne.put("price", 3311);
    Map<String, Object> mapTwo = new HashMap<>();
    mapTwo.put("name", "JAVASCRIPT MOCK");
    mapTwo.put("price", 2211);
    List<Map<String, Object>> list = new ArrayList<>();
    list.add(mapOne);
    list.add(mapTwo);

    stubFor(get(urlEqualTo(String.format("%s/get/all", basePath)))
        .willReturn(aResponse()
            .withBody(JSONArray.toJSONString(list))
            .withStatus(200)));
  }
}
