package pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Utilities;

public class EditProfilePage {

	private WebDriver driver;

	@FindBy(name = "status")
	private WebElement statusSelectElement;

	@FindBy(name = "company")
	private WebElement companyInput;

	@FindBy(name = "website")
	private WebElement websiteInput;

	@FindBy(name = "location")
	private WebElement locationInput;

	@FindBy(name = "skills")
	private WebElement skillsInput;

	@FindBy(name = "githubusername")
	private WebElement githubUsernameInput;

	@FindBy(name = "bio")
	private WebElement bioInput;

	@FindBy(xpath = "//button[text()='Add Social Network Links']")
	private WebElement addSocialButton;

	@FindBy(name = "linkedin")
	private WebElement linkedinInput;

	@FindBy(name = "instagram")
	private WebElement instagramInput;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;

	public EditProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterProfileData(Map<String, String> data) {
		Select statusSelect = new Select(statusSelectElement);
		statusSelect.selectByVisibleText(data.get("status"));
		Utilities.clearAndEnter(companyInput, data.get("company"));
		Utilities.clearAndEnter(websiteInput, data.get("website"));
		Utilities.clearAndEnter(locationInput, data.get("location"));
		Utilities.clearAndEnter(skillsInput, data.get("skills"));
		Utilities.clearAndEnter(githubUsernameInput, "githubusername");
		Utilities.clearAndEnter(bioInput, data.get("bio"));
		addSocialButton.click();
		Utilities.clearAndEnter(linkedinInput, data.get("linkedin"));
		Utilities.clearAndEnter(instagramInput, data.get("instagram"));
		submitButton.click();
	}

}
