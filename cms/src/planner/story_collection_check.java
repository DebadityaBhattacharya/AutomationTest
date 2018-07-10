package planner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.cms_base;
import base.pageClass;

public class story_collection_check extends cms_base
{
	pageClass pageclass;
	@BeforeMethod
	public void create() throws IOException, InterruptedException
	{
		login_page();
	}


	@Test
	public void story_collection() throws IOException, InterruptedException
	{
		pageclass = new pageClass(driver);
		Thread.sleep(5000);
		pageclass.planner_page_wait();
		pageclass.select_website(3);
		Thread.sleep(5000);  
		pageclass.story_collection();
	}
	
	@AfterMethod
	public void close()
	{
		
		driver.close();
		
	}
}
