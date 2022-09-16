package apiStepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import pojo.Education;
import pojo.LoginRequestBody;
import pojo.ProfileRequestBody;
import utilities.Utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import api.BoraAPI;

public class APIStepDefinitions {

	private String token;
	private Education education;
	private Response response;

	@Given("[API] user is logged in")
	public void apiLogin(List<LoginRequestBody> LoginRequestBodies) {
		LoginRequestBody body = LoginRequestBodies.get(0);
		token = BoraAPI.login(body);
	}

	@Then("[API] user adds an experience")
	public void api_user_adds_an_experience(DataTable dataTable) {
		for (Map<String, String> experienceInput : dataTable.asMaps()) {

			String errors = experienceInput.get("errors");
			String[] expectedErrors = null;
			if (errors != null && !errors.isEmpty()) {
				expectedErrors = errors.split(",");
				for (int i = 0; i < expectedErrors.length; i++) {
					expectedErrors[i] = expectedErrors[i].trim();
				}
			}

			Map<String, Object> experience = new HashMap<>();

			for (Entry<String, String> entry : experienceInput.entrySet()) {
				if (entry.getKey().equals("current")) {
					experience.put(entry.getKey(), Boolean.getBoolean(entry.getValue()));
				} else if (entry.getKey().equals("title") && entry.getValue() != null && !entry.getValue().isEmpty()) {
					experience.put(entry.getKey(), entry.getValue() + Utilities.generateRandomNumbers());
				} else if (entry.getKey().equals("errors")) {
					continue;
				} else {
					experience.put(entry.getKey(), entry.getValue());
				}
			}

			BoraAPI.addExperience(experience, token, expectedErrors);

		}

	}

	@Then("[API] user adds an education")
	public void api_user_adds_an_education(List<Education> educations) {
		education = educations.get(0);
		response = BoraAPI.addEducation(education, token);
	}

	@Then("[API] user should be able to validate the newly added education")
	public void api_user_should_be_able_to_validate_the_newly_added_education() {
		BoraAPI.addEducationHappyPathValidation(response, education);
	}

	@Then("[API] user should receive the expected error messages")
	public void api_user_should_receive_the_expected_error_messages(DataTable dataTable) {
		Map<String, String> input = dataTable.asMaps().get(0);
		String errors = input.get("errors");
		String[] expectedErrors = errors.split(",");
		for (int i = 0; i < expectedErrors.length; i++) {
			expectedErrors[i] = expectedErrors[i].trim();
		}
		BoraAPI.addEducationErrorPathValidation(response, expectedErrors);
	}

	@When("[API] user creates\\/updates the profile")
	public void api_user_creates_updates_the_profile(@Transpose ProfileRequestBody profileRequestBody) {
		response = BoraAPI.createOrUpdateProfile(profileRequestBody, token);
	}

	@Then("[API] user should receive the created\\/updated profile")
	public void api_user_should_receive_the_created_updated_profile() {
		assertEquals(200, response.getStatusCode());
	}

}
