package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	public WebDriver rpdriver ;
	
	public RegistrationPage(WebDriver driver) {
		  this.rpdriver = driver;
		  PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "b")
	private WebElement JBKName;
	
	@FindBy(tagName = "p")
	private WebElement RegNewMembership;
	
	@FindBy(id = "name")
	private WebElement UName;
	
	@FindBy(id = "mobile")
	private WebElement UMobile;
	
	@FindBy(id = "email")
	private WebElement UEmail;
	
	@FindBy(id = "password")
	private WebElement UPass;
	
	@FindBy(xpath = "//button")
	private WebElement SignInBtn;
	
	@FindBy(id = "name_error")
	private WebElement NameError;
	
	@FindBy(id = "mobile_error")
	private WebElement MobileError;
	
	@FindBy(id = "email_error")
	private WebElement EmailError;
	
	@FindBy(id = "password_error")
	private WebElement PassError;
	
	@FindBy(xpath = "//div[contains(text(),'Please')]")
	private List<WebElement> Form_Errors;
	
	@FindBy(xpath = "//a[contains(text(),'I')]")
	private WebElement AlreadyMembership;

    public String RegPage_JBKName() {
    	return JBKName.getText();
    }

    public String RegPage_RegNewMembership() {
    	 return RegNewMembership.getText();
    }

    public void RegPage_FormFillUp(String in_name,String in_mob,String in_email,String in_pass) {
    	    UName.clear();
    	    UName.sendKeys(in_name);
    	    UMobile.clear();
    	    UMobile.sendKeys(in_mob);
    	    UEmail.clear();
    	    UEmail.sendKeys(in_email);
    	    UPass.clear();
    	    UPass.sendKeys(in_pass);
    	    SignInBtn.click();
    }

    public String RegPage_AlreadyMembership() {   
    	 return AlreadyMembership.getText();
    }
    
    public LoginPage RegPage_AlreadyMembership_Clickable() {
    	        AlreadyMembership.click();
    	 return new LoginPage(rpdriver);
    }
    public List<WebElement> RegPage_Form_Errors(){
    	       SignInBtn.click();
    	 return Form_Errors;
    }
    public String RegPage_NameError() {
    	 return NameError.getText();
    }
    public String RegPage_MobError() {
   	     return MobileError.getText();
    }
    public String RegPage_EmailError() {
   	     return EmailError.getText();
    }
    public String RegPage_PassError() {
  	    return PassError.getText();
    }
}
