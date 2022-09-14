package uiStepDefinitions;

import java.util.List;

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
}
