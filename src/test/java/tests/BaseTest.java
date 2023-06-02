package tests;

import aquality.selenium.browser.AqualityServices;
import configuration.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

  @BeforeMethod
  protected void beforeMethod() {
    AqualityServices.getBrowser().goTo(Configuration.getStartUrl());
    AqualityServices.getBrowser().maximize();
  }

  @AfterMethod
  public void afterTest() {
    if (AqualityServices.isBrowserStarted()) {
      AqualityServices.getBrowser().quit();
    }
  }
}
