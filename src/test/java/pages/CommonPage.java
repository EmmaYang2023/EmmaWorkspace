package pages;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	private WebDriver driver;

	@FindBy(css = ".large.text-primary")
	private WebElement titleTextElement;
	@FindBy(css = ".alert.alert-success")
	private WebElement successAlert;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validatePageTitle(String pageTitle) {
		String titleText = titleTextElement.getText();
		assertEquals(pageTitle, titleText);
	}

	public void validateSuccessAlert() {
		try {
			assertTrue(successAlert.isDisplayed());
		} catch (NoSuchElementException e) {
			assertTrue(false, "The success alert was not found");
		}
	}
}
