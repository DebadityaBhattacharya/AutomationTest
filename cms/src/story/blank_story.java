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

	@BeforeMethod
	public void create() throws IOException, InterruptedException
	{
		login_page();
	}
	
	@Test
	public void story_create() throws IOException, InterruptedException
	{
	
		pageClass pageclass = new pageClass();
		PageFactory.initElements(driver, pageclass);
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".addStory"))));
		
		 
		 pageclass.select_website(3);
			Thread.sleep(5000); 
		
		
		pageclass.newstory_click();
		
		
		
		Thread.sleep(2000);
		pageclass.blankstory_click();
		
		
		
		Thread.sleep(2000);
		pageclass.textfill();
		
		pageclass.submit_story();
		
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[4]/div/div/ul/li[1]/app-swim-lane-item/div[2]/div[1]"));
		System.out.println(element.getText());
		Assert.assertEquals(element.getText(),"a few seconds ago");
	}
	
	@AfterMethod
	public void close()
	{
		
		//driver.close();
		
	}
	
}
