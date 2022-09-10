package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostsPage {
	private WebDriver driver;

	@FindBy(tagName = "textarea")
	private WebElement textAreaField;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement postSubmitButton;

	public PostsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterPostComment(String comment) {
		textAreaField.sendKeys(comment);
	}

	public void submitPost() {
		postSubmitButton.click();
	}

}
