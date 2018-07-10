package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.xml.sax.Locator;



public class pageClass extends cms_base
{
	public WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	public pageClass(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(this.driver,this);
		js = (JavascriptExecutor) driver;
		Thread.sleep(5000);
	}
	
	public void planner_page_wait()
	{
		wait = new WebDriverWait(this.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".addStory"))));
	}
	
	public void page_scroll(int i)
	{
		js.executeScript("window.scrollBy(0,"+i+")");
	}
	
	public void planner_horizontal_scroll(int i)
	{
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane["+i+"]/div/div/h3/span")));
		
	}
	//loginpage
	
	@FindAll({@FindBy(css= "#mCSB_1_container>li>a")})
	public List<WebElement> menulist;

	@FindBy(how=How.CSS, using=".btn.btn-primary.btn-block.mt-3") 
	WebElement login;
	
	@FindBy(how=How.CSS, using=".fa.fa-home.home-icon") 
	WebElement home;
	
	@FindBy(how=How.CSS, using="#md-input-1") 
	WebElement username;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-open-layout/section/app-login/form/div[2]/md-input-container/div/div[1]/div/input") 
	WebElement password;
	
	
	
	//planner
	@FindBy(how=How.CSS, using=".addStory") 
	WebElement newstory;
	
	@FindBy(how=How.CSS, using=".mat-select-trigger") 
	WebElement website_select;
	
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-template-selector/div/div[1]/i")
	WebElement storylist_blank;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div[2]/div[2]/md-dialog-container/app-template-selector/div/div[1]")
	WebElement blankstory;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/app-sidebar/app-secure-header/header/nav/div[1]/i") 
	WebElement menu;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[1]/button") 
	WebElement newidea;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[1]/div/div/h3/span")
	WebElement ideacount;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[1]/div/div/ul/li/app-swim-lane-item/div/span[2]/i")
	WebElement ideadel_button;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[1]/div/div/h3/span")
	WebElement idea_number;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[1]/div/div/ul/li/app-swim-lane-item/div/span[1]/span")
	WebElement idea_heading;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-confirm-delete/div/button[2]")
	WebElement delete_button;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[3]/div/div/ul/li[1]/app-swim-lane-item/div/span[1]/span")
	WebElement openstory_heading;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/md-tab-header/div[2]/div/div/div[2]")
	WebElement story_collection;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[2]/div/app-collection-tab/div/app-collections[1]/div/div/h3/span")
	WebElement story_parent_collection_count;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[2]/div/app-collection-tab/div/app-collections[1]/div/div/ul/div[1]/span/span")
	WebElement collection1_heading;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[2]/div/app-collection-tab/div/app-collection-group/div/div/div/div[1]/div/span/span")
	WebElement sorter1_heading;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[2]/div/app-collection-tab/div/app-collection-stories/h3/span")
	WebElement sorter1_storycount;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[5]/div/div/h3/span")
	WebElement editor_review_count;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[6]/div/div/h3/span")
	WebElement published_count;

	@FindBy(how=How.XPATH, using="html/body/ng2-dropdown-menu[2]/div[1]/div/ng2-menu-item[4]/div")
	WebElement tagname_select_metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[5]/div/div/ul/li/app-swim-lane-item/div[2]/span[1]/span")
	WebElement approved_story1heading;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-story-publish/div/div[3]/button[2]")
	WebElement publish_ok_button;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/app-sidebar/app-secure-header/header/nav/div[2]/div/app-story-toolbar/span/span[2]/button[3]")
	WebElement publish_delete;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[6]/div/div/ul/li[1]/app-swim-lane-item/div[2]/span/span")
	WebElement publish_heading1;
	
	
	
	//storyeditpage
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[1]/div/div/app-story-content/div/div[1]/md-input-container/div/div[1]/div/input") 
	WebElement text1_content;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[1]/div/div/app-story-content/div/div[2]/md-input-container/div/div[1]/div/input") 
	WebElement text2_content;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/md-tab-header/div[2]/div/div/div[2]/span") 
	WebElement metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[2]/div/div/app-story-metadata/div/div[3]/md-input-container/div/div[1]/div/input") 
	WebElement title_metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[2]/div/div/app-story-metadata/div/div[4]/md-input-container/div/div[1]/div/input") 
	WebElement desc_metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[2]/div/div/app-story-metadata/div/div[5]/md-input-container/div/div[1]/div/input") 
	WebElement social_metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[2]/div/div/app-story-metadata/div/div[6]/md-input-container/div/div[1]/div/input") 
	WebElement stryline_metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[2]/div/div/app-story-metadata/div/div[11]/md-input-container/div/div[1]/div/input") 
	WebElement canonicalurl_metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[2]/div/div/app-story-metadata/div/div[1]/div[1]/div/md-select/div/span[2]")
	WebElement author_metadata;
	
	@FindAll({@FindBy(css= ".mat-option-ripple.mat-ripple")})
	public List<WebElement> author_dropdown_metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/md-tab-header/div[2]/div/div/div[3]/span")
	WebElement attributes;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[3]/div/div/app-story-attributes/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement persons_attributes;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[3]/div/div/app-story-attributes/div/div[2]/tag-input/div/div/tag-input-form/form/input")
	WebElement genre_attributes;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[3]/div/div/app-story-attributes/div/div[3]/tag-input/div/div/tag-input-form/form/input")
	WebElement geo_attributes;
	
	@FindBy(how=How.CSS, using=".addStory")
	WebElement submitstory;       
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/app-sidebar/app-secure-header/header/nav/div[2]/div/app-story-toolbar/span/span/button[3]")
	WebElement storyapproved;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/app-sidebar/app-secure-header/header/nav/div[2]/div/app-story-toolbar/span/span/button[2]")
	WebElement storyrejected;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[2]/div/div/app-story-metadata/div/div[7]/tag-input/div/div/tag-input-form/form/input")
	WebElement tag_metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[2]/div/div/app-story-metadata/div/div[8]/md-select/div/span[3]")
	WebElement sectionname_metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[2]/div/div/app-story-metadata/div/div[11]/tag-input/div/div/tag-input-form/form/input")
	WebElement seo_metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[2]/div/div/app-story-metadata/div/div[10]/tag-input/div/div/tag-input-form/form/input")
	WebElement news_metadata;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/app-sidebar/app-secure-header/header/nav/div[2]/div/app-story-toolbar/span/span/button")
	WebElement release_lock;
	
	//@FindBy(how=How.CSS, using="")
	//WebElement sectionname_select_metadata;
	
	@FindAll({@FindBy(css= ".mat-option-ripple.mat-ripple")})
	public List<WebElement> sectionname_select_metadata;
	
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-story/form/md-tab-group/div/md-tab-body[1]/div/div/app-story-content/div/div[4]/div")
	WebElement story_image;
	
	@FindAll({@FindBy(css=".img_wrap>img")})
	public List<WebElement> select_image;
	
	
	@FindBy(how=How.CSS, using=".btn.btn-secondary.mt-5.generate-btn-height")
	WebElement generate_derivatives;
	
	@FindBy(how=How.CSS, using=".btn.btn-secondary.mt-4")
	WebElement save_derivates;
	
	
	//idea
	
	// create
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-idea/form/div[1]/md-input-container/div/div[1]/div/input")
	WebElement ideatext;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-idea/form/div[2]/md-input-container/div/div[1]/div/input")
	WebElement sourcetext;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-idea/form/div[5]/md-select/div/span[2]")
	WebElement sectionname_text;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-idea/form/div[6]/div[1]/button")
	WebElement ideasave;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-idea/form/div[9]/div[2]/button")
	WebElement idea_promotebutton;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[1]/div/div/ul/li[1]/app-swim-lane-item/div/span/span")
	WebElement idea_heading1;
	
	// delete
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-idea/form/div[6]/md-select/div/span[2]")
	WebElement ideaauthor;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div[3]/div/div/md-option[1]/div")
	WebElement ideaauthor_select;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-idea/form/div[9]/div[1]/button[2]")
	WebElement ideareject_button1;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-idea/form/div[6]/md-input-container/div/div[1]/div/textarea")
	WebElement ideareject_reason;

	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-idea/form/div[7]/button")
	WebElement ideareject_button2;
	
	
	
	//Not Started = Assigned
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[2]/div/div/h3/span")
	WebElement notstarted_time;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[2]/div/div/ul/li[1]/app-swim-lane-item/span[2]/i")
	WebElement assignedstory_delete;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[2]/div/div/h3/span")
	WebElement assignedstory_number;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[2]/div/div/ul/li/app-swim-lane-item/div/span[1]/span")
	WebElement assignedstory_1;
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div/div[2]/md-dialog-container/app-idea/form/div[8]/button[2]")
	WebElement assignedstory_startbutton;
	
	
	
	//Open = Copy-Edit
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[3]/div/div/h3/span")
	WebElement openstory_count;
	
	
	//For Approval
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[4]/div/div/ul/li[1]/app-swim-lane-item/div/span[1]/span")
	WebElement approvalstory_head;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[4]/div/div/h3/span")
	WebElement forapproval_count;
	
	
	//published
	
	//Workspace
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-workspace/div/md-tab-group/md-tab-header/div[2]/div/div/div[1]/span")
	WebElement w_openstory;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-workspace/div/md-tab-group/md-tab-header/div[2]/div/div/div[2]/span")
	WebElement w_forapproval;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-workspace/div/md-tab-group/md-tab-header/div[2]/div/div/div[2]")
	WebElement need_approval_button;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-workspace/div/md-tab-group/div/md-tab-body[2]/div/app-workspace-list/div/div/ul/li[1]/app-workspace-item/div/div[4]/i")
	WebElement deletebutton;
	
	
	
	
	//Sorter
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-sorter-list/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[7]/div/i[1]")
	WebElement manual_sorter_select;
	
	@FindBy(how=How.XPATH, using="html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-edit-sorter/div/md-tab-group/md-tab-header/div[2]/div/div/div[2]/span")
	WebElement sorter_tab_select;
	
	@FindAll({@FindBy(css= ".pl-3")})
	public List<WebElement> sorter_story_list1;
	
	
	@FindAll({@FindBy(css= ".stories_list>li")})
	public List<WebElement> sorter_story_list2;
	
	//loginpage
	public void login_click() throws InterruptedException
	{
		Thread.sleep(5000);
		username.clear();
		username.sendKeys("debaditya.bhattacharya@abpdigital.in");
		password.clear();
		password.sendKeys("a123456&");
		
		Thread.sleep(1000);
		login.click();	
	}
	
	public void menu_click() throws InterruptedException
	{
		Thread.sleep(2000);
		menu.click();	
	}
	
	
	
	//planner
	
	public void story_collection() throws InterruptedException
	{
		story_collection.click();
		
		Thread.sleep(2000);
		String collection_count = story_parent_collection_count.getText();
		Assert.assertEquals(collection_count, "20");
		
		collection1_heading.click();
		Thread.sleep(10000);
		
		sorter1_heading.click();
		Thread.sleep(10000);
		
		String storycount_sorter1 = sorter1_storycount.getText();
		Assert.assertNotEquals(storycount_sorter1, "0");
		
	}
	
	public String approval()
	{
		
		return forapproval_count.getText();
		
	}
	
	public void menu_optionclick(int i)
	{
		
		menulist.get(i).click();
		
	}
	
	public void newstory_click()
	{
		newstory.click();	
	}
	
	
	public void select_website(int i) throws InterruptedException
	{
		website_select.click();
		Thread.sleep(2000);
		
		sectionname_select_metadata.get(i).click();
		Thread.sleep(2000);
	}
	public void blankstory_click()
	{
		storylist_blank.click();	
	}
	
	public void add_newidea(WebDriver driver) throws InterruptedException
	{
		String idea_count1 = ideacount.getText();
		newidea.click();
		
		Thread.sleep(1000);
		ideatext.sendKeys("Ideayou're not time-travelling. Kapil Sharma and Sunil Grover are fighting again");
		sourcetext.sendKeys("The Times Of India");
		sectionname_text.click();
		
		Thread.sleep(5000);
		
		sectionname_select_metadata.get(0).click();
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		
		ideasave.click();
		Thread.sleep(20000);
		
		String idea_count2 = ideacount.getText();
		Thread.sleep(2000);
		Assert.assertNotEquals(idea_count2,idea_count1);
		
		
		
	}
	
	public boolean delete_idea(WebDriver driver) throws InterruptedException
	{
		String idea_count=idea_number.getText();
		idea_heading1.click();
		
		//Thread.sleep(5000);
		//ideaauthor.click();
		
		//Thread.sleep(2000);
		//ideaauthor_select.click();
		
		Thread.sleep(5000);
		ideareject_button1.click();
		
		Thread.sleep(2000);
		ideareject_reason.sendKeys("Test Auto Reason");

		Thread.sleep(2000);
		ideareject_button2.click();
		
		Thread.sleep(8000);
		String idea_count_new=idea_number.getText();
		
		if (idea_count.equals(idea_count_new)) 
		{
			return false;
		}
		else 
			return true;
	}
	
	public void storypromote(WebDriver driver) throws InterruptedException
	{
		String assignedtime1 = notstarted_time.getText();
		
		idea_heading.click();
		
		Thread.sleep(2000);
		ideaauthor.click();
		Thread.sleep(2000);
		ideaauthor_select.click();
		
		Thread.sleep(2000);
		idea_promotebutton.click();
		
		Thread.sleep(12000);
		
		String assignedtime2 = notstarted_time.getText();
		
		Assert.assertNotEquals(assignedtime1, assignedtime2);
	}
	
	public boolean assignedstory_delete() throws InterruptedException
	{
		String assignedstory_count=assignedstory_number.getText();
		
		
		assignedstory_delete.click();
		delete_button();
		
		Thread.sleep(5000);
		
		String assignedstorynew_count = assignedstory_number.getText();
		
		if (assignedstory_count.equals(assignedstorynew_count)) 
		{
			return false;
		}
		else 
			return true;
		
	}
	
	public void delete_button()
	{
		
		delete_button.click();
		
	}
	
	public String openstoryblock_click() throws AWTException
	{
		openstory_count.click();
		
		return openstory_count.getText();
		
	}
	public void open_Story() throws InterruptedException
	{
		String openstory_count1 = openstory_count.getText();
		
		assignedstory_1.click();
		
		//Thread.sleep(2000);
		//assignedstory_startbutton.click();
		
		Thread.sleep(2000);
		blankstory_click();
		
		Thread.sleep(5000);
		
		//driver.navigate().to(CONFIG.getProperty("loginurl"));
		home.click();
		Thread.sleep(5000);
		
		String openstory_count2 = openstory_count.getText();
		
		 System.out.println(openstory_count2+" "+ openstory_count1);
		
		Assert.assertNotEquals(openstory_count2,openstory_count1);
	}
	
	public void submitStory() throws InterruptedException
	{
		String forapproval_count1 = forapproval_count.getText();
		
		openstory_heading.click();
		
		Thread.sleep(4000);
		submitstory.click();
		
		Thread.sleep(2000);
		textfill();
		
		Thread.sleep(1000);
		submit_story();
		
		Thread.sleep(8000);
		
		String forapproval_count2 = forapproval_count.getText();
		Assert.assertNotEquals(forapproval_count2,forapproval_count1);
	}
	
	public void approveStory() throws InterruptedException
	{
		String submiitedstory1 = forapproval_count.getText();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		jse.executeScript("arguments[0].scrollIntoView();",published_count);
		
		Thread.sleep(2000);
		
		approvalstory_head.click();
		
		Thread.sleep(3000);
		storyapproved.click();
		
		
		Thread.sleep(3000);
		String submiitedstory2 = forapproval_count.getText();
		Assert.assertNotEquals(submiitedstory2, submiitedstory1);
		
	}
	
	
	public void publishStory() throws InterruptedException, AWTException
	{
		String submiitedstory1 = editor_review_count.getText();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		jse.executeScript("arguments[0].scrollIntoView();",published_count);
		
		Thread.sleep(2000);
		
		approved_story1heading.click();
		
		Thread.sleep(3000);
		storyapproved.click();
		
		
		Thread.sleep(3000);
		publish_ok_button.click();
		Thread.sleep(3000);
		
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		openstoryblock_click();
		
		
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[6]/div/div/h3/span")));
		
		Thread.sleep(3000);
		
		String submiitedstory2 = editor_review_count.getText();
		Assert.assertNotEquals(submiitedstory1, submiitedstory2);
		
	}
	
	public void delete_publish() throws InterruptedException, AWTException
	{
		String submiitedstory1 = published_count.getText();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(3000);
		publish_heading1.click();
		
		
		
		Thread.sleep(3000);
		try 
		{
			publish_delete.click();
		} 
		catch (Exception e) 
		{
		
			release_lock.click();
			
		}
		
		
		Thread.sleep(8000);
		
		
		
		openstoryblock_click();
		Thread.sleep(1000);
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[6]/div/div/h3/span")));
		Thread.sleep(1000);
		String submiitedstory2 = published_count.getText();
		//Assert.assertNotEquals(submiitedstory2, submiitedstory1);
	}
	
	//storyeditpage
	public void textfill() throws InterruptedException
	{
		Thread.sleep(5000);
		text1_content.clear();
		text1_content.sendKeys("No, you're not time-travelling. Kapil Sharma and Sunil Grover are fighting again");	
		
		
		
			
		

			story_image.click();
			
		
		
		
		
		Thread.sleep(8000);
		
		select_image.get(1).click();
		Thread.sleep(2000);
		
		generate_derivatives.click();
		
		Thread.sleep(4000);
		save_derivates.click();
		
		Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-500)");
		
		text2_content.sendKeys("Test Sub Title Story");	
		
		metadata.click();
		
		Thread.sleep(1000);
		
		desc_metadata.sendKeys("No, you're not time-travelling. Kapil Sharma and Sunil Grover are fighting again");
		social_metadata.sendKeys("Test Social Share Message");
		
		Thread.sleep(1000);
		author_metadata.click();
		Thread.sleep(1000);
		author_dropdown_metadata.get(0).click();
		
		Thread.sleep(1000);
		stryline_metadata.sendKeys("Test Story Line");
		tag_metadata.sendKeys("Salman Khan");
		Thread.sleep(3000);
		//tag_metadata.sendKeys(Keys.ENTER);
		tagname_select_metadata.click();
		
		
		sectionname_metadata.click();
		Thread.sleep(3000);
		
		sectionname_select_metadata.get(1).click();
		sectionname_select_metadata.get(2).click();
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		
		seo_metadata.sendKeys("Test SEO");
		seo_metadata.sendKeys(Keys.ENTER);
		
		news_metadata.sendKeys("Test News");
		news_metadata.sendKeys(Keys.ENTER);
		
		
		//canonicalurl_metadata.sendKeys("Test Canonical Url");
		
		//scroll to click the menu attribute
		//title_metadata.sendKeys("Meta No, you're not time-travelling. Kapil Sharma and Sunil Grover are fighting again");
		
		//attributes.click();
		Thread.sleep(1000);
		
		//persons_attributes.sendKeys("narendra modi");
		//persons_attributes.sendKeys(Keys.ENTER);
		//genre_attributes.sendKeys("genre");
		//genre_attributes.sendKeys(Keys.ENTER);
		//geo_attributes.sendKeys("india");
		//geo_attributes.sendKeys(Keys.ENTER);
		
		
		
	}
	
	public void submit_story() throws InterruptedException
	{
		Thread.sleep(1000);
		submitstory.click();
		
	}
	
	
	
	
	//workspace
	
	
	public String openstoryb()
	{
	
		return w_openstory.getText();

	}
	
	public String forapproval_b()
	{
	
		return w_forapproval.getText();

	}
	
	
	public void storydelete() throws InterruptedException
	{
		need_approval_button.click();
		Thread.sleep(2000);
		
		deletebutton.click();
		Thread.sleep(2000);
		
		delete_button();
		
		
	}
	
	
	
	
	
	//Sorter
	public void manual_sorter(int i) throws InterruptedException
	{
		
		menu_click();
		
		menu_optionclick(i);
		
		Thread.sleep(2000);
		manual_sorter_select.click();
		
		Thread.sleep(2000);
		sorter_tab_select.click();
		
		Thread.sleep(20000);
		dragndrop_sorter();
		
		
	}
	
	
	public void dragndrop_sorter() throws InterruptedException
	{
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(sorter_story_list1.get(1), sorter_story_list2.get(27)).build().perform();

		
		int count=0;
		for(WebElement i : sorter_story_list2)
		{
			count++;
			System.out.println(count+" "+i.getText());
			
		}
				
	}
	
	public String storycreate_wait()
	{
		
		WebElement element = driver.findElement(By.xpath("html/body/app-root/app-secured-layout/ng-sidebar-container/div/section/app-planner/md-tab-group/div/md-tab-body[1]/div/app-story-tab/div/app-swim-lane[4]/div/div/ul/li[1]/app-swim-lane-item/div[2]/div[1]"));
		System.out.println(element.getText());
		return element.getText();
		
	}
}
