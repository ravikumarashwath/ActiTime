package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	@FindBy(name="username")
	private WebElement unTB;

	@FindBy(name="pwd")
	private WebElement pwTB;

	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginButton;

	@FindBy(xpath="//span[contains(text(),'invalid')]")
	private WebElement errorMsg;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String un) {
		unTB.sendKeys(un);
	}

	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public boolean VerifyErrorMsg(WebDriverWait wait) {

		try {
			wait.until(ExpectedConditions.visibilityOf(errorMsg));
			return true;
		} 
		catch (Exception e) {
			return false;
		}


	}
	
	
}
