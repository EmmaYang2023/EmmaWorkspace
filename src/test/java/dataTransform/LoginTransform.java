package dataTransform;

import java.util.Map;

import io.cucumber.java.DataTableType;
import pojo.LoginRequestBody;

public class LoginTransform {

	@DataTableType
	public LoginRequestBody loginEntry(Map<String, String> entry) {
		LoginRequestBody loginRequestBody = new LoginRequestBody(entry.get("email"), entry.get("password"));
		return loginRequestBody;
	}

}
