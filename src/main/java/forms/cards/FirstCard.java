package forms.cards;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import configuration.Configuration;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import utilities.RandomUtil;

public class FirstCard extends Form {
  private final IButton nextBtn =
      getElementFactory()
          .getButton(By.xpath("//a[contains(@class,'button--secondary')]"), "Next btn");
  private final ITextBox passwordBox =
      getElementFactory()
          .getTextBox(
              By.xpath("//input[contains(@placeholder,'Choose Password')]"), "Password textBox");
  private final ITextBox emailBox =
      getElementFactory()
          .getTextBox(By.xpath("//input[contains(@placeholder,'Your email')]"), "Email textBox");
  private final ITextBox domainBox =
      getElementFactory()
          .getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"), "Domain textBox");
  private final IButton domainEndDropdown =
      getElementFactory()
          .getButton(By.xpath("//div[contains(@class,'dropdown__field')]"), "Dropdown list");
  private final IButton hideHelpBtn =
      getElementFactory()
          .getButton(
              By.xpath("//button[contains(@class,'help-form__send-to-bottom-button')]"),
              "Help hide button");
  private final ILabel helpLabel =
      getElementFactory()
          .getLabel(By.xpath("//h2[contains(@class,'help-form__title')]"), "Help label");
  private final ICheckBox termsCheckBox =
      getElementFactory()
          .getCheckBox(By.xpath("//span[contains(@class,'checkbox__check')]"), "Terms checkBox");
  private final ILabel cookies =
      getElementFactory().getLabel(By.xpath("//div[contains(@class,'cookies')]"), "Cookies label");
  private final IButton acceptCookiesBtn =
      getElementFactory()
          .getButton(By.xpath("//button[contains(text(),'Not really, no')]"), "Accept cookies btn");
  private final ILabel timer =
      getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer')]"), "Timer");
  private final List<IButton> domainEnds =
      getElementFactory()
          .findElements(
              By.xpath("//div[contains(@class,'dropdown__list-item')]"),
              IButton.class,
              ElementState.EXISTS_IN_ANY_STATE);
  private String randomEmail;

  public FirstCard() {
    super(
        By.xpath("//div[contains(@class, 'page-indicator')][contains(text(), '1 / 4')]"),
        "Register page");
  }

  public void clickNextBtn() {
    nextBtn.clickAndWait();
  }

  public void sendPassword() {
    String randomPassword =
        RandomUtil.getRandomStringWithCyrillic(Configuration.getPasswordLength(), randomEmail);
    passwordBox.clearAndType(randomPassword);
  }

  public void sendEmail() {
    randomEmail =
        RandomStringUtils.random(
            Configuration.getEmailLength(),
            Configuration.isEmailContainsLetters(),
            Configuration.isEmailContainsNumbers());
    emailBox.clearAndType(randomEmail);
  }

  public void sendDomain() {
    String randomDomain =
        RandomStringUtils.random(
            Configuration.getDomainLength(),
            Configuration.isDomainContainsLetters(),
            Configuration.isDomainContainsNumbers());
    domainBox.clearAndType(randomDomain.toLowerCase());
  }

  public void changeDomainEnd() {
    domainEndDropdown.click();
    Random random = new Random();
    int randomEnd = random.nextInt(domainEnds.size());
    domainEnds.get(randomEnd).click();
  }

  public void uncheckCheckBox() {
    termsCheckBox.check();
  }

  public void fillUserData() {
    sendEmail();
    sendDomain();
    changeDomainEnd();
    sendPassword();
  }

  public void clickHideHelpBtn() {
    hideHelpBtn.click();
    helpLabel.state().waitForNotDisplayed();
  }

  public boolean isHelpDisplayed() {
    return helpLabel.state().isDisplayed();
  }

  public void clickAcceptCookiesBtn() {
    acceptCookiesBtn.click();
    cookies.state().waitForNotDisplayed();
  }

  public boolean isCookiesDisplayed() {
    return cookies.state().isDisplayed();
  }

  public boolean isTimerStartsFromZero() {
    String timerStart = timer.getText().substring(0, 5);
    String neededTimerStart = Configuration.getNeededTimerStart();
    return (timerStart.equals(neededTimerStart));
  }
}
