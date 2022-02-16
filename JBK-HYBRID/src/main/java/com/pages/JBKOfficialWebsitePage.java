package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JBKOfficialWebsitePage {

	public WebDriver jbkdriver;
	
	public JBKOfficialWebsitePage(WebDriver driver) {
		this.jbkdriver = driver;
		PageFactory.initElements(driver, this);
	}
}
