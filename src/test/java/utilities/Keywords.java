package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utilities.ObjectRepository.locator;

import java.util.List;

public class Keywords {

	private static WebDriver driver = DriverFactory.getInstance();
	private static final String APP_URL = ConfigurationLoader.get("APPLICATION_URL");
	private static final boolean DEMO_MODE = Boolean.valueOf(ConfigurationLoader.get("DEMO_MODE"));

	public static void open() {
		try {
			if (APP_URL != null && !APP_URL.isEmpty()) {
				driver.get(APP_URL);
			} else {
				throw new Exception("Application URL is not available in configuration");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void open(String url) {
		try {
			if (url != null && !url.isEmpty()) {
				driver.get(url);
			} else {
				throw new Exception("Invalid url");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebElement get(String objectName) {
		return driver.findElement(locator(objectName));
	}

	public static List<WebElement> getAll(String objectName) {
		return driver.findElements(locator(objectName));
	}

	public static void click(String objectName) {
		highlight(objectName);
		get(objectName).click();
	}

	public static void clearAndEnter(String objectName, String dataToEnter) {
		WebElement element = get(objectName);
		highlight(element);
		element.clear();
		element.sendKeys(dataToEnter);
	}

	public static String getText(String objectName) {
		highlight(objectName);
		return get(objectName).getText();
	}

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void wait(double seconds) {
		try {
			Thread.sleep((int) (seconds * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void highlight(WebElement element) {
		if (DEMO_MODE) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			for (int i = 1; i <= 3; i++) {
				js.executeScript(
						"arguments[0].setAttribute('style', 'background-color: yellow; border: 2px solid red')",
						element);
				wait(0.15);
				if (i != 3) {
					js.executeScript("arguments[0].setAttribute('style', '')", element);
					wait(0.15);
				}
			}
		}
	}

	public static void highlight(String objectName) {
		WebElement element = get(objectName);
		highlight(element);
	}

}
