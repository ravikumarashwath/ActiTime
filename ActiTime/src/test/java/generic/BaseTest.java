package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public WebDriverWait wait;
	
  @BeforeMethod	
  public void openApp() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  String ito = Utils.getPPTValue("ITO");
	  Integer ito1 = Integer.valueOf(ito); //converting String to Integer
	  driver.manage().timeouts().implicitlyWait(ito1, TimeUnit.SECONDS);
	  
	  String eto = Utils.getPPTValue("ETO");
	  Integer eto1 = Integer.valueOf(eto); //converting String to Integer
	  wait = new WebDriverWait(driver, eto1);
	  
	  String url = Utils.getPPTValue("URL");
	  driver.get(url);
  }
  
  @AfterMethod
  public void closeApp() {
	  driver.close();
  }
  
  
}
