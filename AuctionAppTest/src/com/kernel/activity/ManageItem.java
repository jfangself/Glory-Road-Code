package com.kernel.activity;

import org.athrun.android.framework.AthrunTestCase;

import android.util.Log;
import android.widget.Button;

import com.kernel.util.ConstantUtil;
import com.robotium.solo.Solo;

public class ManageItem {
	private AthrunTestCase athrun;
	private Solo solo;
	private final String TAG = ConstantUtil.TAG;

	public ManageItem(AthrunTestCase athrun, Solo solo) {
		this.athrun = athrun;
		this.solo = solo;
		Log.i(TAG, "running test in ManageItem");
	}

	public void clickHome() {

		Button bn_home = (Button) solo.getView("bn_home");
		solo.clickOnView(bn_home);
	}

	public void clickAddItem() {

		Button bnAdd = (Button) solo.getView("bnAdd");
		solo.clickOnView(bnAdd);
	}

	public ManageItem chooseOkOnConfirm() {

		solo.clickOnButton("确定");
		return this;
	}

	public ManageItem clickDialog() {

		solo.clickOnButton("确定");
		return this;
	}

	public Main gotoMain() {

		clickHome();
		return new Main(athrun, solo);
	}
	
	public Main goBackToMainActivity() {
		solo.goBackToActivity("Main");
		return new Main(athrun, solo);
	}

	public AddItem gotoAddItem() {

		clickAddItem();
		return new AddItem(athrun, solo);
	}
}
