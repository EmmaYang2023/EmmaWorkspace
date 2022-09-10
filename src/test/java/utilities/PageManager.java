package utilities;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageManager {

	private static PageManager pageManager;
	private WebDriver driver;

	private HomePage homePage;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;

	public static PageManager getInstance() {
		if (pageManager == null) {
			pageManager = new PageManager(DriverFactory.getInstance());
		}
		return pageManager;
	}

<<<<<<< Updated upstream
=======
	public static void cleanup() {
		pageManager = null;
	}

>>>>>>> Stashed changes
	private PageManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		if (homePage == null) {
			this.homePage = new HomePage(driver);
		}
		return this.homePage;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			this.loginPage = new LoginPage(driver);
		}
		return this.loginPage;
	}

	public DashboardPage getDashboardPage() {
		if (dashboardPage == null) {
			this.dashboardPage = new DashboardPage(driver);
		}
		return this.dashboardPage;
	}

}
