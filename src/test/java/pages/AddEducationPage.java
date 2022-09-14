package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pojo.Education;

public class AddEducationPage {

	private WebDriver driver;

	@FindBy(name = "school")
	private WebElement schoolField;

	@FindBy(name = "degree")
	private WebElement degreeField;

	@FindBy(name = "fieldofstudy")
	private WebElement fieldOfStudyField;

	@FindBy(name = "from")
	private WebElement fromDateField;

	@FindBy(name = "current")
	private WebElement currentCheckbox;

	@FindBy(name = "to")
	private WebElement toDateField;

	@FindBy(tagName = "textarea")
	private WebElement descriptionField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;

	public AddEducationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addEducation(Education education) {
		schoolField.sendKeys(education.school);
		degreeField.sendKeys(education.degree);
		fieldOfStudyField.sendKeys(education.fieldofstudy);
		fromDateField.sendKeys(education.from);
		if (education.current) {
			currentCheckbox.click();
		} else {
			toDateField.sendKeys(education.to);
		}
		descriptionField.sendKeys(education.description);
		submitButton.click();
	}

}
