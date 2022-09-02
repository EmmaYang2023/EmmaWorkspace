package uiStepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinitions {

	private WebDriver driver;

	@Before("@ui or @UI")
	public void prepare() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().window().maximize();
	}

	@After("@ui or @UI")
	public void teardown() {
		driver.quit();
	}

	@Given("user is on the boratech login page")
	public void navigateToLoginPage() {
		driver.get("https://boratech.herokuapp.com/login");
		String titleText = driver.findElement(By.cssSelector(".large.text-primary")).getText();
		assertEquals("Sign In", titleText);
	}

	@When("user enters username - {string} and password - {string}")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
	}

	@Given("user is logged in")
	public void user_is_logged_in(DataTable dataTable) {
		Map<String, String> credentials = dataTable.asMaps().get(0);
		driver.get("https://boratech.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(credentials.get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(credentials.get("password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@When("user clicks on the {string} navigation link")
	public void user_clicks_on_the_navigation_link(String navigationLinkText) {
		driver.findElement(By.linkText(navigationLinkText)).click();
	}

	@Then("user should be navigated to the {string} page")
	public void user_should_be_navigated_to_the_page(String pageTitle) {
		String titleText = driver.findElement(By.cssSelector(".large.text-primary")).getText();
		assertEquals(pageTitle, titleText);
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.contains(pageTitle.toLowerCase()));
	}

	@When("user enters the post comment")
	public void user_enters_the_post_comment(DataTable dataTable) {
		Map<String, String> comment = dataTable.asMaps().get(0);
		driver.findElement(By.tagName("textarea")).sendKeys(comment.get("comment"));
	}

	@When("user clicks on the submit button")
	public void user_clicks_on_the_submit_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
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
