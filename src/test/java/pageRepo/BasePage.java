package pageRepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage {
	
	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	
	public  static void assertImg(WebElement element) {
		
	Assert.assertEquals(element.isDisplayed(), true,"Image is not present!");
	
		
		
	}
	
	
	 
}
