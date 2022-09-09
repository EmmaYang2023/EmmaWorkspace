package uiStepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pojo.Education;
import pojo.Experience;
import utilities.DriverFactory;

public class Profile {

	private WebDriver driver = DriverFactory.getInstance();

	@Then("^user clicks the (\"Add Experience\"|\"Add Education\") button$")
	public void addEducationOrAddExperience(String target) throws InterruptedException {
		System.out.println("==> target " + target);
		driver.findElement(By.xpath("//*[contains(text(), " + target + ")]")).click();
		System.out.println("==> Clicked on add experience button");
		Thread.sleep(2000);
	}

	@When("user adds an experience")
	public void user_enters_experiences(List<Experience> experiences) {
		for (Experience experience : experiences) {
			driver.findElement(By.xpath("//input[@placeholder='* Job Title']")).sendKeys(experience.title);
			driver.findElement(By.name("company")).sendKeys(experience.company);
			driver.findElement(By.name("location")).sendKeys(experience.location);
			driver.findElement(By.name("from")).sendKeys(experience.from);
			if (experience.current) {
				driver.findElement(By.xpath("//input[@name='current']")).click();
			} else {
				driver.findElement(By.name("to")).sendKeys(experience.to);
			}
			driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(experience.description);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
		}
	}

	@Then("user adds an education")
	public void user_updates_add_education(List<Education> educations) {
		for (Education education : educations) {
			driver.findElement(By.name("school")).sendKeys(education.school);
			driver.findElement(By.name("degree")).sendKeys(education.degree);
			driver.findElement(By.name("fieldofstudy")).sendKeys(education.fieldofstudy);
			driver.findElement(By.name("from")).sendKeys(education.from);
			if (education.current) {
				driver.findElement(By.name("current")).click();
			} else {
				driver.findElement(By.name("to")).sendKeys(education.to);
			}
			driver.findElement(By.tagName("textarea")).sendKeys(education.description);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
		}
	}
}
