package uiStepDefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class Posts {

	private WebDriver driver = DriverFactory.getInstance();

	@When("user enters the post comment")
	public void user_enters_the_post_comment(DataTable dataTable) {
		Map<String, String> comment = dataTable.asMaps().get(0);
		driver.findElement(By.tagName("textarea")).sendKeys(comment.get("comment"));
	}

	@When("user clicks on the submit button")
	public void user_clicks_on_the_submit_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
