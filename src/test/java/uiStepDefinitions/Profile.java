package uiStepDefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class Profile {

	private WebDriver driver = DriverFactory.getInstance();

	@Then("user clicks the Add Experience button")
	public void user_clicks_the_add_experience_button() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(@href, '/add-experience')]")).click();
		Thread.sleep(1000);
	}

	@When("user enters experiences")
	public void user_enters_experiences(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> experience = dataTable.asMaps().get(0);
		driver.findElement(By.xpath("//input[@placeholder='* Job Title']")).sendKeys(experience.get("jobtitle"));
		driver.findElement(By.name("company")).sendKeys(experience.get("company"));
		driver.findElement(By.name("location")).sendKeys(experience.get("company"));
		driver.findElement(By.name("from")).sendKeys(experience.get("from"));
		driver.findElement(By.xpath("//input[@name='current']")).click();
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(experience.get("description"));
	}
}
