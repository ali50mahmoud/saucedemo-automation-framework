package stepdefinitions;

import java.time.Duration; 
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;

	

public class Hooks {	
	        
	public static  WebDriver driver;
	
	        
	@Before
	 public static void open_browser()
	        {
	        String chrome=System.getProperty("user.dir")+"\\Chrome_Driver\\chromedriver.exe";
	    	System.setProperty("webdriver.chrome.driver", chrome);
  // ************************configure options parameter to Chrome driver************************//
	        driver=new ChromeDriver();
	        driver.manage().window().setSize(new Dimension(1024, 768)); // browser resolution is 1024x768px
	        driver.manage().window().maximize(); // to maximize browser's windows
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
	   
	        }

    @After
     public static void quit_browser() 
	       {
		    new WebDriverWait(Hooks.driver,Duration.ofSeconds(30));
//            driver.quit(); 	

	       } 
	    }




