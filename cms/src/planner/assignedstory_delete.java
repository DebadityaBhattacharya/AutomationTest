package planner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.cms_base;
import base.pageClass;

public class assignedstory_delete extends cms_base
{
	@BeforeMethod
	public void create() throws IOException, InterruptedException
	{
		login_page();
	}

	@Test
	public void assignedstory_delete() throws InterruptedException
	{
		
		pageClass pageclass = new pageClass();
		PageFactory.initElements(driver, pageclass);
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".addStory"))));
		 
		
		pageclass.select_website(3);
		Thread.sleep(5000); 
		
		
		
		pageclass.storypromote(driver);
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		Assert.assertTrue(pageclass.assignedstory_delete(), "Issue with Assigned Story Deletion");
		
		
	}
	
	@AfterMethod
	public void close()
	{
		
		driver.close();
		
	}
}
