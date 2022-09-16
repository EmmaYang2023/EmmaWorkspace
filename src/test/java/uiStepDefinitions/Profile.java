package uiStepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pojo.*;
import utilities.PageManager;

public class Profile {

	private PageManager pages = PageManager.getInstance();

	@Then("^user clicks the (\"Add Experience\"|\"Add Education\") button$")
	public void addEducationOrAddExperience(String target) throws InterruptedException {
		pages.getDashboardPage().clickAddExperienceOrAddEducationButton(target);
	}

	@When("user adds an experience")
	public void user_enters_experiences(List<Experience> experiences) {
		for (Experience experience : experiences) {
			pages.getAddExperiencePage().addExperience(experience);
		}
	}

	@Then("user adds an education")
	public void user_updates_add_education(List<Education> educations) {
		for (Education education : educations) {
			pages.getAddEducationPage().addEducation(education);
		}
	}

	@Then("user should see the newly added education crendential")
	public void user_should_see_the_newly_added_education_crendential(DataTable dataTable) {
		Map<String, String> educationAdded = dataTable.asMaps().get(0);
		pages.getDashboardPage().validateEducationExists(educationAdded.get("school"), educationAdded.get("degree"));
	}
	
	@When("user creates\\/updates the profile")
	public void user_creates_updates_the_profile(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		pages.getDashboardPage().clickOnEditProfile();
		pages.getEditProfilePage().enterProfileData(data);
	}

}
