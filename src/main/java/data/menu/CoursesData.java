package data.menu;

public enum CoursesData {
  Highload_Architect("Highload Architect", CourseTypeData.Programmer);

  private String name;
  private CourseTypeData courseTypeData;

  CoursesData(String name, CourseTypeData courseTypeData) {
    this.name = name;
    this.courseTypeData = courseTypeData;
  }

  public String getName() {
    return name;
  }

  public CourseTypeData getCourceTypeData() {
    return courseTypeData;
  }
}
