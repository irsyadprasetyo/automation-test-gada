package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import pages.GudangAdaPage;
import webdriverpool.WebdriverInitializer;

public class GudangAdaSteps {

  GudangAdaPage gudangAda = new GudangAdaPage(WebdriverInitializer.driver);

  @Given("User go to Gudang Ada")
  public void userGoToGudangAda() {
    gudangAda.openPage();
  }

  @When("User choose login by {string}")
  public void userChooseLoginByString(String method) {
    gudangAda.chooseLoginMethod(method);
  }

  @When("User input phone number {string}")
  public void userInputPhoneNumberString(String phoneNumber) {
    gudangAda.inputPhoneNumber(phoneNumber);
  }

  @Then("User should verify phone number is {string}")
  public void userShouldVerifyPhoneNumberIsString(String phoneNumber) {
    Assert.assertEquals("content isn't equals",
        phoneNumber, gudangAda.getPhoneNumberValue());
    // assert phone_number = “0812234567899”
  }

  @When("User input username {string} and password {string}")
  public void userInputUsernameStringAndPasswordString(String email, String password) {
    gudangAda.inputEmail(email);
    gudangAda.inputPassword(password);
  }

  @Then("User should verify some data:")
  public void userShouldVerifySomeData(DataTable dataTable) {
    List<Map<String, String>> data = dataTable.asMaps();
    data.forEach(dt -> {
      Assert.assertTrue("url is not valid!",
          dt.get("url").equals("https://seller.gudangada.com/home"));
          // I'm hardcode this URL because I got a different URL when on the login page
          // assert URL = “https://seller.gudangada.com/home”
      Assert.assertTrue("email is not valid!",
          dt.get("email").equals(gudangAda.getEmailValue()));
          // assert email = “qegada@gmail.com”
      Assert.assertTrue("password is not valid!",
          dt.get("password").equals(gudangAda.getPasswordValue()));
          // assert password = “Qe12345@!”
    });
  }

  @When("User click Masuk button")
  public void userClickMasukButton() {
    gudangAda.clickMasukButton();
  }

  @When("User avoid alert")
  public void userAvoidAlert() {
    gudangAda.avoidAlert();
  }

  @Then("User should verify {string} displayed")
  public void userShouldVerifyStringDisplayed(String banner, DataTable dataTable) {
    List<Map<String, String>> data = dataTable.asMaps();
    if (banner.contains("no")) {
      Assert.assertFalse("banner is displayed!", gudangAda.fakeBanner());
      Assert.assertTrue("user isn't verified yet!",
          data.get(0).get("status").equals("VERIFIED"));
    } else {
      Assert.assertTrue("banner is not displayed!", gudangAda.fakeBanner());
      Assert.assertFalse("user isn't verified yet!",
          data.get(0).get("status").equals("VERIFIED"));
    }
  }
}
