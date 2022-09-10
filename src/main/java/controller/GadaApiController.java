package controller;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.regex.Matcher;

public class GadaApiController {

  private static String URL = "https://gada.com";

  public ValidatableResponse postDriverRegistration(String payload) {
    return RestAssured.given()
        .header("Content-Type", "application/json")
        .body(payload).baseUri(URL).basePath("/driver/registration/create/")
        .when().post().then().log().all();
  }

  public ValidatableResponse getDriverRegistrationStatus(String email) {
    return RestAssured.given().queryParam("email", email)
        .header("Content-Type", "application/json")
        .baseUri(URL).basePath("/driver/registration/status/check")
        .when().get().then().log().all();
  }

  public ValidatableResponse postDriverLogin(String email, String password) {
    String payload = "{" +
        "   \"email\":\"${email}\",\n" +
        "   \"password\":\"${password}\"\n" +
        "}";

    return RestAssured.given()
        .header("Content-Type", "application/json")
        .body(payload).baseUri(URL).basePath("/driver/registration/create/")
        .when().post().then().log().all();
  }
}
