package api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Education;
import pojo.LoginRequestBody;
import pojo.ProfileRequestBody;

public class BoraAPI {

	public static String login(LoginRequestBody body) {
		RestAssured.baseURI = "https://boratech.herokuapp.com";
		String endpoint = "/api/auth";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		request.body(body);

		Response response = request.post(endpoint);
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;

		assertEquals(expectedStatusCode, actualStatusCode);

		String token = response.jsonPath().get("token");

		assertNotNull(token);
		assertTrue(token != "");
		return token;
	}

	public static Response createOrUpdateProfile(ProfileRequestBody profileRequestBody, String token) {
		RestAssured.baseURI = "https://boratech.herokuapp.com";
		String endpoint = "/api/profile";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		request.header("x-auth-token", token);

		request.body(profileRequestBody);

		Response response = request.post(endpoint);
		return response;
	}

	public static void addExperience(Map<String, Object> experience, String token, String[] expectedErrors) {
		RestAssured.baseURI = "https://boratech.herokuapp.com";
		String endpoint = "/api/profile/experience";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		request.header("x-auth-token", token);

		request.body(experience);

		Response response = request.put(endpoint);
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = expectedErrors == null ? 200 : 400;
		assertEquals(actualStatusCode, expectedStatusCode);

		if (expectedErrors == null) {
			// Happy path
			ArrayList<Map<String, Object>> experiences = response.jsonPath().get("experience");
			boolean found = false;
			for (Map<String, Object> exp : experiences) {
				if (exp.get("title").equals(experience.get("title"))) {
					found = true;
				}
			}

			assertTrue(found, "The newly added experience was not found ");
		} else {
			// Unhappy path
			ArrayList<String> actualErrors = response.jsonPath().get("errors.msg");
			assertEquals(expectedErrors.length, actualErrors.size(),
					"Number of errors received doesn't match the number of errors expected");
			for (String expectedError : expectedErrors) {
				assertTrue(actualErrors.contains(expectedError),
						"The expected error [" + expectedError + "] was not found in the actual error list");
			}
		}

	}

	public static Response addEducation(Education education, String token) {
		RestAssured.baseURI = "https://boratech.herokuapp.com";
		String endpoint = "/api/profile/education";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		request.header("x-auth-token", token);

		request.body(education);

		Response response = request.put(endpoint);
		return response;
	}

	public static void addEducationHappyPathValidation(Response response, Education expectedEducation) {
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;
		assertEquals(expectedStatusCode, actualStatusCode);

		ArrayList<Map<String, Object>> educations = response.jsonPath().get("education");
		boolean found = false;
		for (Map<String, Object> edu : educations) {
			if (edu.get("school").equals(expectedEducation.school)) {
				found = true;
			}
		}

		assertTrue(found, "The newly added education was not found ");
	}

	public static void addEducationErrorPathValidation(Response response, String[] expectedErrors) {
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 400;
		assertEquals(expectedStatusCode, actualStatusCode);

		ArrayList<String> actualErrors = response.jsonPath().get("errors.msg");
		assertEquals(expectedErrors.length, actualErrors.size(),
				"Number of errors received doesn't match the number of errors expected");
		for (String expectedError : expectedErrors) {
			assertTrue(actualErrors.contains(expectedError),
					"The expected error [" + expectedError + "] was not found in the actual error list");
		}
	}

}
