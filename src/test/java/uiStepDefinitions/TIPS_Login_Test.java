package uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.PageManager;

public class TIPS_Login_Test {
	
	PageManager pages = PageManager.getInstance();
	
	@Given("I'm on Appian Loginpage")
	public void i_m_on_appian_loginpage() {
	   pages.getLoginPage().navigate();
	}

	@And("I enter username {userName} and password {password}")
	public void i_enter_username_and_password(String userName, String password) {
	 
		pages.getLoginPage().enterUserNameAndPassword(userName, password);
	}

	@And("Click SIGN IN")
	public void click_sign_in() {
	   
		pages.getLoginPage().submitLogin();
	}

	@Then("I should be logged in")
	public void i_should_be_logged_in() {
	   
		
	}

	@Then("See the Dashboard page")
	public void see_the_dashboard_page() {
	    
		
	}
}
