package com.kernel.activity;

import org.athrun.android.framework.AthrunTestCase;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.kernel.util.ConstantUtil;
import com.kernel.util.RandomUtil;
import com.robotium.solo.Solo;

public class AddItem {
	private AthrunTestCase athrun;
	private Solo solo;
	private final String TAG = ConstantUtil.TAG;

	public AddItem(AthrunTestCase athrun, Solo solo) {
		this.athrun = athrun;
		this.solo = solo;
		Log.i(TAG, "running test in AddItem");
	}

	public void inputName(String name) {

		EditText itemName = (EditText) solo.getView("itemName");
		solo.clearEditText(itemName);
		solo.enterText(itemName, name);
	}

	public void inputDesc(String desc) {

		EditText itemDesc = (EditText) solo.getView("itemDesc");
		solo.clearEditText(itemDesc);
		solo.enterText(itemDesc, desc);
	}

	public void inputRemark(String remark) {

		EditText itemRemark = (EditText) solo.getView("itemRemark");
		solo.clearEditText(itemRemark);
		solo.enterText(itemRemark, remark);
	}

	public void inputInitPrice(String price) {

		EditText initPrice = (EditText) solo.getView("initPrice");
		solo.clearEditText(initPrice);
		solo.enterText(initPrice, price);
	}

	public void secectAvailTimeRandom() {

		Spinner availTime = (Spinner) solo.getView("availTime");
		int availTimes = availTime.getCount();
		Log.d(TAG, "availTimes:" + availTimes);
		solo.pressSpinnerItem(0, RandomUtil.getRandomNumber(1, availTimes + 1));
	}

	public void secectAvailTime(int itemIndex) {

		solo.pressSpinnerItem(0, itemIndex);
	}

	public void secectKindRandom() {

		Spinner itemKind = (Spinner) solo.getView("itemKind");
		int kinds = itemKind.getCount();
		Log.d(TAG, "kinds:" + kinds);
		solo.pressSpinnerItem(1, RandomUtil.getRandomNumber(1, kinds + 1));
	}

	public void secectKind(String kind) {

		Spinner itemKind = (Spinner) solo.getView("itemKind");
		int kinds = itemKind.getCount();
		Log.d(TAG, "kinds:" + kinds);
		// solo.pressSpinnerItem(1, kinds);
		solo.clickOnView(itemKind);
		solo.clickOnText(kind, 1, true);
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

		solo.clickOnButton("确定");
	}

	/**
	 * 
	 * 指定AvailTime与Kind
	 * */
	public void addItem(String name, String desc, String remark, String price,
			int itemIndex, String kind) {
		this.inputName(name);
		this.inputDesc(desc);
		this.inputRemark(remark);
		this.inputInitPrice(price);
		this.secectAvailTime(itemIndex);
		this.secectKind(kind);
		this.clickAdd();
	}

	/**
	 * 
	 * 随机选择AvailTime与Kind
	 * */
	public void addItem(String name, String desc, String remark, String price) {
		this.inputName(name);
		this.inputDesc(desc);
		this.inputRemark(remark);
		this.inputInitPrice(price);
		this.secectAvailTimeRandom();
		this.secectKindRandom();
		this.clickAdd();
	}

	/**
	 * 
	 * 指定AvailTime与Kind
	 * */
	public AddItem addItemOk(String name, String desc, String remark,
			String price, int itemIndex, String kind) {
		this.addItem(name, desc, remark, price, itemIndex, kind);
		return this;
	}

	/**
	 * 
	 * 指定AvailTime与Kind
	 * */
	public ManageItem addItemAndBackToManageItem(String name, String desc,
			String remark, String price, int itemIndex, String kind) {
		this.addItem(name, desc, remark, price, itemIndex, kind);
		this.clickDialog();
		return new ManageItem(athrun, solo);
	}

	/**
	 * 
	 * 指定AvailTime与Kind
	 * */
	public Main goBackToMainActivity() {
		solo.goBackToActivity("Main");
		return new Main(athrun, solo);
	}

	/**
	 * 
	 * 随机选择AvailTime与Kind
	 * */
	public AddItem addItemOk(String name, String desc, String remark,
			String price) {
		this.addItem(name, desc, remark, price);
		return this;
	}

	/**
	 * 
	 * 随机选择AvailTime与Kind
	 * */
	public AddItem addItemByNameEmpty(String desc, String remark, String price) {
		this.addItem("", desc, remark, price);
		return this;
	}

	/**
	 * 
	 * 随机选择AvailTime与Kind
	 * */
	public AddItem addItemByPriceEmpty(String name, String desc, String remark) {
		this.addItem(name, desc, remark, "");
		return this;
	}

	/**
	 * 
	 * 随机选择AvailTime与Kind
	 * */
	public AddItem addItemByPriceInvild(String name, String desc,
			String remark, String price) {
		this.addItem(name, desc, remark, price);
		return this;
	}

	public ManageItem cancelAddItem(String name, String desc, String remark,
			String price) {
		this.inputName(name);
		this.inputDesc(desc);
		this.inputRemark(remark);
		this.inputInitPrice(price);
		this.secectAvailTimeRandom();
		this.secectKindRandom();
		this.clickCancel();
		return new ManageItem(athrun, solo);
	}
}
