package rest_assured.util.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Pet extends CommonPetStoreObject{
  public Pet() {
  }

  public Pet(int id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
    this.id = id;
    this.category = category;
    this.name = name;
    this.photoUrls = photoUrls;
    this.tags = tags;
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pet)) return false;
    Pet pet = (Pet) o;
    return getId() == pet.getId() && getCategory().equals(pet.getCategory()) && getName().equals(pet.getName()) && getPhotoUrls().equals(pet.getPhotoUrls()) && getTags().equals(pet.getTags()) && getStatus().equals(pet.getStatus());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getCategory(), getName(), getPhotoUrls(), getTags(), getStatus());
  }

  @JsonProperty("id")
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  int id;

  @JsonProperty("category")
  public Category getCategory() {
    return this.category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  Category category;

  @JsonProperty("name")
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  String name;

  @JsonProperty("photoUrls")
  public List<String> getPhotoUrls() {
    return this.photoUrls;
  }

  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
  }

  List<String> photoUrls;

  @JsonProperty("tags")
  public List<Tag> getTags() {
    return this.tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  List<Tag> tags;

  @JsonProperty("status")
  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  String status;
}
