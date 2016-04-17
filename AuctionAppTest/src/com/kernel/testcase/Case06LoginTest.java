package com.kernel.testcase;

import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.kernel.util.ConstantUtil;
import com.robotium.solo.Solo;

public class Case06LoginTest extends AthrunTestCase {
	private String className = this.getClass().getName();
	private Solo solo;
	private final String TAG = ConstantUtil.TAG;
	private final String PATH = ConstantUtil.PATH;

	public Case06LoginTest() throws Exception {
		super("org.crazyit.auction.client", "org.crazyit.auction.client.Login");
		AthrunTestCase.setMaxTimeToFindView(10000);
		Log.i(TAG, "running Case06LoginTest");
	}

	public void setUp() {
		Log.i(TAG, "running setUp");
		try {
			solo = new Solo(getInstrumentation(), getActivity());
			super.setUp();
		} catch (Exception e) {
			Log.e(TAG, "setUp error", e);
		}
	}

	@Test
	public void test01LoginOk() {
		Log.i(TAG, "running test01LoginOk");
		boolean flag = false;
		String captureName = "";
		try {
			EditText etName = (EditText) solo.getView("userEditText");
			solo.clearEditText(etName);
			solo.enterText(etName, "mysql");
			EditText etPass = (EditText) solo.getView("pwdEditText");
			solo.clearEditText(etPass);
			solo.enterText(etPass, "mysql");
			Button bnLogin = (Button) solo.getView("bnLogin");
			solo.clickOnView(bnLogin);
			flag = solo.searchText("管理物品");
			if (!flag) {
				captureName = className + ".test01LoginOk";
				solo.takeScreenshot(captureName);
			}
			
		} catch (Exception e) {
			Log.e(TAG, captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	@Test
	public void test02LoginByNameErr() {
		Log.i(TAG, "running test02LoginByNameErr");
		boolean flag = false;
		String captureName = "";
		try {
			EditText etName = (EditText) solo.getView("userEditText");
			solo.clearEditText(etName);
			solo.enterText(etName, "mysql1");
			EditText etPass = (EditText) solo.getView("pwdEditText");
			solo.clearEditText(etPass);
			solo.enterText(etPass, "mysql");
			Button bnLogin = (Button) solo.getView("bnLogin");
			solo.clickOnView(bnLogin);
			flag = solo.searchText("用户名称或者密码错误");
			if (!flag) {
				captureName = className + ".test02LoginByNameErr";
				solo.takeScreenshot(captureName);
			}
			
		} catch (Exception e) {
			Log.e(TAG, captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	public void tearDown() {
		Log.i(TAG, "running tearDown");
		try {
			super.tearDown();
		} catch (Exception e) {
			Log.e(TAG, "tearDown error", e);
		}
	}
}
