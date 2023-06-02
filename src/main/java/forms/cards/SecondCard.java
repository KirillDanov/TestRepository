package forms.cards;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import configuration.Configuration;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import utilities.FileUtil;
import utilities.RandomUtil;

public class SecondCard extends Form {
  private final ILabel upload =
      getElementFactory()
          .getLabel(
              By.xpath("//a[contains(@class, 'avatar-and-interests__upload-button')]"),
              "Upload photo");
  private final By allCheckBoxesLocator = By.xpath("//span[contains(@class, 'checkbox__box')]");
  private final IButton nextButton =
      getElementFactory().getButton(By.xpath("//button[contains(text(), 'Next')]"), "Next button");
  private final ILabel imageUploaded =
      getElementFactory()
          .getLabel(
              By.xpath("//div[contains(@class, 'avatar-and-interests__avatar-image')]"),
              "Upload check");

  public SecondCard() {
    super(
        By.xpath("//div[contains(@class, 'page-indicator')][contains(text(), '2 / 4')]"),
        "Upload photo page");
  }

  public void chooseRandomInterests(int numberOfInterests) {
    List<ICheckBox> allCheckBoxes =
        getElementFactory().findElements(allCheckBoxesLocator, ICheckBox.class);
    int numberOfCheckboxes = allCheckBoxes.size();
    allCheckBoxes.get(numberOfCheckboxes - 1).click();
    Set<Integer> setOfInterests =
        RandomUtil.getSetOfRandomUniqueNumbers(numberOfInterests, numberOfCheckboxes - 1);
    for (Integer i : setOfInterests) {
      allCheckBoxes.get(i).check();
    }
  }

  public void sendPhoto() throws AWTException, URISyntaxException {
    int robotDelay = Configuration.getRobotDelay();
    upload.click();
    Robot robot = new Robot();
    robot.delay(robotDelay);
    StringSelection selection =
        new StringSelection(FileUtil.getAbsoluteFilePathFromResoursesAsString("image.jpg"));
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.delay(robotDelay);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.delay(robotDelay);
    robot.keyRelease(KeyEvent.VK_ENTER);
    imageUploaded.state().waitForDisplayed();
  }

  public void clickNextBtn() {
    nextButton.click();
  }
}
