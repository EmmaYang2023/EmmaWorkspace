package utilities;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageManager {

	private static PageManager pageManager;
	private WebDriver driver;

	private HomePage homePage;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private NavBar navBar;
	private PostsPage postsPage;
	private CommonPage commonPage;

	public static PageManager getInstance() {
		if (pageManager == null) {
			pageManager = new PageManager(DriverFactory.getInstance());
		}
		return pageManager;
	}

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

	public NavBar getNavBar() {
		if (navBar == null) {
			this.navBar = new NavBar(driver);
		}
		return this.navBar;
	}

	public PostsPage getPostsPage() {
		if (postsPage == null) {
			this.postsPage = new PostsPage(driver);
		}
		return this.postsPage;
	}

	public CommonPage getCommonPage() {
		if (commonPage == null) {
			this.commonPage = new CommonPage(driver);
		}
		return this.commonPage;
	}

}
