package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsefulLinksPage {

	public WebDriver usfulkpdriver ;
	
	public UsefulLinksPage(WebDriver driver) {
		this.usfulkpdriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1")
	private WebElement uselkHeader;
	
	@FindBy(tagName = "h3")
	private WebElement intReq;
	
	@FindBy(tagName = "th")
	private List<WebElement> tableLabels;
	
	@FindBy(xpath = "//tr[2]//td")
	private List<WebElement> SecndRow;
	
	@FindBy(xpath = "//tr[2]/following::td[3]/a")
	private WebElement SecndRowGoBtn;
	
	public String UserlkPage_Header() {
		return uselkHeader.getText();
	}
	
	public String UserlkPage_intReq() {
		return intReq.getText();
	}
	public List<WebElement> UserlkPage_Tablelabels() {
		return tableLabels;
	}
	public List<WebElement> UserlkPage_secondRow_Data() {
		return SecndRow;
	}
	public void UserlkPage_SecndRow_ClkBtn() {
		SecndRowGoBtn.click();
	}
}
