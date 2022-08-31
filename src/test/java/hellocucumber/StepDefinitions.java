package hellocucumber;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

	private WebDriver driver;

	@Before
	public void prepare() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Given("user is on the boratech login page")
	public void user_is_on_the_boratech_login_page() {
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

	@Then("user should be navigated to the Dashboard page")
	public void user_should_be_navigated_to_the_dashboard_page() {
		String titleText = driver.findElement(By.cssSelector(".large.text-primary")).getText();
		assertEquals("Dashboard", titleText);
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.contains("dashboard"));
	}

}
