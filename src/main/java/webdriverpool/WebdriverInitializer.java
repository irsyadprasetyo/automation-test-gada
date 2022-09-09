package webdriverpool;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebdriverInitializer {

  //global variable / instance variable static
  public static ChromeDriver driver;

  public static void initialize(){
    //download webdriver dan setup
    WebDriverManager.chromedriver().setup();

    //nambahin incognito
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito", "--start-maximized");

    //inisialisasi webdriver
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  public static void quit(){
    driver.quit();
  }


}
