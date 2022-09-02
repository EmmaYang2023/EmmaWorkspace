package apiStepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import api.BoraAPI;

public class APIStepDefinitions {

	@Given("[API] user is logged in")
	public void apiLogin(DataTable dataTable) {
		Map<String, String> credential = dataTable.asMaps().get(0);
		String token = BoraAPI.login(credential.get("username"), credential.get("password"));
		System.out.println("Token: " + token);
	}

}
