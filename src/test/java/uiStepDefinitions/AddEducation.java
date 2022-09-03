package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utilities.DriverFactory;

public class AddEducation {

	private WebDriver driver = DriverFactory.getInstance();

	@Then("User updates {string}")
	public void user_update_add_education(String string) throws InterruptedException {

		driver.findElement(By.linkText("Add Education")).click();
		driver.findElement(By.name("school")).sendKeys("BoraTech");
		driver.findElement(By.name("degree")).sendKeys("Test Automation Degree");
		driver.findElement(By.name("fieldofstudy")).sendKeys("Test Automation");
		driver.findElement(By.name("from")).sendKeys("05/07/2022");
		driver.findElement(By.name("current")).click();
		driver.findElement(By.tagName("textarea")).sendKeys("This is fun");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);

	}

	@And("user should see the success alert for add education")
	public void user_should_see_the_success_alert_works() {
		try {
			assertTrue(driver.findElement(By.cssSelector(".alert.alert-success")).isDisplayed());
		} catch (NoSuchElementException e) {
			assertTrue(false, "The success alert was not found");
		}
	}

}
