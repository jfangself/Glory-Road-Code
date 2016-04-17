package com.auction.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.framework.webdriver.baseapi.WebdriverBaseApi;

public class LoginPage extends BasePage {
	private String vercode;
	private Logger logger = Logger.getLogger(LoginPage.class);

	public LoginPage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��LoginPage��");
		vercode = getVercode("GBK");
	}

	public void inputUserName(String userName) {
		driver.sendKeys(By.name("username"), userName);
	}

	public void inputPassWord(String passWord) {
		driver.sendKeys(By.name("password"), passWord);
	}

	public void inputVercode(String vercode) {
		if (vercode != null && vercode.length() > 0) {
			driver.sendKeys(By.name("vercode"), vercode);
		} else if ("".equalsIgnoreCase(vercode)) {
			driver.sendKeys(By.name("vercode"), vercode);
		} else {
			driver.sendKeys(By.name("vercode"), this.vercode);
		}
	}

	public void clickLoginButton() {
		driver.click(By.xpath("//input[@type='submit'][@value='��¼']"));
	}

	public void login(String userName, String passWord, String vercode) {
		inputUserName(userName);
		inputPassWord(passWord);
		inputVercode(vercode);
		clickLoginButton();
	}

	/**
	 * ��¼�ɹ�
	 * 
	 * @param userName
	 * @param passWord
	 * @param vercode
	 * @return
	 */
	public HomePage loginOK(String userName, String passWord, String vercode) {
		login(userName, passWord, vercode);
		return new HomePage(driver);
	}

	/**
	 * �û������󣬵�¼ʧ��
	 * 
	 * @param userName
	 * @param passWord
	 * @param vercode
	 * @return
	 */
	public LoginPage loginByNameErr(String userName, String passWord,
			String vercode) {
		login(userName, passWord, vercode);
		return this;
	}

	/**
	 * ������󣬵�¼ʧ��
	 * 
	 * @param userName
	 * @param passWord
	 * @param vercode
	 * @return
	 */
	public LoginPage loginByPwdErr(String userName, String passWord,
			String vercode) {
		login(userName, passWord, vercode);
		return this;
	}

	/**
	 * ��֤����󣬵�¼ʧ��
	 * 
	 * @param userName
	 * @param passWord
	 * @param vercode
	 * @return
	 */
	public LoginPage loginByVercodeErr(String userName, String passWord,
			String vercode) {
		login(userName, passWord, vercode);
		return this;
	}

	public HomePage goHomePage() {
		driver.click(By.partialLinkText("������ҳ"));
		return new HomePage(driver);
	}
}
