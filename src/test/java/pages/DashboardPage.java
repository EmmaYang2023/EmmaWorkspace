package pages;

import static org.junit.jupiter.api.Assertions.*;

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

}
