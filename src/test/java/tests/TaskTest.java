package tests;

import configuration.Configuration;
import forms.cards.FirstCard;
import forms.cards.SecondCard;
import forms.cards.ThirdCard;
import forms.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TaskTest extends BaseTest {

  @Test(testName = "Registration")
  public void testRegistration() {
    MainPage mainPage = new MainPage();
    Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page is not open");
    mainPage.clickStartBtn();
    FirstCard firstCard = new FirstCard();
    Assert.assertTrue(firstCard.state().waitForDisplayed(), "First card is not open");
    firstCard.fillUserData();
    firstCard.uncheckCheckBox();
    firstCard.clickNextBtn();
    SecondCard secondCard = new SecondCard();
    Assert.assertTrue(secondCard.state().waitForDisplayed(), "Second card is not open");
    secondCard.sendPhoto();
    secondCard.chooseRandomInterests(Configuration.getNumberOfInterests());
    secondCard.clickNextBtn();
    ThirdCard thirdCard = new ThirdCard();
    Assert.assertTrue(thirdCard.state().waitForDisplayed(), "Third card is not open");
  }

  @Test(testName = "Hide help")
  public void testHideHelp() {
    MainPage mainPage = new MainPage();
    Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page isn`t open");
    mainPage.clickStartBtn();
    FirstCard firstCard = new FirstCard();
    Assert.assertTrue(firstCard.state().waitForDisplayed(), "First card isn`t open");
    firstCard.clickHideHelpBtn();
    Assert.assertFalse(firstCard.isHelpDisplayed(), "Help box is still displayed");
  }

  @Test(testName = "Accept cookies")
  public void testAcceptCookies() {
    MainPage mainPage = new MainPage();
    Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page isn`t open");
    mainPage.clickStartBtn();
    FirstCard firstCard = new FirstCard();
    Assert.assertTrue(firstCard.state().waitForDisplayed(), "Register page isn`t open");
    firstCard.clickAcceptCookiesBtn();
    Assert.assertFalse(firstCard.isCookiesDisplayed(), "Cookies box is still displayed");
  }

  @Test(testName = "Is timer starts from zero")
  public void testTimerTime() {
    MainPage mainPage = new MainPage();
    Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page isn`t open");
    mainPage.clickStartBtn();
    FirstCard firstCard = new FirstCard();
    Assert.assertTrue(firstCard.state().waitForDisplayed(), "Register page isn`t open");
    Assert.assertTrue(firstCard.isTimerStartsFromZero(), "Timer does`t start from 00:00:00");
  }
}
