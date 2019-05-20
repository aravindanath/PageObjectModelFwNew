package pageRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//*[text()='Hello, Sign in']")
	WebElement signin;
	
	@FindBy(xpath="//*[@class='a-icon a-icon-logo']")
	WebElement amazonlogo;
	
	@FindBy(id = "ap_email")
	private WebElement amazonEmail;

	@FindBy(id = "createAccountSubmit")
	private WebElement createAccountSubmit;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	@FindBy(id = "ap_password")
	private WebElement passwordTxt;


	public void login() {
		

		signin.click();
		amazonEmail.sendKeys("automationclass2018@gmail.com");
		continueBtn.click();
		passwordTxt.sendKeys("auto2018",Keys.ENTER);
		
		
		
		
	}

}
