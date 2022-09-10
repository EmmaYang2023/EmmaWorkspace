package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// Local variables
	private WebDriver driver;
	private static final String URL = "https://boratech.herokuapp.com/";

	// Elements
	@FindBy(how = How.XPATH, using = "//a[text()='Login']")
	private WebElement loginLinkButton;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void navigate() {
		driver.get(URL);
	}

	public void clickOnLoginLink() {
		loginLinkButton.click();
	}

}
