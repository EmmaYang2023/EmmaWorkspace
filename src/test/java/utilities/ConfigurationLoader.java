package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationLoader {

	private static FileInputStream fis = null;
	private static Properties props = null;

	public static void prepare() {
		try {
			fis = new FileInputStream("src/test/resources/properties/Configuration.properties");
			props = new Properties();
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get(String configuration) {
		if (props == null) {
			prepare();
		}

		return props.getProperty(configuration);
	}

}
