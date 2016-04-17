package com.kernel.activity;

import org.athrun.android.framework.AthrunTestCase;

import android.util.Log;
import android.widget.Button;

import com.kernel.util.ConstantUtil;
import com.robotium.solo.Solo;

public class ManageKind {
	private AthrunTestCase athrun;
	private Solo solo;
	private final String TAG = ConstantUtil.TAG;

	public ManageKind(AthrunTestCase athrun, Solo solo) {
		this.athrun = athrun;
		this.solo = solo;
		Log.i(TAG, "running test in ManageKind");
	}

	public void clickHome() {

		Button bn_home = (Button) solo.getView("bn_home");
		solo.clickOnView(bn_home);
	}

	public void clickAddKind() {

		Button bnAdd = (Button) solo.getView("bnAdd");
		solo.clickOnView(bnAdd);
	}

	public void longClickOnKindListItem(String name) {

		solo.clickLongOnText(name, 1, true);
	}

	public void chooseOkOnConfirm() {

		solo.clickOnButton("确定");
	}

	public void clickDialog() {

		solo.clickOnButton("确定");
	}

	public Main gotoMain() {

		clickHome();
		return new Main(athrun, solo);
	}
	
	public Main goBackToMainActivity() {
		solo.goBackToActivity("Main");
		return new Main(athrun, solo);
	}

	public AddKind gotoAddKind() {

		clickAddKind();
		return new AddKind(athrun, solo);
	}

	public void delKind(String name) {
		this.longClickOnKindListItem(name);
		this.chooseOkOnConfirm();
	}

	public ManageKind delKindOk(String name) {
		this.delKind(name);
		return this;
	}

	public ManageKind delKindUsedByItem(String name) {
		this.delKind(name);
		return this;
	}

	public Main delKindAndGotoMain(String name) {
		this.delKind(name);
		this.clickDialog();
		return this.gotoMain();
	}
}
