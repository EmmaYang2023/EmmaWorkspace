package uiStepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import utilities.PageManager;

public class Posts {

	private PageManager pages = PageManager.getInstance();

	@When("user enters the post comment")
	public void user_enters_the_post_comment(DataTable dataTable) {
		pages.getPostsPage().enterPostComment(dataTable);
	}

	@When("user submits the post")
	public void user_clicks_on_the_submit_button() {
		pages.getPostsPage().submitPost();
	}

}
