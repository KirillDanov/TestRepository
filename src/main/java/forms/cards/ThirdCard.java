package forms.cards;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ThirdCard extends Form {
  public ThirdCard() {
    super(
        By.xpath("//div[contains(@class, 'page-indicator')][contains(text(), '3 / 4')]"),
        "Personal details page");
  }
}
