package com.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.listeners.ListenerEx;
import com.pages.LoginPage;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(ListenerEx.class)
public class LoginPageTest extends BaseClass{
	
	LoginPage lp;
  
	@BeforeSuite
    public void SetUp() {
	   log.info("LoginPage BeforeSuite");
	   reportInitialization();
    }

    @AfterSuite
    public void tearDown() {
	  log.info("LoginPage AfetrSuite");
	  report.flush();
    }

    @BeforeClass
    public void BeforeClassLoginPage() {
	  log.info("LoginPage BeforeClass");
	  browserInitialization();
	  urlEntering();
	  reportInitialization();
	  lp = new LoginPage(driver);
    }
    
    @AfterClass
    public void AfetrClass_LoginPage() {
	  log.info("LoginPage AfetrClass");
	  //report.flush();
	  driver.close();
    }
    
    @Test
	public void verify_LoginPage_Title() {
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}

    @Test 
	public void verify_LoginPage_JBKLogo() {
  	    Assert.assertTrue(lp.JBKLogo());
	}
  
    @Test 
	public void verify_LoginPage_JBKName() {
		Assert.assertEquals(lp.JBKName(), "Java By Kiran");
	}

    @Test 
	public void verify_LoginPage_StartSessionText() {
		Assert.assertEquals(lp.StartSessionText(), "Sign in to start your session");
	}
  
    @Test 
	public void verify_LoginPage_CorrectCredential() {
    	//urlEntering();
		lp.CheckLogin("kiran@gmail.com", "123456");
		String exp = "JavaByKiran | Dashboard";
		String act = driver.getTitle();
		driver.navigate().back();
		Assert.assertEquals(act, exp);
	}

    @Test 
	public void verify_LoginPage_NoData_Error() {
  	    lp.CheckLogin("","");
		
		SoftAssert sa = new SoftAssert();
		
		String act1 = lp.EmailError();
		String exp1 = "Please enter email.";
		sa.assertEquals(act1, exp1);
		
		String act2 = lp.PassError();
		String exp2 = "Please enter password.";
		sa.assertEquals(act2, exp2);
		
		sa.assertAll();
	}
  
    @Test 
	public void verify_LoginPage_Invalid_EmailError() {
    	//urlEntering();
    	lp.CheckLogin("aaa", "");
		Assert.assertEquals(lp.EmailError(), "Please enter valid email.");
	}
	
	@Test 
	public void verify_LoginPage_WrongEmail_WrongPassword() {
		lp.CheckLogin("samrat@gmail.com", "111111");
		
		SoftAssert sa = new SoftAssert();
		
		String act1 = lp.EmailError();
		String exp1 = "Please enter email as kiran@gmail.com";
	    sa.assertEquals(act1, exp1);
		
		String act2 = lp.PassError();
		String exp2 = "Please enter password 123456";
		sa.assertEquals(act2, exp2);
		
		sa.assertAll();
	}
	
	@Test 
	public void verify_LoginPage_RegisterMembershipText() {
		//urlEntering();
		Assert.assertEquals(lp.RegisterMembershipText(), "Register a new membership");
	}
	
	@Test 
	public void verify_LoginPage_RegisterMembershipClickable() {
		lp.RegisterMembershipClickable();
		String exp = "JavaByKiran | Registration Page";
		String act = driver.getTitle();
		driver.navigate().back();
		Assert.assertEquals(act, exp);
	}
	
	@Test 
	public void verify_LoginPage_Scenario() {
		throw new SkipException("LoginPage Scenario depends on DashboardPage");
	}
}
