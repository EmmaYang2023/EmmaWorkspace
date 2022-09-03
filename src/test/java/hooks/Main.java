package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utilities.DriverFactory;

public class Main {

	@Before("@ui or @UI")
	public void prepare() {
		DriverFactory.getInstance();
	}

	@After("@ui or @UI")
	public void teardown() {
		DriverFactory.cleanup();
	}

}
