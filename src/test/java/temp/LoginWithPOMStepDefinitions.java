package temp;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import utilities.DriverFactory;
import utilities.PageManager;

public class LoginWithPOMStepDefinitions {

	private PageManager pages = PageManager.getInstance();

	@After
	public void teardown() {
		DriverFactory.cleanup();
	}

	@Given("[POM] user is on the homepage")
	public void pom_user_is_on_the_homepage() {
		pages.getHomePage().navigate();
	}

	@Given("[POM] user clicks on the login link button")
	public void pom_user_clicks_on_the_login_link_button() {
		pages.getHomePage().clickOnLoginLink();
	}

	@When("[POM] user enters email and password")
	public void pom_user_enters_email_and_password(DataTable dataTable) {
		Map<String, String> credentials = dataTable.asMaps().get(0);
		pages.getLoginPage().enterEmailAndPassword(credentials.get("email"), credentials.get("password"));
	}

	@When("[POM] user clicks on submit login button")
	public void pom_user_clicks_on_submit_login_button() {
		pages.getLoginPage().submitLogin();
	}

	@Then("[POM] user should be on the dashboard page")
	public void pom_user_should_be_on_the_dashboard_page() {
		pages.getDashboardPage().validatePageLoad();
	}

}
