package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
  private Specifications() {}

  public static RequestSpecification getRequestSpec(String url, ContentType contentType) {
    return new RequestSpecBuilder().setBaseUri(url).setContentType(contentType).build();
  }

  public static ResponseSpecification getResponseSpec(int statusCode, ContentType requiredType) {
    return new ResponseSpecBuilder()
        .expectStatusCode(statusCode)
        .expectContentType(requiredType)
        .build();
  }

  public static void installSpecifications(
      RequestSpecification request, ResponseSpecification response) {
    RestAssured.requestSpecification = request;
    RestAssured.responseSpecification = response;
  }
}
