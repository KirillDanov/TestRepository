package tests;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTestClass {
  @BeforeMethod
  public static void beforeMethod() {
    RestAssured.filters(
        new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());
  }
}
