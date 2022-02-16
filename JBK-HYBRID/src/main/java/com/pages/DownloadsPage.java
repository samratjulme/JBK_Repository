package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadsPage {

	public WebDriver dwnpdriver ;
	
	public DownloadsPage(WebDriver driver) {
		this.dwnpdriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1")
	private WebElement Header;

    @FindBy(tagName = "h3")
    private WebElement DownList;
   
    @FindBy(tagName = "th")
    private List<WebElement> Downlst_Labels;
   
    @FindBy(xpath = "//tr[1]//following::td")
    private List<WebElement> Table_data;
   
    @FindBy(xpath = "//tr[2]/td[8]/a/span")
    private WebElement Java_Website;
   
    public String DwnPage_Header() {
	  return Header.getText();
     }

    public String DwnPage_downList() {
		  return DownList.getText();
	}
    public List<WebElement> DwnPage_DownlstLabels(){
	      return Downlst_Labels;
    }
    public List<WebElement> DwnPage_Table_Data(){
	      return Table_data;
    }
    public void DwnPage_Java_website_Clickable() {
	           Java_Website.click();
    }
}
