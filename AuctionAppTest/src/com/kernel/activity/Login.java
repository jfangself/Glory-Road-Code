package com.kernel.activity;

import org.athrun.android.framework.AthrunTestCase;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.kernel.util.ConstantUtil;
import com.robotium.solo.Solo;

public class Login {
	private AthrunTestCase athrun;
	private Solo solo;
	private final String TAG = ConstantUtil.TAG;

	public Login(AthrunTestCase athrun, Solo solo) {
		this.athrun = athrun;
		this.solo = solo;
		Log.i(TAG, "running test in Login");
	}

	public void inputName(String name) {

		EditText etName = (EditText) solo.getView("userEditText");
		solo.clearEditText(etName);
		solo.enterText(etName, name);
	}

	public void inputPwd(String pwd) {

		EditText etPass = (EditText) solo.getView("pwdEditText");
		solo.clearEditText(etPass);
		solo.enterText(etPass, pwd);
	}

	public void clickLogin() {
		Button bnLogin = (Button) solo.getView("bnLogin");
		solo.clickOnView(bnLogin);
	}

	public void clickCancel() {
		Button bnCancel = (Button) solo.getView("bnCancel");
		solo.clickOnView(bnCancel);
	}

	public void login(String name, String pwd) {
		inputName(name);
		inputPwd(pwd);
		clickLogin();
	}

	public Main loginOk(String name, String pwd) {
		Log.i(TAG, "execute loginOk method");
		login(name, pwd);
		return new Main(athrun, solo);
	}

	public Login loginByNameErr(String name, String pwd) {
		Log.i(TAG, "execute loginByNameErr method");
		login(name, pwd);
		return this;
	}

	public Login loginByPwdErr(String name, String pwd) {
		Log.i(TAG, "execute loginByPwdErr method");
		login(name, pwd);
		return this;
	}
}
