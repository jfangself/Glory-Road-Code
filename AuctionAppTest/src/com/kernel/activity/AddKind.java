package com.kernel.activity;

import org.athrun.android.framework.AthrunTestCase;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.kernel.util.ConstantUtil;
import com.robotium.solo.Solo;

public class AddKind {
	private AthrunTestCase athrun;
	private Solo solo;
	private final String TAG = ConstantUtil.TAG;

	public AddKind(AthrunTestCase athrun, Solo solo) {
		this.athrun = athrun;
		this.solo = solo;
		Log.i(TAG, "running test in AddKind");
	}

	public void inputName(String name) {

		EditText kindName = (EditText) solo.getView("kindName");
		solo.clearEditText(kindName);
		solo.enterText(kindName, name);
	}

	public void inputDesc(String desc) {

		EditText kindDesc = (EditText) solo.getView("kindDesc");
		solo.clearEditText(kindDesc);
		solo.enterText(kindDesc, desc);
	}

	public void clickAdd() {

		Button bnAdd = (Button) solo.getView("bnAdd");
		solo.clickOnView(bnAdd);
	}

	public void clickCancel() {

		Button bnCancel = (Button) solo.getView("bnCancel");
		solo.clickOnView(bnCancel);
	}

	public void clickDialog() {

		solo.clickOnButton("È·¶¨");
	}

	public void addKind(String name, String desc) {
		this.inputName(name);
		this.inputDesc(desc);
		this.clickAdd();
	}

	public AddKind addKindOk(String name, String desc) {
		this.addKind(name, desc);
		return this;
	}

	public Main goBackToMainActivity() {
		solo.goBackToActivity("Main");
		return new Main(athrun, solo);
	}

	public ManageKind addKindAndBackToManageKind(String name, String desc) {
		this.addKind(name, desc);
		this.clickDialog();
		return new ManageKind(athrun, solo);
	}

	public AddKind addKindByNameEmpty(String desc) {
		this.addKind("", desc);
		return this;
	}

	public ManageKind cancelAddKind(String name, String desc) {
		this.inputName(name);
		this.inputDesc(desc);
		this.clickCancel();
		return new ManageKind(athrun, solo);
	}
}
