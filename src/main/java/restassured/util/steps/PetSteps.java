package restassured.util.steps;

import restassured.util.endpoints.EndPoints;
import restassured.util.entities.CommonPetStoreObject;
import restassured.util.utils.RestUtils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class PetSteps {

  public static Response postResponse(CommonPetStoreObject request, EndPoints endPoints) {
    return RestUtils.sendPost(request, endPoints.getEndPointName()).extract().response();
  }

  public static Response getResponse(String name, EndPoints endPoints) {
    return RestUtils.sendGet(endPoints.getEndPointName(), name).extract().response();
  }

  public static Response putResponse(CommonPetStoreObject request, String name, EndPoints endPoints) {
    return RestUtils.sendPut(request, endPoints.getEndPointName(), name).extract().response();
  }

  public static Response putResponse(CommonPetStoreObject request, EndPoints endPoints) {
    return RestUtils.sendPut(request, endPoints.getEndPointName()).extract().response();
  }

  public static void checkStatus(Response response, int statusCode) {
    response.then().statusCode(statusCode);
  }

  public static void compareObjects(Response actual, CommonPetStoreObject expected) {
    CommonPetStoreObject actualResponse = actual.as(expected.getClass());
    Assertions.assertEquals(expected, actualResponse);

  }
}
