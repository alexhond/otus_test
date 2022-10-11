package rest_assured;


import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rest_assured.util.endpoints.EndPoints;
import rest_assured.util.entities.Category;
import rest_assured.util.entities.Pet;
import rest_assured.util.entities.Tag;
import rest_assured.util.entities.User;
import rest_assured.util.steps.PetSteps;

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
  void test1() {
    User user = new User(
        1337, "Pepl", "Peplov", "Peplovich",
        "mailmail", "pass", "12345678", 200);
    Response responsePost = PetSteps.postResponse(user, EndPoints.USER);
    PetSteps.checkStatus(responsePost, 200);

    Response responseGet = PetSteps.getResponse("Pepl", EndPoints.USER);
    PetSteps.checkStatus(responseGet, 200);

    PetSteps.compareObjects(responseGet, user);
  }

  /**
   * Обновить user
   * Проверить: что user успешно обновлен
   */
  @Test
  @DisplayName("Update user")
  void test2() {
    User user = new User(
        1337, "NewPepl", "Peplov", "Peplovich",
        "mailmail", "pass", "12345678", 200);
    Response responsePost = PetSteps.putResponse(user, "username", EndPoints.USER);
    PetSteps.checkStatus(responsePost, 200);

    Response responseGet = PetSteps.getResponse("NewPepl", EndPoints.USER);
    PetSteps.checkStatus(responseGet, 200);
    Assertions.assertEquals("NewPepl", responseGet.then().extract().as(User.class).getUsername());
  }

  /**
   * Отправить запрос по эндпоинту pet, создать нового user
   * Проверить: что pet успешно создан
   */
  @Test
  @DisplayName("Add a new pet")
  void test3() {
    List<String> photourls = new ArrayList<>();
    photourls.add("adssa");
    photourls.add("ddd");
    List<Tag> tags = new ArrayList<>();
    tags.add(new Tag(222, "111"));
    Pet pet = new Pet(
        133, new Category(2, "asd"), "newPet", photourls, tags, "status"
    );
    Response responsePost = PetSteps.postResponse(pet, EndPoints.PET);
    PetSteps.checkStatus(responsePost, 200);

    Response responseGet = PetSteps.getResponse("133", EndPoints.PET);
    PetSteps.checkStatus(responseGet, 200);
  }

  /**
   * Обновить pet
   * Проверить: что user успешно обновлен
   */
  @Test
  @DisplayName("Update pet")
  void test4() {
    List<String> photourls = new ArrayList<>();
    photourls.add("adssa");
    photourls.add("ddd");
    List<Tag> tags = new ArrayList<>();
    tags.add(new Tag(222, "111"));
    Pet pet = new Pet(
        444, new Category(2, "asd"), "newPet", photourls, tags, "status"
    );
    Response responsePost = PetSteps.putResponse(pet, EndPoints.PET);
    PetSteps.checkStatus(responsePost, 200);

    Response responseGet = PetSteps.getResponse("444", EndPoints.PET);
    PetSteps.checkStatus(responseGet, 200);
    Assertions.assertEquals(444, responseGet.then().extract().as(Pet.class).getId());
  }
}


