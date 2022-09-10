package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utilities;

public class LoginPage {

	// Local variables
	private WebDriver driver;

	// Elements
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginSubmitButton;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void enterEmailAndPassword(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
	}

	public void submitLogin() {
		loginSubmitButton.click();
		Utilities.wait(2);
	}

}
