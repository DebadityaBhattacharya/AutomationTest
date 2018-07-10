package planner;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.cms_base;
import base.pageClass;

public class approveStory extends cms_base
{
	pageClass pageclass;

	@BeforeMethod
	public void create() throws IOException, InterruptedException
	{
		login_page();
	}


	@Test
	public void story_approve() throws IOException, InterruptedException, AWTException
	{
		pageclass = new pageClass(driver);
		pageclass.planner_page_wait();
		pageclass.select_website(3);
		Thread.sleep(5000); 
		pageclass.page_scroll(250);
		Thread.sleep(3000);
		pageclass.openstoryblock_click();
		Thread.sleep(1000);
		pageclass.planner_horizontal_scroll(5);
		Thread.sleep(2000);
		pageclass.approveStory();
		
	}
	
	@AfterMethod
	public void close()
	{
		
		driver.close();
		
	}
	
}
