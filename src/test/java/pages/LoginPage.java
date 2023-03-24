package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utilities;

public class LoginPage {

	// Local variables
	private WebDriver driver;
	private static final String URL = "https://sercona-test.serco.cms/";

	// Elements
	@FindBy(xpath = "//usernameXpath")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement signInSubmitButton;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void navigate() {
		driver.get(URL);
	}

	public void enterUserNameAndPassword(String userName, String password) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
	}

	public void submitLogin() {
		signInSubmitButton.click();
	}

	public void userIsLoggedIn(String email, String password) {
		this.navigate();
		this.enterUserNameAndPassword(email, password);
		this.submitLogin();
	}

}
