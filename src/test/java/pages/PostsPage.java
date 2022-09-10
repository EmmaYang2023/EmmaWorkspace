package pages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;

public class PostsPage {
	private WebDriver driver;

	@FindBy(css = ".large.text-primary")
	private WebElement titleTextElement;
	@FindBy(tagName = "textarea")
	private WebElement textAreaField;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement postSubmitButton;

	public PostsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validatePostPageLost(String pageTitle) {
		String titleText = titleTextElement.getText();
		assertEquals(pageTitle, titleText);
	}

	public void enterPostComment(DataTable dataTable) {
		Map<String, String> comment = dataTable.asMaps().get(0);
		textAreaField.sendKeys(comment.get("comment"));
	}

	public void submitPost() {
		postSubmitButton.click();
	}

}
