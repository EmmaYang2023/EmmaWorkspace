package NonCucumberFrameworkTest;

import org.openqa.selenium.Keys;

import utilities.DriverFactory;
import utilities.Keywords;

public class SeleniumTestWithObjectRepository {

	public static void main(String[] args) {

		try {
			Keywords.open(); 
			Keywords.clearAndEnter("HomePage.SearchField", "bora-cs" + Keys.ENTER);

			System.out.println(Keywords.getText("SearchResultPage.Title"));

			Keywords.click("SearchResultPage.Sort");
			Keywords.click("SearchResultPage.Sort.MostStars");
			Keywords.wait(2);

			Keywords.getAll("SearchResultPage.ResultList.Links").get(0).click();

			String author = Keywords.getText("RepoPage.Author");
			String repoName = Keywords.getText("RepoPage.RepoName");

			System.out.println("Author: " + author + " Repo: " + repoName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverFactory.cleanup();
		}

	}

}
