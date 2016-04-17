package com.auction.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.ManageKind.ManageKindPage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

public class HomePage extends BasePage {
	private Logger logger = Logger.getLogger(HomePage.class);

	public HomePage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��HomePage��");
	}

	/**
	 * �����¼ҳ��
	 * 
	 * @return
	 */
	public LoginPage goLoginPage() {
		driver.click(By.partialLinkText("��¼"));
		return new LoginPage(driver);
	}

	/**
	 * �����������ҳ��
	 * 
	 * @return
	 */
	public ManageKindPage goManageKindPage() {
		driver.click(By.partialLinkText("��������"));
		return new ManageKindPage(driver);
	}

	/**
	 * �˳���¼�����¼ҳ��
	 * 
	 * @return
	 */
	public LoginPage logout() {
		driver.click(By.partialLinkText("ע��"));
		return new LoginPage(driver);
	}
}
