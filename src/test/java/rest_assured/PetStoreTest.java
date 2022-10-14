package rest_assured;


import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restassured.util.endpoints.EndPoints;
import restassured.util.entities.Category;
import restassured.util.entities.Pet;
import restassured.util.entities.Tag;
import restassured.util.entities.User;
import restassured.util.steps.RestSteps;

import java.util.ArrayList;
import java.util.List;

public class PetStoreTest {

  /**
   * Отправить запрос по эндпоинту user, создать нового user
   * Проверить: что user успешно создан
   * Сравнить созданного user с ожидаемым user
   */
  @Test
  @DisplayName("Add a new user")
  void testAddNewUser() {
    User user = new User(
        1337, "Pepl", "Peplov", "Peplovich",
        "mailmail", "pass", "12345678", 200);
    Response responsePost = RestSteps.postResponse(user, EndPoints.USER);
    RestSteps.checkStatus(responsePost, 200);

    Response responseGet = RestSteps.getResponse("Pepl", EndPoints.USER);
    RestSteps.checkStatus(responseGet, 200);

    RestSteps.validateJsonSchema(responseGet, "json-schema/user-schema.json");


    RestSteps.compareObjects(responseGet, user);
  }

  /**
   * Обновить user
   * Проверить: что user успешно обновлен
   */
  @Test
  @DisplayName("Update user")
  void testUpdateUser() {
    User user = new User(
        1337, "NewPepl", "Peplov", "Peplovich",
        "mailmail", "pass", "12345678", 200);
    Response responsePost = RestSteps.putResponse(user, "username", EndPoints.USER);
    RestSteps.checkStatus(responsePost, 200);

    Response responseGet = RestSteps.getResponse("NewPepl", EndPoints.USER);
    RestSteps.checkStatus(responseGet, 200);
    Assertions.assertEquals("NewPepl", responseGet.then().extract().as(User.class).getUsername());
  }

  /**
   * Отправить запрос по эндпоинту pet, создать нового user
   * Проверить: что pet успешно создан
   */
  @Test
  @DisplayName("Add a new pet")
  void testAddNewPet() {
    List<String> photourls = new ArrayList<>();
    photourls.add("adssa");
    photourls.add("ddd");
    List<Tag> tags = new ArrayList<>();
    tags.add(new Tag(222, "111"));
    Pet pet = new Pet(
        133, new Category(2, "asd"), "newPet", photourls, tags, "status"
    );
    Response responsePost = RestSteps.postResponse(pet, EndPoints.PET);
    RestSteps.checkStatus(responsePost, 200);

    Response responseGet = RestSteps.getResponse("133", EndPoints.PET);

    RestSteps.validateJsonSchema(responseGet, "json-schema/pet-schema.json");
    RestSteps.checkStatus(responseGet, 200);
  }

  /**
   * Обновить pet
   * Проверить: что user успешно обновлен
   */
  @Test
  @DisplayName("Update pet")
  void testUpdatePet() {
    List<String> photourls = new ArrayList<>();
    photourls.add("adssa");
    photourls.add("ddd");
    List<Tag> tags = new ArrayList<>();
    tags.add(new Tag(222, "111"));
    Pet pet = new Pet(
        444, new Category(2, "asd"), "newPet", photourls, tags, "status"
    );
    Response responsePost = RestSteps.putResponse(pet, EndPoints.PET);
    RestSteps.checkStatus(responsePost, 200);

    Response responseGet = RestSteps.getResponse("444", EndPoints.PET);
    RestSteps.checkStatus(responseGet, 200);

    Assertions.assertEquals(444, responseGet.then().extract().as(Pet.class).getId());
  }
}


