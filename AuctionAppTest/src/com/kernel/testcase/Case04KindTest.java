package com.kernel.testcase;

import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;

import android.util.Log;

import com.kernel.activity.AddItem;
import com.kernel.activity.AddKind;
import com.kernel.activity.Login;
import com.kernel.activity.Main;
import com.kernel.activity.ManageItem;
import com.kernel.activity.ManageKind;
import com.kernel.util.ConstantUtil;
import com.kernel.util.DateTimeUtil;
import com.robotium.solo.Solo;

public class Case04KindTest extends AthrunTestCase {
	private String className = this.getClass().getName();
	private Solo solo;
	private Login Login;
	private Main Main;
	private ManageKind ManageKind;
	private AddKind AddKind;
	private ManageItem ManageItem;
	private AddItem AddItem;
	private String kindName;
	private String desc;
	private String remark;
	private String itemName;
	private final String TAG = ConstantUtil.TAG;
	private final String PATH = ConstantUtil.PATH;
	private final long TIMEOUT = ConstantUtil.TIMEOUT;

	public Case04KindTest() throws Exception {
		super("org.crazyit.auction.client", "org.crazyit.auction.client.Login");
		AthrunTestCase.setMaxTimeToFindView(10000);
		Log.i(TAG, "running Case04KindTest");
	}

	public void setUp() {
		Log.i(TAG, "running setUp");
		try {
			solo = new Solo(getInstrumentation(), getActivity());
			Main = new Main(this, solo);
			ManageKind = new ManageKind(this, solo);
			AddKind = new AddKind(this, solo);
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
	public void test01addKindOk() {
		Log.i(TAG, "running test01addKindOk");
		boolean flag = false;
		String captureName = "";
		kindName = DateTimeUtil.getDateTime();
		desc = DateTimeUtil.getDateTime();
		ConstantUtil.DATA.put("test01addKindOk.kindName", kindName);
		Log.d(TAG, "ConstantUtil.DATA:" + ConstantUtil.DATA);
		try {
			ManageKind = Main.goManageKind();
			AddKind = ManageKind.gotoAddKind();
			AddKind.addKindOk(kindName, desc);
			flag = solo.waitForText("种类添加成功", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test01addKindOk";
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
	 * 添加的kind存在
	 */
	@Test
	public void test02kindExist() {
		Log.i(TAG, "running test02kindExist");
		boolean flag = false;
		String captureName = "";
		kindName = ConstantUtil.DATA.get("test01addKindOk.kindName");
		Log.d(TAG, "name:" + kindName);
		try {
			Main.goManageKind();
			flag = solo.waitForText(kindName, 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test02kindExist";
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
	public void test03addKindByNameEmpty() {
		Log.i(TAG, "running test03addKindByNameEmpty");
		boolean flag = false;
		String captureName = "";
		desc = DateTimeUtil.getDateTime();
		try {
			ManageKind = Main.goManageKind();
			AddKind = ManageKind.gotoAddKind();
			AddKind.addKindByNameEmpty(desc);
			flag = solo.waitForText("种类名称是必填项", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test03addKindByNameEmpty";
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
	 * 取消添加返回ManageKind
	 */
	@Test
	public void test04cancelAddKind() {
		Log.i(TAG, "running test04cancelAddKind");
		boolean flag = false;
		String captureName = "";
		kindName = DateTimeUtil.getDateTime();
		desc = DateTimeUtil.getDateTime();
		ConstantUtil.DATA.put("test04cancelAddKind.kindName", kindName);
		Log.d(TAG, "ConstantUtil.DATA:" + ConstantUtil.DATA);
		try {
			ManageKind = Main.goManageKind();
			AddKind = ManageKind.gotoAddKind();
			AddKind.cancelAddKind(kindName, desc);
			flag = solo.waitForText("系统的所有物品种类", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test04cancelAddKind";
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
	 * 取消添加的Kind不存在
	 */
	@Test
	public void test05kindNotExist() {
		Log.i(TAG, "running test05kindNotExist");
		boolean flag = true;
		String captureName = "";
		kindName = ConstantUtil.DATA.get("test04cancelAddKind.kindName");
		Log.d(TAG, "name:" + kindName);
		try {
			Main.goManageKind();
			flag = solo.waitForText(kindName, 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (flag) {
				captureName = className + ".test05kindNotExist";
				solo.takeScreenshot(captureName);
			}

		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", false, flag);
	}

	/**
	 * 
	 * 删除未被物品关联的种类成功弹出提示框
	 */
	@Test
	public void test06delKindOk() {
		Log.i(TAG, "running test06delKindOk");
		boolean flag = false;
		String captureName = "";
		kindName = DateTimeUtil.getDateTime();
		desc = DateTimeUtil.getDateTime();
		ConstantUtil.DATA.put("test06delKindOk.kindName", kindName);
		try {
			ManageKind = Main.goManageKind();
			AddKind = ManageKind.gotoAddKind();
			ManageKind = AddKind.addKindAndBackToManageKind(kindName, desc);
			Main = ManageKind.goBackToMainActivity();
			ManageKind = Main.goManageKind();
			ManageKind.delKindOk(kindName);
			flag = solo.waitForText("种类删除成功", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test06delKindOk";
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
	 * 删除的Kind不存在
	 */
	@Test
	public void test07delKindNotExist() {
		Log.i(TAG, "running test07delKindNotExist");
		boolean flag = true;
		String captureName = "";
		kindName = ConstantUtil.DATA.get("test06delKindOk.kindName");
		Log.d(TAG, "name:" + kindName);
		try {
			ManageKind = Main.goManageKind();
			flag = solo.waitForText(kindName, 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			flag = solo.searchText(kindName, 1, true);
			if (flag) {
				captureName = className + ".test07delKindNotExist";
				solo.takeScreenshot(captureName);
			}

		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", false, flag);
	}

	/**
	 * 
	 * 删除已被物品关联的种类失败弹出提示框
	 */
	@Test
	public void test08delKindUsedByItem() {
		Log.i(TAG, "running test08delKindUsedByItem");
		boolean flag = false;
		String captureName = "";
		kindName = ConstantUtil.DATA.get("test01addKindOk.kindName");
		itemName = DateTimeUtil.getDateTime();
		desc = DateTimeUtil.getDateTime();
		remark = DateTimeUtil.getDateTime();
		try {
			ManageItem = Main.goManageItem();
			AddItem = ManageItem.gotoAddItem();
			ManageItem = AddItem.addItemAndBackToManageItem(itemName, desc,
					remark, "20", 7, kindName);
			Main = ManageItem.goBackToMainActivity();
			ManageKind = Main.goManageKind();
			ManageKind.delKindUsedByItem(kindName);
			flag = solo.waitForText("该种类已有物品关联", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test08delKindUsedByItem";
				solo.takeScreenshot(captureName);
			}

		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
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
