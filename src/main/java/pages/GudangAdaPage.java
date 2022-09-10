package pages;

import java.sql.Driver;
import java.sql.DriverAction;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GudangAdaPage {

  // global/instance variable
  ChromeDriver driver;

  // constructors
  public GudangAdaPage(ChromeDriver driver) {
    this.driver = driver;
  }

  public void openPage() {
    driver.get("https://seller.gudangada.com");
  }

  public void chooseLoginMethod(String method) {
    String element = "";
    if (method.contains("phone number")) {
      element = "//*[@id=\"__next\"]/div/div[2]/div[1]/div/div/button[1]";
    } else {
      element = "//*[@id=\"__next\"]/div/div[2]/div[1]/div/div/button[2]";
    }
    WebElement loginMethod = driver.findElementByXPath(element);
    loginMethod.click();
  }

  public void inputPhoneNumber(String number) {
    WebElement phoneNumber = driver.findElementById("phoneNumber");
    phoneNumber.sendKeys(number);
  }

  public String getPhoneNumberValue() {
    WebElement phoneNumber = driver.findElementById("phoneNumber");
    return phoneNumber.getAttribute("value");
  }

  public void clickPoweredByLink() {
    WebElement poweredByLink = driver.findElementById("poweredBy");
    poweredByLink.click();
  }

  public void inputEmail(String email) {
    WebElement user = driver.findElementById("email");
    user.sendKeys(email);
  }

  public String getEmailValue() {
    WebElement value = driver.findElementById("email");
    return value.getAttribute("value");
  }

  public void inputPassword(String password) {
    WebElement pwd = driver.findElementById("password");
    pwd.sendKeys(password);
  }

  public String getPasswordValue() {
    clickShowPassword();
    WebElement value = driver.findElementById("password");
    return value.getAttribute("value");
  }

  public void clickShowPassword() {
    WebElement button = driver.findElementByCssSelector(
        ".MuiIconButton-sizeMedium.css-1yxmbwk");
    button.click();
  }

  public void clickMasukButton() {
    WebElement button = driver.findElementByXPath(
        "//*[@id='__next']/div/div[2]/div[3]/div/form/button");
    button.click();
  }

  public void avoidAlert() {
    By ele = By.xpath("//*[@id='__next']/div[2]/div[1]/div/div/div/div");
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
  }

  public Boolean fakeBanner() {
    try {
      WebElement banner = driver.findElementByXPath("//*[@id='__next']/div[2]/div[1]/div/div/div/div");
      return banner.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
