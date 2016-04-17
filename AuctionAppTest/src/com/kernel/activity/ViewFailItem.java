package com.kernel.activity;

import org.athrun.android.framework.AthrunTestCase;

import android.util.Log;

import com.kernel.util.ConstantUtil;
import com.robotium.solo.Solo;

public class ViewFailItem {
	private AthrunTestCase athrun;
	private Solo solo;
	private final String TAG = ConstantUtil.TAG;

	public ViewFailItem(AthrunTestCase athrun, Solo solo) {
		this.athrun = athrun;
		this.solo = solo;
		Log.i(TAG, "running test in ViewFailItem");
	}

}
