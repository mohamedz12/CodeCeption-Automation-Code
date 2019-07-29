package CodeCeptionPackage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class BaseTests {

	//Driver Declaration
    public static WebDriver driver;
    public File scrFile;
    @Before
    public void Setup() {
    	 
     // Detect current OS
    String osname = System.getProperty("os.name").toLowerCase();
    System.out.println(osname);
     // Driver installation
    if(osname.contains("win"))
    {
     System.setProperty("webdriver.chrome.driver", "./Test Artifacts/chromedriver.exe");
     driver=new ChromeDriver();	
     driver.manage().window().maximize();
    }else if(osname.contains("mac"))
    {
     System.setProperty("webdriver.chrome.driver", "./Test Artifacts/chromedriver");
     driver=new ChromeDriver();
     driver.manage().window().setSize(new Dimension(1500, 1200));
    }
   	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	 
   	 
   	 // Go to https://qa.rtcamp.net/activity/
   	 driver.get("https://qa.rtcamp.net/activity/");
    }
    
    @After
    public void TearDown() {
     	
    	driver.quit();
   }
}
