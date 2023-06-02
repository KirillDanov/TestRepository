package configuration;

public class Configuration {

  private Configuration() {}

  public static String getStartUrl() {
    return Environment.getCurrentEnvironment().getValue("/startUrl").toString();
  }

  public static int getRobotDelay() {
    return (int) Environment.getCurrentEnvironment().getValue("/robotDelay");
  }

  public static int getPasswordLength() {
    return (int) Environment.getTestData().getValue("/passwordLength");
  }

  public static int getEmailLength() {
    return (int) Environment.getTestData().getValue("/emailLength");
  }

  public static boolean isEmailContainsLetters() {
    return (boolean) Environment.getTestData().getValue("/isEmailContainsLetters");
  }

  public static boolean isEmailContainsNumbers() {
    return (boolean) Environment.getTestData().getValue("/isEmailContainsNumbers");
  }

  public static boolean isDomainContainsLetters() {
    return (boolean) Environment.getTestData().getValue("/isDomainContainsLetters");
  }

  public static boolean isDomainContainsNumbers() {
    return (boolean) Environment.getTestData().getValue("/isDomainContainsNumbers");
  }

  public static int getDomainLength() {
    return (int) Environment.getTestData().getValue("/domainLength");
  }

  public static String getNeededTimerStart() {
    return Environment.getTestData().getValue("/neededTimerStart").toString();
  }

  public static int getNumberOfInterests() {
    return (int) Environment.getTestData().getValue("/numberOfInterests");
  }
}
