package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {

	public WebDriver adupdriver;
	
	public AddUserPage(WebDriver driver) {
		this.adupdriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1")
    private WebElement AddUser_Header;
	
	@FindBy(xpath = "//div[@class='form-group']/label[1]")
	private List<WebElement> FormLabels;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SubBtn;
	
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement CanBtn;
	
    @FindBy(id = "username")
    private WebElement Uname;
    
    @FindBy(id = "mobile")
	private WebElement Umobile;
	
	@FindBy(id = "email")
	private WebElement Uemail;
	
    @FindBy(id = "course")
    private WebElement Ucourses;
    
    @FindBy(xpath = "//input[@id='Male']")
    private WebElement Male;
    
    @FindBy(xpath = "//input[@id='Female']")
    private WebElement Female;
    
    
    @FindBy(tagName = "select")
    private WebElement State;
    
    @FindBy(id = "password")
	private WebElement Upass;
	
    @FindBy(xpath = "//input[@placeholder='FriendMobile']")
    private WebElement Frdmobile;
    
	public String AddUser_Header() {		
	   return AddUser_Header.getText();
	}
	
	public List<WebElement> AddUser_FormLabels(){
	  return FormLabels;
	}
	
	public String AddUser_SubmitBtn() {
		return SubBtn.getText();
	}
	
	public String AddUser_CanBtn() {
		return CanBtn.getText();
	}
	
	public AddUserPage AddUser_SubmitBtn_Clickable() {
		 SubBtn.click();
		 return new AddUserPage(adupdriver);
	}
	
	public UserPage AddUser_CanBtn_Clickable() {
		 CanBtn.click();
		 return new UserPage(adupdriver);
	}
   
	public void AddUser_Form_FillUp(String in_name,String in_mob, String in_email,
			String in_cour,String in_Gen,int in_stat, String in_pass,String in_Fmob) {
		Uname.clear();
		Uname.sendKeys(in_name);
		Umobile.clear();
		Umobile.sendKeys(in_mob);
		Uemail.clear();
		Uemail.sendKeys(in_email);
		Ucourses.clear();
		Ucourses.sendKeys(in_cour);
		
		if(in_Gen.contains("Male")) {
			Male.click();
		}
		else if(in_Gen.contains("Female")) {
			Female.click();
		}
		Select sel = new Select(State);
		sel.selectByIndex(in_stat);
		Upass.clear();
		Upass.sendKeys(in_pass);
		Frdmobile.clear();
		Frdmobile.sendKeys(in_Fmob);
		SubBtn.click();
	}
	
	public List<WebElement> AddUser_Form_Dropdown(int in_stat) {
		    Select sel = new Select(State);
		    sel.selectByIndex(in_stat);
	 return sel.getAllSelectedOptions();
	}
}
