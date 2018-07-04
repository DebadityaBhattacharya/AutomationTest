package planner;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.cms_base;
import base.pageClass;

public class publish_story extends cms_base
{

	@BeforeMethod
	public void create() throws IOException, InterruptedException
	{
		login_page();
	}


	@Test
	public void story_publish() throws IOException, InterruptedException, AWTException
	{
		pageClass pageclass = new pageClass();
		PageFactory.initElements(driver, pageclass);
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".addStory"))));
		 
		pageclass.select_website(3);
		Thread.sleep(5000); 
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		
		Thread.sleep(3000);
		
		pageclass.openstoryblock_click();
		
		
		
		Thread.sleep(1000);
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[6]/div/div/h3/span")));
	
		Thread.sleep(2000);
		pageclass.publishStory();
		
	}
	
	@AfterMethod
	public void close()
	{
		
		//driver.close();
		
	}
	
}
