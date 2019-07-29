package CodeCeptionPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Utilities extends BaseTests{
	    BaseTests base=new BaseTests();
	    
	public void UploadFile(String filepath) throws AWTException, InterruptedException {
	     Robot robot=null;
		 StringSelection strSel = new StringSelection(filepath);
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
		 String os=System.getProperty("os.name").toLowerCase();
		if(os.contains("win"))  // In case WIN machine
		{
			robot=new Robot();
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);				 
		 Thread.sleep(3000);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 }else if(os.contains("mac"))  // In case MAC machine
		 {
		  driver.switchTo().window(driver.getWindowHandle());
		  Thread.sleep(2000);
	       robot=new Robot();
	         // Bring GoTo window
			 //robot.keyPress(KeyEvent.VK_META);			 
			 //robot.keyPress(KeyEvent.VK_TAB);			  
			 //robot.keyRelease(KeyEvent.VK_META);		  
			 //robot.keyRelease(KeyEvent.VK_TAB);
			 robot.delay(2000);
			 Thread.sleep(3000);
		     robot.keyPress(KeyEvent.VK_META);
	         robot.keyPress(KeyEvent.VK_SHIFT);
	         robot.keyPress(KeyEvent.VK_G);
	         robot.keyRelease(KeyEvent.VK_META);
	         robot.keyRelease(KeyEvent.VK_SHIFT);
	         robot.keyRelease(KeyEvent.VK_G);
	         //Paste the clipboard value
	         Thread.sleep(1000);
	         robot.keyPress(KeyEvent.VK_META);
	         robot.keyPress(KeyEvent.VK_V);
	         robot.keyRelease(KeyEvent.VK_META);
	         robot.keyRelease(KeyEvent.VK_V);
	         Thread.sleep(1000);
	         //Press Enter key to close the Goto window and Upload window
	         robot.keyPress(KeyEvent.VK_ENTER);
	         robot.keyRelease(KeyEvent.VK_ENTER);
	         robot.delay(500);
	         robot.keyPress(KeyEvent.VK_ENTER);
	         robot.keyRelease(KeyEvent.VK_ENTER);
	         }
	}
	
	public String GetPath(String filepath) {
		File file=new File(filepath);
		return file.getAbsolutePath();		
	}
	
}
