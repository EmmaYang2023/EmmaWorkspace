package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utilities.DriverFactory;
import utilities.PageManager;

public class Main {

	@Before("@ui or @UI")
	public void prepare() {
		DriverFactory.getInstance();
		PageManager.getInstance();
	}

	@After
	public void teardown() {
		DriverFactory.cleanup();
		PageManager.cleanup();
	}

}
