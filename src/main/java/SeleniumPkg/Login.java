package SeleniumPkg;

import java.sql.Time;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	WebDriver driver;
	SoftAssert sa;
	@BeforeTest
	public void setup()
	{
		ChromeOptions op = new ChromeOptions();
		op.setHeadless(true);
	    sa = new SoftAssert();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(op);
	}
	@Test (priority = 0)
	public void loginvalid()
	{
		driver.get("https://demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys("mngr427049");
		driver.findElement(By.name("password")).sendKeys("ehuqYtA");
		driver.findElement(By.name("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Manger Id : mngr427049')]")));
		sa.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Manger Id : mngr427049')]")).getText(),"Manger Id : mngr427049");
	}
	
	@Test  (priority = 1)
	public void invalidTest()
	{
		driver.get("https://demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys("mngr427041");
		driver.findElement(By.name("password")).sendKeys("ehuqYtA");
		driver.findElement(By.name("btnLogin")).click();
		sa.assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
		driver.switchTo().alert().accept();
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver.quit();
		sa.assertAll();
	}
	
	

}
