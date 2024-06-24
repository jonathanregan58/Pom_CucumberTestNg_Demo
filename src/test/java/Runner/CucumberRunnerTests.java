package Runner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.example.utils.HelperClass;
import com.steps.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
//@CucumberOptions(tags = "", features = "src/test/resources/features/LoginPage.feature", glue = "com.steps",
//plugin= {"pretty", "html:test-output","json:target/cucumber/cucumber.json", "html:target/cucumber-html-report"})

@CucumberOptions(
		
		features = "src/test/resources/Features",
		glue="com.steps"
		,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		,monochrome = true
		,publish = true
		,tags = "@MissingUsername"
		//"@InvalidCredentials"
		//"@ValidCredentials"
		//"@InvalidCredentials"
		//
		//"@MissingUsername"
		//"@ValidCredentials"
		//"@MissingUsername"
		)
 
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
	//@BeforeClass
	//@Parameters({"browser"})
	//public void setup(String browser) {
		//Hooks.setUp(browser);
		// TODO Auto-generated method stub

	//}
	
	@BeforeClass
	@Parameters({"browser"})
    public static void setUp(String browser) {
       System.out.println("tes");
       HelperClass.setUpDriver(browser);
    }
 
    
	
}
