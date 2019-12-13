package pageRepo;

import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.JavaUtils;

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

	
	@FindBy(xpath="//input[@name='uid']")
	private WebElement userID;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	private WebElement loginBtn;
	
	protected HashMap<String, String> lp;


	public void login(String workflowid) {
		
		lp = JavaUtils.readExcelData("Login", workflowid);
		

		signin.click();
		amazonEmail.sendKeys(lp.get("USERNAME"));
		continueBtn.click();
		passwordTxt.sendKeys(lp.get("PASSWORD"),Keys.ENTER);
		
	}

	public void loginGuruBank(String workflowid) {
		lp = JavaUtils.readExcelData("Login", workflowid);
		
		Assert.assertEquals(driver.getTitle(),"Guru99 Bank Home Page","Mis match in title");
		
		userID.sendKeys(lp.get("USERNAME"));
		
		password.sendKeys(lp.get("PASSWORD"),Keys.ENTER);
		
		
	}
	
}
