package com.example.utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class HelperClass {
 
     private static HelperClass helperClass;
      
        private static WebDriver driver;
        public final static int TIMEOUT = 10;
           
         private HelperClass(String browser) {
                
        	 if(browser.equals("chrome"))
        	 { 
        		 System.out.println("I am chrome");   
        	 WebDriverManager.chromedriver().setup();
        	 ChromeOptions options = new ChromeOptions();
        	 options.addArguments("--remote-allow-origins=*");
        	 DesiredCapabilities cp = new DesiredCapabilities();
        	 cp.setCapability(ChromeOptions.CAPABILITY, options);
        	 options.merge(cp);
             driver = new ChromeDriver(options);
        	 }
        	 else
        	 {   
        		WebDriverManager.edgedriver().setup();
     			driver = new EdgeDriver();
        	 }
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
             driver.manage().window().maximize();
             System.out.println("I am chrome 2");
         }      
                   
        public static void openPage(String url) {
        	System.out.println("I am chrome 3");
            driver.get(url);
        }
               
        public static WebDriver getDriver() {
        	System.out.println("I am chrome 4");
            return driver;              
        }
           
        public static void setUpDriver(String browser) {
            System.out.println("I am here");   
        	helperClass = new HelperClass(browser);
          //  if (helperClass==null) {
                   
            //    helperClass = new HelperClass();
            //}
        }
           
        public static void tearDown() {
                
            //if(driver!=null) {
                 driver.close();
                 driver.quit();
            //}
                
           helperClass = null;
       } 
           
    }
