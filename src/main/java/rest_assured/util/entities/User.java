package rest_assured.util.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User extends CommonPetStoreObject {

  public User() {
  }

  public User(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.userStatus = userStatus;
  }

  @JsonProperty("id")
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  int id;

  @JsonProperty("username")
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return getId() == user.getId() && getUserStatus() == user.getUserStatus() && getUsername().equals(user.getUsername()) && getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName()) && getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword()) && getPhone().equals(user.getPhone());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getUsername(), getFirstName(), getLastName(), getEmail(), getPassword(), getPhone(), getUserStatus());
  }

  public void setUsername(String username) {
    this.username = username;
  }

  String username;

  @JsonProperty("firstName")
  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  String firstName;

  @JsonProperty("lastName")
  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  String lastName;

  @JsonProperty("email")
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  String email;

  @JsonProperty("password")
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  String password;

  @JsonProperty("phone")
  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  String phone;

  @JsonProperty("userStatus")
  public int getUserStatus() {
    return this.userStatus;
  }

  public void setUserStatus(int userStatus) {
    this.userStatus = userStatus;
  }

  int userStatus;
}
