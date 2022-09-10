package uiStepDefinitions;

import io.cucumber.java.en.*;
import utilities.PageManager;

public class Common {

	private PageManager pages = PageManager.getInstance();

	@When("user clicks on the {string} navigation link")
	public void user_clicks_on_the_navigation_link(String navigationLinkText) {
		pages.getNavBar().clickOnLink(navigationLinkText);
	}

	@Then("user should be navigated to the {string} page")
	public void user_should_be_navigated_to_the_page(String pageTitle) {
		pages.getPostsPage().validatePostPageLost(pageTitle);
	}

	@Then("user should see the success alert")
	public void user_should_see_the_success_alert() {
		pages.getCommonPage().validateSuccessAlert();
	}

}
