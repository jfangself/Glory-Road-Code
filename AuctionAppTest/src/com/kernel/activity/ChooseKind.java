package com.kernel.activity;

import org.athrun.android.framework.AthrunTestCase;

import android.util.Log;

import com.kernel.util.ConstantUtil;
import com.robotium.solo.Solo;

public class ChooseKind {
	private AthrunTestCase athrun;
	private Solo solo;
	private final String TAG = ConstantUtil.TAG;

	public ChooseKind(AthrunTestCase athrun, Solo solo) {
		this.athrun = athrun;
		this.solo = solo;
		Log.i(TAG, "running test in ChooseKind");
	}

}
