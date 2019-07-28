package CodeCeptionPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Utilities extends BaseTests{
	 
	public void UploadFile(String filepath) throws AWTException, InterruptedException {
		 Robot robot=new Robot();
		 StringSelection strSel = new StringSelection(filepath);
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);				 
		 Thread.sleep(3000);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public String GetPath(String filepath) {
		File file=new File(filepath);
		return file.getAbsolutePath();		
	}
	
}
