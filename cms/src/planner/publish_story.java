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
	pageClass pageclass;
	
	@BeforeMethod
	public void create() throws IOException, InterruptedException
	{
		login_page();
	}


	@Test
	public void story_publish() throws IOException, InterruptedException, AWTException
	{
		pageclass = new pageClass(driver);
		Thread.sleep(5000);
		pageclass.planner_page_wait();
		pageclass.select_website(3);
		Thread.sleep(5000); 
		pageclass.page_scroll(250);
		Thread.sleep(3000);
		pageclass.openstoryblock_click();
		Thread.sleep(1000);
		pageclass.planner_horizontal_scroll(6);
		Thread.sleep(2000);
		pageclass.publishStory();
		
	}
	
	@AfterMethod
	public void close()
	{
		
		//driver.close();
		
	}
	
}
