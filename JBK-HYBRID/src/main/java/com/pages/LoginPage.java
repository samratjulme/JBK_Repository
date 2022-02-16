package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	public WebDriver lpdriver;
	
	public LoginPage(WebDriver driver) {
		this.lpdriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "img")
	private WebElement JBKlogo;

	@FindBy(tagName = "b")
	private WebElement JBKName;

	@FindBy(tagName = "h4")
	private WebElement JBKCourses;

	@FindBy(tagName = "p")
	private WebElement StartSessionText;

	@FindBy(id = "email")
	private WebElement Uemail;

	@FindBy(id = "password")
	private WebElement Upass;

	@FindBy(id = "email_error")
	private WebElement EmailError;
	
	@FindBy(id = "password_error")
	private WebElement PassError;
	
	@FindBy(xpath = "//button")
	private WebElement SiginBtn;

	@FindBy(partialLinkText = "Register a new")
	private WebElement RegisterMembership;
	
	@FindBy(xpath = "//p[contains(text(),'Logout')]")
	private WebElement LogoutSuc;
	
	public boolean JBKLogo() {
	       return JBKlogo.isDisplayed();
	}

	public String JBKName() {
		   return JBKName.getText();
	}
	
	public String StartSessionText() {
		   return StartSessionText.getText();
	}
	public void CheckLogin(String in_email, String in_password) {
		Uemail.clear();
		Uemail.sendKeys(in_email);
		Upass.clear();
		Upass.sendKeys(in_password);
		SiginBtn.click();
	}
	public String EmailError() {
		return EmailError.getText();
	}
	public String PassError() {
		return PassError.getText();
	}
	public DashboardPage ValidLogin() {
		Uemail.clear();
		Uemail.sendKeys("kiran@gmail.com");
		Upass.clear();
		Upass.sendKeys("123456");
		SiginBtn.click();

		return new DashboardPage(lpdriver);
	}
	
	public String RegisterMembershipText() {
	    return RegisterMembership.getText();	
	}
	
	public RegistrationPage RegisterMembershipClickable() {
		   RegisterMembership.click();
        return new RegistrationPage(lpdriver);	
	}

	public String LoginPage_LogoutSuccess() {
		return LogoutSuc.getText();
	}
}
