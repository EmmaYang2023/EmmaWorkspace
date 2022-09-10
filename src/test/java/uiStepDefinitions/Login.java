package uiStepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.DriverFactory;
import utilities.PageManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	PageManager pages = PageManager.getInstance();

	private WebDriver driver = DriverFactory.getInstance();

	@Given("user is on the boratech login page")
	public void navigateToLoginPage() {
		pages.getHomePage().navigate();
		pages.getHomePage().clickOnLoginLink();
	}

	@When("user enters username - {string} and password - {string}")
	public void user_enters_username_and_password(String username, String password) {
		pages.getLoginPage().enterEmailAndPassword(username, password);
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		pages.getLoginPage().submitLogin();
	}

	@Given("user is logged in")
	public void user_is_logged_in(DataTable dataTable) {
		pages.getDashboardPage().validatePageLoad();
	}
}
