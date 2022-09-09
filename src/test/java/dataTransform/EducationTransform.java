package dataTransform;

import java.util.Map;

import io.cucumber.java.DataTableType;
import pojo.Education;

public class EducationTransform {

	@DataTableType
	public Education educationConvert(Map<String, String> entry) {
		Education education = new Education(Boolean.valueOf(entry.get("current")), entry.get("_id"),
				entry.get("school"), entry.get("degree"), entry.get("fieldofstudy"), entry.get("from"), entry.get("to"),
				entry.get("description"));
		return education;
	}

}