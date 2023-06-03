package configuration;

import aquality.selenium.core.utilities.ISettingsFile;

public class Configuration {
  private static final ISettingsFile environment = Environment.getCurrentEnvironment();
  private static final ISettingsFile testData = Environment.getTestData();

  private Configuration() {}

  public static String getStartUrl() {
    return environment.getValue("/startUrl").toString();
  }

  public static int getRobotDelay() {
    return (int) environment.getValue("/robotDelay");
  }

  public static int getPasswordLength() {
    return (int) testData.getValue("/passwordLength");
  }

  public static int getEmailLength() {
    return (int) testData.getValue("/emailLength");
  }

  public static boolean isEmailContainsLetters() {
    return (boolean) testData.getValue("/isEmailContainsLetters");
  }

  public static boolean isEmailContainsNumbers() {
    return (boolean) testData.getValue("/isEmailContainsNumbers");
  }

  public static boolean isDomainContainsLetters() {
    return (boolean) testData.getValue("/isDomainContainsLetters");
  }

  public static boolean isDomainContainsNumbers() {
    return (boolean) testData.getValue("/isDomainContainsNumbers");
  }

  public static int getDomainLength() {
    return (int) testData.getValue("/domainLength");
  }

  public static String getNeededTimerStart() {
    return testData.getValue("/neededTimerStart").toString();
  }

  public static int getNumberOfInterests() {
    return (int) testData.getValue("/numberOfInterests");
  }
}
