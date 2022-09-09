package dataTransform;

import java.util.Map;

import io.cucumber.java.DataTableType;
import pojo.Experience;

public class ExperienceTransform {

	@DataTableType
	public Experience experienceEntry(Map<String, String> entry) {
		Experience experience = new Experience(entry.get("title"), entry.get("company"), entry.get("location"),
				entry.get("from"), entry.get("to"), Boolean.valueOf(entry.get("current")), entry.get("description"),
				"");
		return experience;
	}

}
