package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pojo.Experience;

public class AddExperiencePage {

	private WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='* Job Title']")
	private WebElement jobTitleField;

	@FindBy(name = "company")
	private WebElement companyField;

	@FindBy(name = "location")
	private WebElement locationField;

	@FindBy(name = "from")
	private WebElement fromDateField;

	@FindBy(xpath = "//input[@name='current']")
	private WebElement isCurrentJobCheckbox;

	@FindBy(name = "to")
	private WebElement toDateField;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement descriptionField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;

	public AddExperiencePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addExperience(Experience experience) {
		jobTitleField.sendKeys(experience.title);
		companyField.sendKeys(experience.company);
		locationField.sendKeys(experience.location);
		fromDateField.sendKeys(experience.from);
		if (experience.current) {
			isCurrentJobCheckbox.click();
		} else {
			toDateField.sendKeys(experience.to);
		}
		descriptionField.sendKeys(experience.description);
		submitButton.click();
	}

}
