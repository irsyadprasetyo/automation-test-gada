package apitest;

import org.junit.Test;
import controller.GadaApiController;
import org.hamcrest.Matchers;

public class ApiTest {

  GadaApiController gada = new GadaApiController();

  @Test
  public void createNewDriver() {
    String payload = "{" +
        "   \"email\":\"test@gmail.com\",\n" +
        "   \"password\":\"admin123\"\n" +
        "   \"phone_number\":\"081209871234\"\n" +
        "   \"name\":\"test admin\"\n" +
        "   \"date_of_birth\":\"1999-09-19\"\n" +
        "   \"license_type\":\"SIM_C\"\n" +
        "   \"license_expiry_date\":\"2024-09-19\"\n" +
        "}";
    gada.postDriverRegistration(payload)
        .assertThat().statusCode(201)
        .assertThat().body("success", Matchers.equalTo("true"))
        .assertThat().body("message", Matchers.equalTo("registration successful!"));
  }

  @Test
  public void getDriverStatus() {
    gada.getDriverRegistrationStatus("test@gmail.com")
        .assertThat().statusCode(200)
        .assertThat().body("success", Matchers.equalTo("true"))
        .assertThat().body("message", Matchers.equalTo("REGISTERED!"));
  }

  @Test
  public void driverLogin() {
    gada.postDriverLogin("test@gmail.com", "admin123")
        .assertThat().statusCode(200)
        .assertThat().body("success", Matchers.equalTo("true"))
        .assertThat().body("message", Matchers.equalTo("successfully logged in!"));
  }
}
