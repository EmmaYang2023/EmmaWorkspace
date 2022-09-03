package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utilities.DriverFactory;

public class AddEducation {

	private WebDriver driver = DriverFactory.getInstance();

	@Then("User updates {string}")
	public void user_updates(String string, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		Map<String, String> addEducation = dataTable.asMaps().get(0);
		driver.findElement(By.linkText("Add Education")).click();
		driver.findElement(By.name("school")).sendKeys(addEducation.get("school"));
		driver.findElement(By.name("degree")).sendKeys(addEducation.get("degree"));
		driver.findElement(By.name("fieldofstudy")).sendKeys(addEducation.get("fieldofstudy"));
		driver.findElement(By.name("from")).sendKeys(addEducation.get("from date"));
		if (!addEducation.get("current").equals(null)) {
			driver.findElement(By.name("current")).click();
		}
		driver.findElement(By.tagName("textarea")).sendKeys(addEducation.get("description"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
	}

}
