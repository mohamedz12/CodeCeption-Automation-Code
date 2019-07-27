package CodeCeptionPackage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class BaseTests {

	//Driver Declaration
    public WebDriver driver;
    public File scrFile;
    @Before
    public void Setup() {
    	 
     // Driver installation		 
     System.setProperty("webdriver.chrome.driver", "./Test Artifacts/chromedriver.exe");
   	 driver=new ChromeDriver();
   	 driver.manage().window().maximize();
   	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	 
   	 
   	 // Go to https://qa.rtcamp.net/activity/
   	 driver.get("https://qa.rtcamp.net/activity/");
    }
    
    @After
    public void TearDown() {
     	
    	driver.quit();
   }
}
