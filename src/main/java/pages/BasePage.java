package pages;

import annotations.PagePath;
import annotations.Url;
import annotations.UrlTemplate;
import exceptions.DataUrlNotValid;
import exceptions.UrlTemplateNotValid;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.GuiceScoped;

public abstract class BasePage<T> {

  public BasePage(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
    PageFactory.initElements(guiceScoped.driver, this);
  }

  protected GuiceScoped guiceScoped;

  private String getPath() {
    Class<?> clazz = this.getClass();
    if(clazz.isAnnotationPresent(PagePath.class)) {
      PagePath pagePath = clazz.getAnnotation(PagePath.class);
      return pagePath.value().replaceAll("/+$", "");
    }

    return "";
  }

  private String getPageUrlTemplate(String name) throws UrlTemplateNotValid {
    Class<?> clazz = this.getClass();
    if(clazz.isAnnotationPresent(Url.class)) {
      Url urlTemplates = clazz.getAnnotation(Url.class);
      UrlTemplate[] templates = urlTemplates.value();
      for(UrlTemplate urlTemplate: templates) {
        if(urlTemplate.name().equals(name)) {
          return urlTemplate.template();
        }
      }
      throw new UrlTemplateNotValid();
    }
    return "";
  }

  public T open(String name, String... values) throws Exception {
    if(values.length == 0) {
      throw new DataUrlNotValid();
    }
    String template = this.getPageUrlTemplate(name);
    String pathFromTemplate = "";
    for(int i =0; i < values.length; i++) {
      pathFromTemplate = template.replace(String.format("{%s}", i + 1), values[i]);
    }

    String hostname = System.getProperty("base.url");
    hostname = hostname.replaceAll("/+$", "");

    if(!this.getPath().isEmpty()) {
      guiceScoped.driver.get(hostname + this.getPath() + "/" + pathFromTemplate);
    } else {
      guiceScoped.driver.get(hostname + "/" + pathFromTemplate);
    }

    return (T)this;
  }

  @FindBy(tagName = "h1")
  private WebElement header;

  public T open() {
    guiceScoped.driver.get(System.getProperty("base.url"));

    return (T) this;
  }

  public T pageHeaderShouldBeSameAs(String header) {
    assert this.header.getText().equals(header): "Error: Заголовок на странице не корректный";

    return (T) this;
  }

}
