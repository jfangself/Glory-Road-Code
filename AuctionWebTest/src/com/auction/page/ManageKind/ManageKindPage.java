package com.auction.page.ManageKind;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

public class ManageKindPage extends BasePage {
	private String vercode;
	private Logger logger = Logger.getLogger(ManageKindPage.class);

	public ManageKindPage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��ManageKindPage��");
		vercode = getVercode("GBK");
	}

	public void inputKindName(String kindName) {
		driver.sendKeys(By.name("name"), kindName);
	}

	public void inputKindDesc(String kindDesc) {
		driver.sendKeys(By.name("desc"), kindDesc);
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

	public void clickAddButton() {
		driver.click(By.xpath("//input[@type='submit'][@value='���']"));
	}

	public void addKind(String kindName, String kindDesc, String vercode) {
		this.inputKindName(kindName);
		this.inputKindDesc(kindDesc);
		this.inputVercode(vercode);
		this.clickAddButton();
	}

	/**
	 * ���������ɹ�
	 * 
	 * @param data
	 * @param vercode
	 * @return
	 */
	public ManageKindPage addKindOK(String data, String vercode) {
		this.addKind(data, data, vercode);
		return this;
	}

	/**
	 * ��������࣬������Ϊ��
	 * 
	 * @param data
	 * @param vercode
	 * @return
	 */
	public ManageKindPage addKindByKindNameEmpty(String data, String vercode) {
		this.addKind("", data, vercode);
		return this;
	}

	/**
	 * ��������࣬��֤��Ϊ��
	 * 
	 * @param data
	 * @param vercode
	 * @return
	 */
	public ManageKindPage addKindByVercodeEmpty(String data) {
		this.addKind(data, data, "");
		return this;
	}

	/**
	 * ��������࣬��֤�����
	 * 
	 * @param data
	 * @param vercode
	 * @return
	 */
	public ManageKindPage addKindByVercodeErr(String data, String vercode) {
		this.addKind(data, data, vercode);
		return this;
	}

	/**
	 * ɾ�����������
	 * 
	 * @param kindName
	 * @return
	 */
	public ManageKindPage delKind(String kindName) {
		driver.click(By.xpath("//td[contains(text(),'" + kindName
				+ "')]/following::a[contains(text(),'ɾ��')]"));
		driver.chooseOKOnAlert();
		driver.pause(50);
		return this;
	}

	public HomePage goHomePage() {
		driver.click(By.partialLinkText("������ҳ"));
		return new HomePage(driver);
	}
}
