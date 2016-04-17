package com.kernel.testcase;

import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;

import android.util.Log;

import com.kernel.activity.AddItem;
import com.kernel.activity.Login;
import com.kernel.activity.Main;
import com.kernel.activity.ManageItem;
import com.kernel.util.ConstantUtil;
import com.kernel.util.DateTimeUtil;
import com.robotium.solo.Solo;

public class Case05ItemTest extends AthrunTestCase {
	private String className = this.getClass().getName();
	private Solo solo;
	private Login Login;
	private Main Main;
	private ManageItem ManageItem;
	private AddItem AddItem;
	private String itemName;
	private String desc;
	private String remark;
	private String kindName;
	private final String TAG = ConstantUtil.TAG;
	private final String PATH = ConstantUtil.PATH;
	private final long TIMEOUT = ConstantUtil.TIMEOUT;

	public Case05ItemTest() throws Exception {
		super("org.crazyit.auction.client", "org.crazyit.auction.client.Login");
		AthrunTestCase.setMaxTimeToFindView(10000);
		Log.i(TAG, "running Case05ItemTest");
	}

	public void setUp() {
		Log.i(TAG, "running setUp");
		try {
			solo = new Solo(getInstrumentation(), getActivity());
			Login = new Login(this, solo);
			Main = Login.loginOk("mysql", "mysql");
			super.setUp();
		} catch (Exception e) {
			logger.error("setUp error", e);
		}
	}

	/**
	 * 
	 * 添加成功弹出提示框
	 */
	@Test
	public void test01addItemOk() {
		Log.i(TAG, "running test01addItemOk");
		boolean flag = false;
		String captureName = "";
		itemName = DateTimeUtil.getDateTime();
		desc = DateTimeUtil.getDateTime();
		remark = DateTimeUtil.getDateTime();
		ConstantUtil.DATA.put("test01addItemOk.itemName", itemName);
		kindName = ConstantUtil.DATA.get("test01addKindOk.kindName");
		Log.d(TAG, "ConstantUtil.DATA:" + ConstantUtil.DATA);
		try {
			ManageItem = Main.goManageItem();
			AddItem = ManageItem.gotoAddItem();
			AddItem.addItemOk(itemName, desc, remark, "20", 7, kindName);
			flag = solo.waitForText("物品添加成功", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test01addItemOk";
				solo.takeScreenshot(captureName);
			}
			
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	/**
	 * 
	 * 添加的item存在
	 */
	@Test
	public void test02itemExist() {
		Log.i(TAG, "running test02itemExist");
		boolean flag = false;
		String captureName = "";
		itemName = ConstantUtil.DATA.get("test01addItemOk.itemName");
		Log.d(TAG, "ConstantUtil.DATA:" + ConstantUtil.DATA);
		try {
			Main.goManageItem();
			flag = solo.waitForText(itemName, 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test02itemExist";
				solo.takeScreenshot(captureName);
			}
			
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	/**
	 * 
	 * 添加失败弹出提示框
	 */
	@Test
	public void test03addItemdByNameEmpty() {
		Log.i(TAG, "running test03addItemdByNameEmpty");
		boolean flag = false;
		String captureName = "";
		desc = DateTimeUtil.getDateTime();
		remark = DateTimeUtil.getDateTime();
		Log.d(TAG, "ConstantUtil.DATA:" + ConstantUtil.DATA);
		try {
			ManageItem = Main.goManageItem();
			AddItem = ManageItem.gotoAddItem();
			AddItem.addItemByNameEmpty(desc, remark, "20");
			flag = solo.waitForText("物品名称是必填项", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test03addItemdByNameEmpty";
				solo.takeScreenshot(captureName);
			}
			
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	/**
	 * 
	 * 添加失败弹出提示框
	 */
	@Test
	public void test04addItemByPriceEmpty() {
		Log.i(TAG, "running test04addItemByPriceEmpty");
		boolean flag = false;
		String captureName = "";
		itemName = DateTimeUtil.getDateTime();
		desc = DateTimeUtil.getDateTime();
		remark = DateTimeUtil.getDateTime();
		Log.d(TAG, "ConstantUtil.DATA:" + ConstantUtil.DATA);
		try {
			ManageItem = Main.goManageItem();
			AddItem = ManageItem.gotoAddItem();
			AddItem.addItemByPriceEmpty(itemName, desc, remark);
			flag = solo.waitForText("起拍价格是必填项", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test04addItemByPriceEmpty";
				solo.takeScreenshot(captureName);
			}
			
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	/**
	 * 
	 * 取消添加返回ManageItem
	 */
	@Test
	public void test05cancelAddItem() {
		Log.i(TAG, "running test05cancelAddItem");
		boolean flag = false;
		String captureName = "";
		itemName = DateTimeUtil.getDateTime();
		desc = DateTimeUtil.getDateTime();
		remark = DateTimeUtil.getDateTime();
		ConstantUtil.DATA.put("test05cancelAddItem.itemName", itemName);
		Log.d(TAG, "ConstantUtil.DATA:" + ConstantUtil.DATA);
		try {
			ManageItem = Main.goManageItem();
			AddItem = ManageItem.gotoAddItem();
			AddItem.cancelAddItem(itemName, desc, remark, "20");
			flag = solo.waitForText("您当前的拍卖物品", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test05cancelAddItem";
				solo.takeScreenshot(captureName);
			}
			
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	/**
	 * 
	 * 取消添加的item不存在
	 */
	@Test
	public void test06itemNotExist() {
		Log.i(TAG, "running test06itemNotExist");
		boolean flag = true;
		String captureName = "";
		itemName = ConstantUtil.DATA.get("test05cancelAddItem.itemName");
		Log.d(TAG, "ConstantUtil.DATA:" + ConstantUtil.DATA);
		try {
			Main.goManageItem();
			flag = solo.waitForText(itemName, 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (flag) {
				captureName = className + ".test06itemNotExist";
				solo.takeScreenshot(captureName);
			}
			
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", false, flag);
	}

	public void tearDown() {
		Log.i(TAG, "running tearDown");
		try {
			super.tearDown();
		} catch (Exception e) {
			logger.error("tearDown error", e);
		}
	}
}
