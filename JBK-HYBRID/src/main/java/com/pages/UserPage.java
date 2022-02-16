package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

	public WebDriver updriver;
	
	public UserPage(WebDriver driver) {
         this.updriver = driver;
         PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1")
	private WebElement Users;
	
	@FindBy(tagName = "h3")
	private WebElement UserList;
	
	@FindBy(tagName = "th")
	private List<WebElement> TableLabels;
	
	@FindBy(xpath = "//tr[2]//td")
	private List<WebElement> Userkiran;
	
	@FindBy(xpath = "//tr[2]/td[8]/a")
	private WebElement KiranDeletBtn;
	
	@FindBy(xpath = "//tr[3]//td")
	private List<WebElement> UserSagar;
	
	@FindBy(xpath = "//tr[3]/td[8]/a")
	private WebElement SagarDeletBtn;
	
	@FindBy(xpath = "//div[1]//following::a/button")
	private WebElement AddUser;
	
	public String UserPage_Users_Text() {
		return Users.getText();
	}
	
	public String UserPage_UserList_Text() {
		return UserList.getText();
	}
	
	public List<WebElement> UserPage_TableLabels(){
		return TableLabels;
	}
	
	public List<WebElement> UserPage_UserKiran_Data(){
		return Userkiran;
	}
	
	public void UserPage_KiranDeleteBtn_Clickable(){
		      KiranDeletBtn.click();
	}
	
	public String UserPage_KiranDeleteBtn_Text(){
	      return KiranDeletBtn.getText();
    }
	
	public List<WebElement> UserPage_UserSagar_Data(){
		return UserSagar;
	}
	
	public void UserPage_SagarDeleteBtn_Clickable(){
		      SagarDeletBtn.click();
	}
	
	public boolean UserPage_SagarDeleteBtn(){
	      return SagarDeletBtn.isDisplayed();
    }
	
	public String Userpage_AddUser_Text() {
		  return AddUser.getText();
	}
	
	public AddUserPage Userpage_AddUser_ClickAble() {
		   AddUser.click();
		  return new AddUserPage(updriver);
	}
}