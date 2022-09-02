package api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BoraAPI {

	public static String login(String username, String password) {
		RestAssured.baseURI = "https://boratech.herokuapp.com";
		String endpoint = "/api/auth";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		HashMap<String, String> body = new HashMap<>();
		body.put("email", username);
		body.put("password", password);
		request.body(body);

		Response response = request.post(endpoint);
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;

		assertEquals(actualStatusCode, expectedStatusCode);

		String token = response.jsonPath().get("token");

		assertNotNull(token);
		assertTrue(token != "");
		return token;
	}

}
