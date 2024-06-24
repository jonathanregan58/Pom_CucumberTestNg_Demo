package com.example.actions;

import com.example.locators.HomePageLocators;
import com.example.utils.HelperClass;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class HomePageActions {
 
    HomePageLocators homePageLocators = null;
 
    public HomePageActions() {
 
        this.homePageLocators = new HomePageLocators();
        PageFactory.initElements(HelperClass.getDriver(),homePageLocators);
    }
 
    // Get the User name from Home Page
    public String getHomePageText() {
    	 WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(180)); 
    	 wait.until(ExpectedConditions.visibilityOfElementLocated((By) homePageLocators.homePageUserName));
        return homePageLocators.homePageUserName.getText();
    }
    
    //Get URL of home page
    public String getURLHomePage() {
    	HelperClass.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    	String URL = HelperClass.getDriver().getCurrentUrl();
        return URL;
    }
 
}