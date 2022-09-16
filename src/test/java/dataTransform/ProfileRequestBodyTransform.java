package dataTransform;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import pojo.ProfileRequestBody;

public class ProfileRequestBodyTransform {

	@DataTableType
	public ProfileRequestBody profileRequestBodyEntry(Map<String, String> entry) {
		ProfileRequestBody profileRequestBody = new ProfileRequestBody(entry.get("company"), entry.get("website"),
				entry.get("location"), entry.get("status"), entry.get("skills"), entry.get("githubusername"),
				entry.get("bio"), entry.get("twitter"), entry.get("facebook"), entry.get("linkedin"),
				entry.get("youtube"), entry.get("instagram"));

		return profileRequestBody;
	}

}
