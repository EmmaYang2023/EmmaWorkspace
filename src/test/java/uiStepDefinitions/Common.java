package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class Common {

	private WebDriver driver = DriverFactory.getInstance();

	@When("user clicks on the {string} navigation link")
	public void user_clicks_on_the_navigation_link(String navigationLinkText) {
		driver.findElement(By.linkText(navigationLinkText)).click();
	}

	@Then("user should be navigated to the {string} page")
	public void user_should_be_navigated_to_the_page(String pageTitle) {
		String titleText = driver.findElement(By.cssSelector(".large.text-primary")).getText();
		assertEquals(pageTitle, titleText);
	}

	@Then("user should see the success alert")
	public void user_should_see_the_success_alert() {
		try {
			assertTrue(driver.findElement(By.cssSelector(".alert.alert-success")).isDisplayed());
		} catch (NoSuchElementException e) {
			assertTrue(false, "The success alert was not found");
		}
	}

}
