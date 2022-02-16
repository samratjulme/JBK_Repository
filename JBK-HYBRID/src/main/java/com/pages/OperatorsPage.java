package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OperatorsPage {

	public WebDriver opdriver;
	
	public OperatorsPage(WebDriver driver) {
		this.opdriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1")
	private WebElement Operators;
	
	@FindBy(xpath = "//h3[contains(text(),'Oper')]")
	private WebElement opList;
	
	@FindBy(tagName = "th")
	private List<WebElement> OpLstLabels;
	
	@FindBy(tagName = "td")
	private List<WebElement> oprKiran;
	
	public String OprPage_Header() {
	  return Operators.getText();
	}
	public String OprPage_OprList() {
		return opList.getText();
	}
	public List<WebElement> OprPage_OpLstLabels(){
	      return OpLstLabels;	
	}
	public List<WebElement> OprPage_oprKiran(){
		  return oprKiran;
	}
}
