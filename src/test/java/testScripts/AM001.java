package testScripts;

import org.testng.annotations.Test;

import pageRepo.HomePage;
import pageRepo.LoginPage;

public class AM001 extends BaseTest {
	/**
	 * @author aravindanathdm
	 * @throws InterruptedException
	 * 
	 *             TC001 : User must login to amzon.com and search samsung 9 and add
	 *             to cart.
	 */
	@Test
	public void AM001() throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.login("AM_LG01");
		
		HomePage hp = new HomePage(driver);
		hp.searchProduct("AM_SC_001");

	}

}
