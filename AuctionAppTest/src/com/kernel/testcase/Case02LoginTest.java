package com.kernel.testcase;

import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;

import android.util.Log;

import com.kernel.activity.Login;
import com.kernel.util.ConstantUtil;
import com.robotium.solo.Solo;

public class Case02LoginTest extends AthrunTestCase {
	private String className = this.getClass().getName();
	private Solo solo;
	private Login Login;
	private final String TAG = ConstantUtil.TAG;
	private final String PATH = ConstantUtil.PATH;
	private final long TIMEOUT = ConstantUtil.TIMEOUT;

	public Case02LoginTest() throws Exception {
		super("org.crazyit.auction.client", "org.crazyit.auction.client.Login");
		AthrunTestCase.setMaxTimeToFindView(10000);
		Log.i(TAG, "running Case02LoginTest");
	}

	public void setUp() {
		Log.i(TAG, "running setUp");
		try {
			solo = new Solo(getInstrumentation(), getActivity());
			Login = new Login(this, solo);
			super.setUp();
		} catch (Exception e) {
			logger.error("setUp error", e);
		}
	}

	/**
	 * 
	 * 登录成功进入Main
	 */
	@Test
	public void test01LoginOk() {
		Log.i(TAG, "running test01LoginOk");
		boolean flag = false;
		String captureName = "";
		try {
			Login.loginOk("mysql", "mysql");
			flag = solo.waitForText("管理物品", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test01LoginOk";
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
	 * 登录失败弹出提示框
	 */
	@Test
	public void test02LoginByNameErr() {
		Log.i(TAG, "running test02LoginByNameErr");
		boolean flag = false;
		String captureName = "";
		try {
			Login.loginByNameErr("mysql1", "mysql");
			flag = solo.waitForText("用户名称或者密码错误", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test02LoginByNameErr";
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
	 * 登录失败弹出提示框
	 */
	@Test
	public void test03LoginByPwdErr() {
		Log.i(TAG, "running test03LoginByPwdErr");
		boolean flag = false;
		String captureName = "";
		try {
			Login.loginByPwdErr("mysql", "mysql1");
			flag = solo.waitForText("用户名称或者密码错误", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test03LoginByPwdErr";
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
