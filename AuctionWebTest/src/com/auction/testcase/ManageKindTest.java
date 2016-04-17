package com.auction.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auction.page.HomePage;
import com.auction.page.LoginPage;
import com.auction.page.ManageKind.ManageKindPage;
import com.framework.util.DateTimeUtil;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;

@Test(groups = { "ManageKindTest" })
public class ManageKindTest extends WebdriverBaseCase {
	private LoginPage LoginPage;
	private HomePage HomePage;
	private ManageKindPage ManageKindPage;
	protected WebdriverBaseApi webDriver;
	private Logger logger = Logger.getLogger(ManageKindTest.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		beforeClass();
		try {
			webDriver = new WebdriverBaseApi(driver);
			HomePage = new HomePage(webDriver);
			LoginPage = HomePage.goLoginPage();
			HomePage = LoginPage.loginOK("mysql", "mysql", null);
		} catch (Exception e) {
			logger.error("beforeClassTest error：", e);
		}
	}

	@Test(enabled = true, alwaysRun = true)
	public void testAddKindOK() {
		boolean flag = false;
		beforeTest("testAddKindOK");
		try {
			String data = DateTimeUtil.getDateTime();
			ManageKindPage = HomePage.goManageKindPage();
			ManageKindPage.addKindOK(data, null);
			flag = ManageKindPage.isTextPresent(data);
			HomePage = ManageKindPage.goHomePage();
		} catch (Exception e) {
			logger.error("testAddKindOK error：", e);
		}
		logger.debug("flag==" + flag);
		String captureName = afterTest("testAddKindOK", flag);
		Assert.assertTrue(flag, className + ".testAddKindOK failed!capture:"
				+ captureName);
	}

	@Test(dependsOnMethods = { "testAddKindOK" }, enabled = true, alwaysRun = true)
	public void testAddKindByKindNameEmpty() {
		boolean flag = false;
		beforeTest("testAddKindByKindNameEmpty");
		try {
			String data = DateTimeUtil.getDateTime();
			ManageKindPage = HomePage.goManageKindPage();
			ManageKindPage.addKindByKindNameEmpty(data, null);
			flag = ManageKindPage.isTextPresent("种类名必填");
			HomePage = ManageKindPage.goHomePage();
		} catch (Exception e) {
			logger.error("testAddKindByKindNameEmpty error：", e);
		}
		logger.debug("flag==" + flag);
		String captureName = afterTest("testAddKindByKindNameEmpty", flag);
		Assert.assertTrue(flag, className
				+ ".testAddKindByKindNameEmpty failed!capture:" + captureName);
	}

	@Test(dependsOnMethods = { "testAddKindByKindNameEmpty" }, enabled = true, alwaysRun = true)
	public void testAddKindByVercodeErr() {
		boolean flag = false;
		beforeTest("testAddKindByVercodeErr");
		try {
			String data = DateTimeUtil.getDateTime();
			ManageKindPage = HomePage.goManageKindPage();
			ManageKindPage.addKindByVercodeErr(data, "666888");
			flag = ManageKindPage.isTextPresent("验证码不匹配,请重新输入");
			HomePage = ManageKindPage.goHomePage();
		} catch (Exception e) {
			logger.error("testAddKindByVercodeErr error：", e);
		}
		logger.debug("flag==" + flag);
		String captureName = afterTest("testAddKindByVercodeErr", flag);
		Assert.assertTrue(flag, className
				+ ".testAddKindByVercodeErr failed!capture:" + captureName);
	}

	@Test(dependsOnMethods = { "testAddKindByVercodeErr" }, enabled = true, alwaysRun = true)
	public void testAddKindByVercodeEmpty() {
		boolean flag = false;
		beforeTest("testAddKindByVercodeEmpty");
		try {
			String data = DateTimeUtil.getDateTime();
			ManageKindPage = HomePage.goManageKindPage();
			ManageKindPage.addKindByVercodeEmpty(data);
			flag = ManageKindPage.isTextPresent("验证码必填");
			HomePage = ManageKindPage.goHomePage();
		} catch (Exception e) {
			logger.error("testAddKindByVercodeEmpty error：", e);
		}
		logger.debug("flag==" + flag);
		String captureName = afterTest("testAddKindByVercodeEmpty", flag);
		Assert.assertTrue(flag, className
				+ ".testAddKindByVercodeEmpty failed!capture:" + captureName);
	}

	@Test(dependsOnMethods = { "testAddKindByVercodeEmpty" }, enabled = true, alwaysRun = true)
	public void testDelKind() {
		boolean flag = false;
		beforeTest("testDelKind");
		try {
			String data = DateTimeUtil.getDateTime();
			ManageKindPage = HomePage.goManageKindPage();
			ManageKindPage.addKindOK(data, null);
			ManageKindPage.delKind(data);
			flag = ManageKindPage.isTextNotPresent(data);
			HomePage = ManageKindPage.goHomePage();
		} catch (Exception e) {
			logger.error("testDelKind error：", e);
		}
		logger.debug("flag==" + flag);
		String captureName = afterTest("testDelKind", flag);
		Assert.assertTrue(flag, className + ".testDelKind failed!capture:"
				+ captureName);
	}

	@AfterClass(alwaysRun = true)
	public void afterClassTest() {
		try {
			LoginPage = HomePage.logout();
			LoginPage.goHomePage();
		} catch (Exception e) {
			logger.error("afterClassTest error：", e);
		}
		afterClass();
	}
}
