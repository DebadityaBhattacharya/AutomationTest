package workspace;

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
import base.w_pageclass;
import junit.framework.Assert;

public class Openstory_assertion extends cms_base
{

	
	@BeforeMethod
	public void create() throws IOException, InterruptedException
	{
		login_page();
	}


	@Test
	public void openstory_assertion() throws IOException, InterruptedException, AWTException
	{
		pageClass pageclass = new pageClass();
		PageFactory.initElements(driver, pageclass);
		
		
		
		Thread.sleep(35000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".addStory"))));
		 
		pageclass.select_website(3);
		
		Thread.sleep(3000); 
		String openstory_planner= pageclass.openstoryblock_click();
		
		pageclass.menu_click();
		Thread.sleep(1000);
		pageclass.menu_optionclick(2);
		Thread.sleep(3000);
		
		
		String openstory_wokrspace= pageclass.openstoryb();
		
		Assert.assertEquals(openstory_planner, openstory_wokrspace);
	}
	
	@AfterMethod
	public void close()
	{
		
		//driver.close();
		
	}
	
	
}
