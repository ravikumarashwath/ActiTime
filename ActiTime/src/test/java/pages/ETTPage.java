package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ETTPage {

	@FindBy(id="logoutLink")
	private WebElement logoutLink;

	public ETTPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickLogout() {
		logoutLink.click();
	}

	public boolean VerifyTitle(WebDriverWait wait, String expected) {
		try {
			wait.until(ExpectedConditions.titleContains(expected));
			return true;
		}
		catch (Exception e) {
			return false;
		}

	}

}
