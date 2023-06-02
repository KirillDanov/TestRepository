package forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
  private final IButton startButton =
      getElementFactory()
          .getButton(By.xpath("//a[contains(@class, 'start__link')]"), "Start button");
  public MainPage() {
    super(By.xpath("//button[contains(@class, 'start__button')]"), "Main page");
  }

  public void clickStartBtn() {
    startButton.clickAndWait();
  }
}
