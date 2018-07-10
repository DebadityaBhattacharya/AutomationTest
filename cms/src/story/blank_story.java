package story;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.cms_base;
import base.login;
import base.pageClass;


public class blank_story extends cms_base
{
	pageClass pageclass;

	@BeforeMethod
	public void create() throws IOException, InterruptedException
	{
		login_page();
	}
	
	@Test
	public void story_create() throws IOException, InterruptedException
	{
	
		pageclass = new pageClass(driver); 
		pageclass.planner_page_wait();
		pageclass.select_website(3);
		Thread.sleep(5000); 
		pageclass.newstory_click();
		Thread.sleep(2000);
		pageclass.blankstory_click();
		Thread.sleep(2000);
		pageclass.textfill();
		pageclass.submit_story();
		Thread.sleep(10000);
		Assert.assertEquals(pageclass.storycreate_wait(),"a few seconds ago");
	}
	
	@AfterMethod
	public void close()
	{
		
		driver.close();
		
	}
	
}
