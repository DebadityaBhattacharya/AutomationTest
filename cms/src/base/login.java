package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login extends cms_base
{

	@BeforeMethod
	public void create() throws IOException, InterruptedException
	{
		setup();
	}
	
	@Test
	public void login_pagetest() throws IOException, InterruptedException
	{
		
		
		driver.navigate().to(CONFIG.getProperty("loginurl"));
		pageClass pageclass = new pageClass(driver);
		pageclass.login_click();
		
	}
	
	@Test
	public void hamburger_click() throws IOException, InterruptedException
	{
		driver.navigate().to(CONFIG.getProperty("loginurl"));
		pageClass pageclass = new pageClass(driver);
		pageclass.login_click();
		Thread.sleep(5000);
		pageclass.planner_page_wait();
		pageclass.menu_click();
		Thread.sleep(2000);
		pageclass.newstory_click();
	}
	
	
	
	@AfterMethod
	public void close()
	{
		
		driver.close();
		
	}
}
