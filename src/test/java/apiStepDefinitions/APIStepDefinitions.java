package apiStepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.Utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import api.BoraAPI;

public class APIStepDefinitions {

	public String token;

	@Given("[API] user is logged in")
	public void apiLogin(DataTable dataTable) {
		Map<String, String> credential = dataTable.asMaps().get(0);
		token = BoraAPI.login(credential.get("username"), credential.get("password"));
		System.out.println("Token: " + token);
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
	public void api_user_adds_an_education(DataTable dataTable) {
		Map<String, String> educationInput = dataTable.asMaps().get(0);
		Map<String, Object> education = new HashMap<>();

		for (Entry<String, String> entry : educationInput.entrySet()) {
			if (entry.getKey().equals("current")) {
				education.put(entry.getKey(), Boolean.getBoolean(entry.getValue()));
			} else {
				education.put(entry.getKey(), entry.getValue());
			}
		}

		BoraAPI.addEducation(education, token);
	}

	@Then("[API] [ERROR] user adds an education")
	public void api_error_user_adds_an_education(DataTable dataTable) {
		Map<String, String> educationInput = dataTable.asMaps().get(0);
		Map<String, Object> education = new HashMap<>();

		String errors = educationInput.get("errors");
		String[] expectedErrors = null;
		if (errors != null && !errors.isEmpty()) {
			expectedErrors = errors.split(",");
			for (int i = 0; i < expectedErrors.length; i++) {
				expectedErrors[i] = expectedErrors[i].trim();
			}
		}

		for (Entry<String, String> entry : educationInput.entrySet()) {
			if (entry.getKey().equals("current")) {
				education.put(entry.getKey(), Boolean.getBoolean(entry.getValue()));
			} else if (entry.getKey().equals("errors")) {
				continue;
			} else {
				education.put(entry.getKey(), entry.getValue());
			}
		}

		BoraAPI.addEducationErrorScenario(education, token, expectedErrors);
	}

}
