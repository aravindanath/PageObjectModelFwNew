package pageRepo;

import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.JavaUtils;

public class HomePage  extends BasePage{
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	@FindBy(css = "#twotabsearchtextbox")
	WebElement search;
	
	@FindBy(xpath = "//img[@src='https://m.media-amazon.com/images/I/81JL4QleolL._AC_UL320_.jpg']")
	WebElement raymond;
	
	

	protected HashMap<String, String> hp;


	public void searchProduct(String workflowid) throws InterruptedException {
		
		hp = JavaUtils.readExcelData("Search", workflowid);
	
		search.sendKeys(hp.get("PRODUCT"),Keys.ENTER);
		
//		Thread.sleep(2000);
//		//raymond.click();
//		Thread.sleep(2000);
		
		
		
		
	}
	
	

}
