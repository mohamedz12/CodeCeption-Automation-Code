package CodeCeptionPackage;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CodeCeptionTests extends BaseTests {
    Utilities ut=new Utilities();
   
    
	 @Test
	 public  void A_Successful_Login() throws InterruptedException, IOException {

	 // Enter valid Login creds UN: demo PW: demo
	 driver.findElement(By.name("log")).sendKeys("demo");
	 driver.findElement(By.name("pwd")).sendKeys("demo");
	 driver.findElement(By.name("wp-submit")).click();
	 
	 // Verify login successfully
	 Thread.sleep(3000);
	 Assert.assertTrue(driver.findElement(By.className("logout")).getText().contains("Log Out"));
	 //Take Screenshot
	 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(scrFile, new File("./Test Artifacts/Login Successfully.jpg"));
     }
	 
	 @Test
	 public  void B_Failed_Login() throws InterruptedException, IOException {
		 
	 // Enter valid Login creds UN: demo PW: demo123
	  driver.findElement(By.name("log")).sendKeys("demo");
	  driver.findElement(By.name("pwd")).sendKeys("demo123");
	  driver.findElement(By.name("wp-submit")).click();
		 
	 // Verify login failed
	  Thread.sleep(3000);
	  Assert.assertTrue(driver.findElement(By.id("login_error")).getText().contains("ERROR: The password you entered for the username demo is incorrect"));
	  //Take Screenshot
	  scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrFile, new File("./Test Artifacts/Login Failed.jpg"));
	 }
	 
	 @Test
	 public void C_Update_Status() throws InterruptedException, AWTException, IOException {
		 // Login
		 this.A_Successful_Login();
		 
		 //Upload media with private privacy
		 driver.findElement(By.id("whats-new")).click();
		 driver.findElement(By.id("rtmedia-add-media-button-post-update")).click();
		 Thread.sleep(2000);
		 ut.UploadFile(ut.GetPath("Test Artifacts/Image_1.jpg"));
		 Thread.sleep(3000);
		 driver.findElement(By.id("whats-new")).click();
		 driver.findElement(By.name("aw-whats-new-submit")).click();
		 Thread.sleep(10000);
		 Actions action=new Actions(driver);
		 action.moveToElement(driver.findElement(By.xpath(".//ul[@id='activity-stream']/li[1]"))).build().perform();
		 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(scrFile, new File("./Test Artifacts/Adding media post.jpg"));
	     // Verify media uploaded with private privacy	

		 Select select=new Select(driver.findElement(By.xpath(".//select[starts-with(@id,'rtm-ac-privacy-')][1]")));
		 Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Private"));
	 }
	 
	 @Test
	 public void D_CreateAlbum_UploadMedia() throws InterruptedException, AWTException, IOException {
		 //Login
		 this.A_Successful_Login();
		 //Go to https://qa.rtcamp.net/members/demo/media/album/
		 driver.get("https://qa.rtcamp.net/members/demo/media/album/");
		 //Create an album
		 driver.findElement(By.className("clicker")).click();
		 driver.findElement(By.xpath(".//a[@href='#rtmedia-create-album-modal']")).click();
		 driver.findElement(By.id("rtmedia_album_name")).sendKeys("My Custom Album");
		 driver.findElement(By.id("rtmedia_album_description")).sendKeys("Custom Album for adding 5 images");
		 driver.findElement(By.id("rtmedia_create_new_album")).click();
		 Thread.sleep(2000);
		 driver.findElements(By.className("mfp-close")).get(0).click();
		 Thread.sleep(3000);
		 driver.navigate().refresh();
		 Thread.sleep(3000);
		 //Verify Album created
		 Assert.assertTrue(driver.findElement(By.xpath(".//div[@class='rtmedia-item-title'][1]/h4")).getText().contains("My Custom Album"));
		 
		 //Click the album and add 5 media images
		 driver.findElement(By.xpath(".//div[@class='rtmedia-item-title'][1]/h4")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.id("rtm_show_upload_ui")).click();
		 Thread.sleep(3000);		
		 
		 driver.findElement(By.id("rtMedia-upload-button")).click();
		 Thread.sleep(2000);
		 Actions action=new Actions(driver);
		 action.moveToElement(driver.findElement(By.id("rtMedia-upload-button"))).build().perform();
		 Thread.sleep(2000);		 
		 
		 ut.UploadFile(ut.GetPath("Test Artifacts/Image_2.jpg"));
		 Thread.sleep(2000);
		 driver.findElement(By.id("rtMedia-upload-button")).click();
		 Thread.sleep(2000);
		 ut.UploadFile(ut.GetPath("Test Artifacts/Image_3.jpg"));
		 Thread.sleep(2000);
		 driver.findElement(By.id("rtMedia-upload-button")).click();
		 Thread.sleep(2000);
		 ut.UploadFile(ut.GetPath("Test Artifacts/Image_4.jpg"));
		 Thread.sleep(2000);
		 driver.findElement(By.id("rtMedia-upload-button")).click();
		 Thread.sleep(2000);
		 ut.UploadFile(ut.GetPath("Test Artifacts/Image_5.jpg"));
		 Thread.sleep(2000);
		 driver.findElement(By.id("rtMedia-upload-button")).click();
		 Thread.sleep(2000);
		 ut.UploadFile(ut.GetPath("Test Artifacts/Image_6.jpg"));
		 Thread.sleep(2000);
		 driver.findElement(By.className("start-media-upload")).click();
		 Thread.sleep(30000);
		 driver.navigate().refresh();
		 Thread.sleep(4000);
		 //Take Screenshot
		 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(scrFile, new File("./Test Artifacts/Create Album with 5 media images.jpg"));

		 //Click the first image to like / unlike it
		 driver.findElement(By.xpath(".//div[@class='rtmedia-item-thumbnail'][1]/img")).click();
		 Actions action1=new Actions(driver);
		 action.moveToElement(driver.findElement(By.xpath(".//div[starts-with(@id,'rtmedia-media-')]/img"))).build().perform();
		 //Click Like
		 driver.findElement(By.xpath(".//button[starts-with(@id,'rtmedia-like-button-')]")).click();
		 Thread.sleep(3000);
		 Assert.assertTrue(driver.findElement(By.xpath(".//button[starts-with(@id,'rtmedia-like-button-')]/span")).getText().contains("Unlike"));
		//Click Unlike
		 action.moveToElement(driver.findElement(By.xpath(".//div[starts-with(@id,'rtmedia-media-')]/img"))).build().perform();
		 driver.findElement(By.xpath(".//button[starts-with(@id,'rtmedia-like-button-')]")).click();
		 Thread.sleep(3000);
		 Assert.assertTrue(driver.findElement(By.xpath(".//button[starts-with(@id,'rtmedia-like-button-')]/span")).getText().contains("Like"));
		 //Click Like again
		 action.moveToElement(driver.findElement(By.xpath(".//div[starts-with(@id,'rtmedia-media-')]/img"))).build().perform();
		 driver.findElement(By.xpath(".//button[starts-with(@id,'rtmedia-like-button-')]")).click();
		 Thread.sleep(3000);
         driver.get("https://qa.rtcamp.net/members/demo/media/likes/");
         Thread.sleep(4000);
         action.moveToElement(driver.findElement(By.xpath(".//div[@class='rtmedia-item-thumbnail'][1]/img"))).perform();
         Thread.sleep(3000);
         //Verifying image there by screenshot 
         scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(scrFile, new File("./Test Artifacts/Images Liked.jpg"));
	 }
	 
	 @Test
	 public void E_Change_Cover_Image() throws InterruptedException, IOException, AWTException {
		 this.A_Successful_Login();
		 Actions action=new Actions(driver);
		 action.moveToElement(driver.findElement(By.xpath(".//a[@href='https://qa.rtcamp.net/members/demo/profile/edit/']"))).build().perform();
		 Thread.sleep(2000);
		 action.moveToElement(driver.findElement(By.xpath(".//a[@href='https://qa.rtcamp.net/members/demo/profile/']"))).build().perform();
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Change Cover Image")).click();
		 driver.findElement(By.id("bp-browse-button")).click();
		 Thread.sleep(3000);
		 ut.UploadFile(ut.GetPath("Test Artifacts/Profile pic.jpg"));
		 Thread.sleep(8000);
		 action.moveToElement(driver.findElement(By.id("header-cover-image"))).build().perform();
		 Thread.sleep(2000);	 
		//Verifying cover image there by screenshot 
         scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(scrFile, new File("./Test Artifacts/Cover Image.jpg"));
	 }
	 
}  
