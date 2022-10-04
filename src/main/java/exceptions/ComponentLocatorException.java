package exceptions;

public class ComponentLocatorException extends Exception {

  public ComponentLocatorException() {
    super("Component locator not found");
  }
}
