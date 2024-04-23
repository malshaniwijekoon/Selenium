package Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    WebDriver driver;

    By homePageUserName = By.xpath("//table//tr[@class='heading3']");
    By country = By.xpath("//table//tr[@class='heading3']");
    
    

    public HomePage(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page
    
    public void selectCountry(String countryvalue){
    	
    	Select selectCountry = new Select( driver.findElement(country));
    	selectCountry.selectByValue(countryvalue);

 

       }
       

        public String getHomePageDashboardUserName(){

         return    driver.findElement(homePageUserName).getText();

        }
        

}
