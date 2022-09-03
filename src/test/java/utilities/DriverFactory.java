package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver = null;
	private static final String BASE_DRIVER_PATH = "src/test/resources/drivers/";
	private static final String CHROMEDRIVER_MAC = BASE_DRIVER_PATH + "chromedriver_mac_m1";
	private static final String CHROMEDRIVER_WINDOWS = BASE_DRIVER_PATH + "chromedriver_windows.exe";

	private DriverFactory() {
	}

	public static WebDriver getInstance() {
		try {
			if (driver == null) {
				String driverPath = getChromeDriverPath();
				System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//				driver.manage().window().maximize();	
			}
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void cleanup() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public static String getChromeDriverPath() throws Exception {
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("mac")) {
			return CHROMEDRIVER_MAC;
		} else if (osName.contains("windows")) {
			return CHROMEDRIVER_WINDOWS;
		} else {
			throw new Exception("ChromeDriver not available for system: " + osName);
		}
	}

}
