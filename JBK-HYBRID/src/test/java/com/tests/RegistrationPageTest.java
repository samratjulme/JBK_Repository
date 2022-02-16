package com.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pages.LoginPage;
import com.pages.RegistrationPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;

//@Listeners(ListenerEx.class)
public class RegistrationPageTest extends BaseClass{
  
	LoginPage lp;
	RegistrationPage rp;
	//String RegPagurl = "file:///D:/javasoft/All/Unzip%20Files/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/register.html";
	
    @BeforeClass
    public void BeforelassRegPage() {
    	 log.info("RegPage BeforeClass");
    	 browserInitialization();
    	 urlEntering();
    	 //reportInitialization();
    	 lp = new LoginPage(driver);
    	 rp = lp.RegisterMembershipClickable();
    }
    
    @AfterClass
    public void AfetrClass_RegPage() {
	  log.info("RegPage AfetrClass");
	  //report.flush();
	  driver.close();
    }
    
    @Test
    public void verify_RegPage_Title() {
  	    Assert.assertEquals(driver.getTitle(), "JavaByKiran | Registration Page");
    }
    
    @Test
  	public void verify_RegPage_JBKText() {
  		Assert.assertEquals(rp.RegPage_JBKName(), "Java By Kiran");
  	}
  	
  	@Test
  	public void verify_RegPage_RegisterMembershipText() {
  		Assert.assertEquals(rp.RegPage_RegNewMembership(), "Register a new membership");
  	}
  	
  	@Test
  	public void verify_RegPage_Successful_PopUp_Handled() {
  	    rp.RegPage_FormFillUp("a", "b", "c", "d");
  	    driver.switchTo().alert().accept();
  	    Assert.assertEquals(driver.getTitle(), "JavaByKiran | Registration Page");
  	}
  	
  	@Test
  	public void verify_RegPage_PopUp_Text() {	
  		rp.RegPage_FormFillUp("aa", "bb", "cc", "dd");
  		String exp = "User registered successfully.";
  	    String act = driver.switchTo().alert().getText();
  		driver.switchTo().alert().accept();
  		Assert.assertEquals(act, exp);
  	}
  	
  	@Test
  	public void verify_RegPage_AlreadyMembership_Text() {
  		//driver.navigate().to(RegPagurl);
  		Assert.assertEquals(rp.RegPage_AlreadyMembership(), "I already have a membership");
  	}
  	
  	@Test
  	public void verify_RegPage_AlreadyMembership_Clickable() {
  		rp.RegPage_AlreadyMembership_Clickable();
  		String exp = "JavaByKiran | Log in";
  		String act = driver.getTitle();
  		driver.navigate().back();
  		Assert.assertEquals(act,exp);
  	}
  	
  	@Test
  	public void verify_RegPage_Form_AllError() {
  		
  	   List<WebElement> lstFormErr	= rp.RegPage_Form_Errors();
  		
  	   for(WebElement Oput:lstFormErr) {
  		   SoftAssert sa = new SoftAssert();
  		   
  		   if(Oput.getText().contains("Please enter Name.")) {
  			   sa.assertEquals(Oput.getText(), "Please enter Name.");
  		   }
  		   else if(Oput.getText().contains("Please enter Mobile.")) {
  			   sa.assertEquals(Oput.getText(), "Please enter Mobile.");
  		   }
  		   else if(Oput.getText().contains("Please enter Email.")) {
  			   sa.assertEquals(Oput.getText(), "Please enter Email.");
  		   }
  		   else if(Oput.getText().contains("Please enter Password.")) {
  			   sa.assertEquals(Oput.getText(), "Please enter Password.");
  		   }
  		   sa.assertAll();
  	   }
  	}
  	
  	@Test
  	public void verify_RegPage_Scenario() {
  		throw new SkipException("RegPage Scenario depends on LoginPage");
  	}

}
