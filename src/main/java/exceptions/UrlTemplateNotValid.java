package exceptions;

public class UrlTemplateNotValid extends Exception {

  public UrlTemplateNotValid() {
    super("Url Template annotation not found");
  }
}
