package com.kernel.activity;

import org.athrun.android.framework.AthrunTestCase;

import android.util.Log;

import com.kernel.util.ConstantUtil;
import com.robotium.solo.Solo;

public class Main {
	private AthrunTestCase athrun;
	private Solo solo;
	private final String TAG = ConstantUtil.TAG;

	public Main(AthrunTestCase athrun, Solo solo) {
		this.athrun = athrun;
		this.solo = solo;
		Log.i(TAG, "running test in Main");
	}

	public ViewSuccessItem goViewSuccessItem() {
		Log.i(TAG, "execute goViewSuccessItem method");
		solo.clickOnText("查看竞得物品");
		return new ViewSuccessItem(athrun, solo);
	}

	public ViewFailItem goViewFailItem() {
		Log.i(TAG, "execute goViewFailItem method");
		solo.clickOnText("浏览流拍物品");
		return new ViewFailItem(athrun, solo);
	}

	public ManageKind goManageKind() {
		Log.i(TAG, "execute goManageKind method");
		solo.clickOnText("管理物品种类");
		return new ManageKind(athrun, solo);
	}

	public ManageItem goManageItem() {
		Log.i(TAG, "execute goManageItem method");
		solo.clickInList(4);
		return new ManageItem(athrun, solo);
	}

	public ChooseKind goChooseKind() {
		Log.i(TAG, "execute goChooseKind method");
		solo.clickOnText("浏览拍卖物品");
		return new ChooseKind(athrun, solo);
	}

	public ViewBid goViewBid() {
		Log.i(TAG, "execute goViewBid method");
		solo.clickOnText("查看自己的竞标");
		return new ViewBid(athrun, solo);
	}
}
