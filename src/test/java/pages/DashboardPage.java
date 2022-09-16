package pages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utilities;

public class DashboardPage {

	// Local Variables
	private WebDriver driver;

	// Elements
	@FindBy(xpath = "//p[@class='lead']")
	private WebElement subtitleText;

	@FindBy(xpath = "//table[2]/tbody/tr")
	private List<WebElement> educationTableRows;

	@FindBy(xpath = "//a[@href='/edit-profile']")
	private WebElement editProfileLink;

	// Constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validatePageLoad() {
		assertTrue(subtitleText.getText().contains("Welcome"), "Sign In Failed, not on Dashboard Page");
	}

	public void clickAddExperienceOrAddEducationButton(String target) {
		driver.findElement(By.xpath("//*[contains(text(), " + target + ")]")).click();
		Utilities.wait(2);
	}

	public void validateEducationExists(String school, String degree) {
		boolean found = false;
		for (WebElement educationTableRow : educationTableRows) {
			String rowText = educationTableRow.getText();
			if (rowText.contains(school) && rowText.contains(degree)) {
				found = true;
				break;
			}
		}
		assertTrue(found, "Education expected was not found");
	}

	public void clickOnEditProfile() {
		editProfileLink.click();
	}

}
