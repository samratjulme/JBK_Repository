package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
 
	public WebDriver dpdriver;
	
	public DashboardPage(WebDriver driver) {
		this.dpdriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "Java By Kiran")
	private WebElement JBKName;
	
	@FindBy(tagName = "img")
	private WebElement Uimage;
	
	@FindBy(xpath = "//p[text()='Kiran']")
	private WebElement UName;
	
	@FindBy(partialLinkText = "Online")
	private WebElement UOnline;
	
	@FindBy(xpath = "//section/ul/li")
	private List<WebElement> LeftSideBar;
    
	@FindBy(xpath = "//section/ul/li[1]")
	private WebElement MainNavi;
	
	@FindBy(xpath = "//section/ul/li[2]")
	private WebElement Dashboard;
	
	@FindBy(xpath = "//section/ul/li[3]")
	private WebElement Users;
	
	@FindBy(xpath = "//section/ul/li[4]")
	private WebElement Operators;	
	
	@FindBy(xpath = "//section/ul/li[5]")
	private WebElement UsefulLinks;
	
	@FindBy(xpath = "//section/ul/li[6]")
	private WebElement Downloads;
	
	@FindBy(xpath = "//section/ul/li[7]")
	private WebElement Logout;
	
	@FindBy(tagName = "h1")
	WebElement HeadDashboard;
	
	@FindBy(xpath = "//ol//following::li")
	private List<WebElement> RightSideBar;
	
	@FindBy(xpath = "//section[2]//following::div/a")
	private List<WebElement> AllCourses_moreinfo_click;
	
	@FindBy(xpath = "//h3[text()='Selenium']")
	private WebElement Selenium;
	
	@FindBy(xpath = "//p[contains(text(),'Auto')]")
	private WebElement AutoTesting;
	
	@FindBy(xpath = "//div/div[1]/div/a")
	private WebElement SelMoreInfo;
	
	@FindBy(xpath = "//h3[text()='Java / J2EE']")
	private WebElement Java2EE;
	
	@FindBy(xpath = "//p[contains(text(),'Soft')]")
	private WebElement SoftDevp;
	
	@FindBy(xpath = "//div/div[2]/div/a")
	private WebElement SoftMoreInfo;
	
	@FindBy(xpath = "//h3[text()='Python']")
	private WebElement Pyton;
	
	@FindBy(xpath = "//p[contains(text(),'Data')]")
	private WebElement Data;
	
	@FindBy(xpath = "//div/div[3]/div/a")
	private WebElement DataMoreInfo;
	
	@FindBy(partialLinkText = "JavaByKiran")
	private WebElement CopyRight;
	
	public String DashPage_JBKName() {
		return JBKName.getText();
	}
	
	public boolean DashPage_Uimage() {
		return Uimage.isDisplayed();
	}
	
	public String DashPage_UName() {
		return UName.getText();
	}
	
	public String DashPage_UOnline() {
		return UOnline.getText();
	}
	
	public String DashPage_MainNavi() {
		return MainNavi.getText();
	}
	
	public String DashPage_Dashboard() {
		return Dashboard.getText();
	}
	
	public String DashPage_Users() {
		return Users.getText();
	}
	
	public String DashPage_Operators() {
		return Operators.getText();
	}
	
	public String DashPage_UsefulLinks() {
		return UsefulLinks.getText();
	}
	
	public String DashPage_Downloads() {
		return Downloads.getText();
	}
	
	public String DashPage_Logout() {
		return Logout.getText();
	}
	
	public List<WebElement> DashPage_SideBarMenu(){
		return LeftSideBar;
		
	}
	
	public String DashPage_Header() {
		return HeadDashboard.getText();
	}
	
	public List<WebElement> DashPage_RightSide_Bar(){
		return RightSideBar;
	}
	
	public String DashPage_Selenium() {
		return Selenium.getText();
	}
	
	public String DashPage_AutoTesting() {
		return AutoTesting.getText();
	}
	
	public String DashPage_SelMoreInfo() {
		return SelMoreInfo.getText();
	}
	
	public String DashPage_Java2EE() {
		return Java2EE.getText();
	}
	
	public String DashPage_SoftDevp() {
		return SoftDevp.getText();
	}
	
	public String DashPage_SoftMoreInfo() {
		return SoftMoreInfo.getText();
	}
	
	public String DashPage_Python() {
		return Pyton.getText();
	}
	
	public String DashPage_Data() {
		return Data.getText();
	}
	
	public String DashPage_DataMoreInfo() {
		return DataMoreInfo.getText();
	}
	
	public List<WebElement> DashPage_AllCourses_moreinfo_clickable() {
	 return	AllCourses_moreinfo_click;
	}

	public JBKOfficialWebsitePage DashPage_CopyRight_Clickable() {
		       CopyRight.click();
		return new JBKOfficialWebsitePage(dpdriver);
	}
	
	public UserPage DashPage_Users_Clickable() {
		       Users.click();
		return new UserPage(dpdriver);
	}
	
	public OperatorsPage DashPage_Operators_Clickable() {
		       Operators.click();
		return new OperatorsPage(dpdriver);
	}
	
	public UsefulLinksPage DashPage_UsefulLinks_Clickable() {
		       UsefulLinks.click();
		return new UsefulLinksPage(dpdriver);
	}
	
	public DownloadsPage DashPage_Downloads_Clickable() {
		       Downloads.click();
		return new DownloadsPage(dpdriver);
	}
	
	public LoginPage DashPage_Logout_Clickable() {
	       Logout.click();
	return new LoginPage(dpdriver);
}
}