package TestClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.Select;

	public class Login {

	    WebDriver driver;

	    LoginPage objLogin;

	    HomePage objHomePage;

	    @BeforeTest

	    public void setup() throws FileNotFoundException, IOException{

	    	WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
	        driver.get("http://demo.guru99.com/V4/");
	        
	           
	    }

	    /**

	     * This test case will login in http://demo.guru99.com/V4/

	     * Verify login page title as guru99 bank

	     * Login to application

	     * Verify the home page using Dashboard message
	     * @throws ParseException 
	     * @throws IOException 
	     * @throws FileNotFoundException 

	     */

	    @Test(priority=1)

	    public void test_Home_Page_Appear_Correct() throws FileNotFoundException, IOException{

	        //Create Login Page object

	    objLogin = new LoginPage(driver);

	    //Verify login page title

	    String loginPageTitle = objLogin.getLoginTitle();

	    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

	    //login to application

	    objLogin.loginToGuru99("mgr123", "mgr!23");

	    // go the next page
	    WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='heading3']/td")));
	    objHomePage = new HomePage(driver);

	    //Verify home page

	    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
        driver.close();
        driver.quit();
	    }
	}
