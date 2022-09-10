package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NavBar {

	private WebDriver driver;

	public NavBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLinkByLinkText(String navigationLinkText) {
		driver.findElement(By.linkText(navigationLinkText)).click();
	}

}
