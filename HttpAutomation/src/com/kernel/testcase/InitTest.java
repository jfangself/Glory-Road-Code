package com.kernel.testcase;

import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.kernel.action.RegisterAction;
import com.kernel.basecase.BaseCase;
import com.kernel.util.Base64;
import com.kernel.util.DateTimeUtil;
import com.kernel.util.ExcelUtil;

public class InitTest extends BaseCase {
	private String uid;
	private String email;
	private String password;
	private String authtime;
	private RegisterAction RegisterAction;
	private Logger logger = Logger.getLogger(InitTest.class);

	@BeforeSuite(alwaysRun = true)
	public void beforeTestSuite() {
		beforeSuite();
		Map<String, String> user1Map = ExcelUtil.importDataTable(
				"testdata.xls", "InitTest", "inituser1");
		RegisterAction = new RegisterAction();
		uid = user1Map.get("uid");
		email = user1Map.get("email");
		password = Base64.encode(user1Map.get("password"), "utf-8");
		authtime = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss");

		try {
			JSONObject JSONObject = RegisterAction.register(email, password,
					uid, authtime);
			String errorcode = JSONObject.getJSONObject("result").optString(
					"errorcode");
			if ("ok".equals(errorcode)) {
				logger.debug("init user data success,email:" + email + ",uid:"
						+ uid + ",password:" + password + ",authtime:"
						+ authtime);
			} else {
				logger.error("init user data failed,email:" + email + ",uid:"
						+ uid + ",password:" + password + ",authtime:"
						+ authtime);
			}
		} catch (Exception e) {
			logger.error("Ö´ÐÐInitTest.beforeTestSuite´íÎó£º", e);
		}

		Map<String, String> user2Map = ExcelUtil.importDataTable(
				"testdata.xls", "InitTest", "inituser2");
		RegisterAction = new RegisterAction();
		uid = user2Map.get("uid");
		email = user2Map.get("email");
		password = Base64.encode(user2Map.get("password"), "utf-8");
		authtime = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss");

		try {
			JSONObject JSONObject = RegisterAction.register(email, password,
					uid, authtime);
			String errorcode = JSONObject.getJSONObject("result").optString(
					"errorcode");
			if ("ok".equals(errorcode)) {
				logger.debug("init user data success,email:" + email + ",uid:"
						+ uid + ",password:" + password + ",authtime:"
						+ authtime);
			} else {
				logger.error("init user data failed,email:" + email + ",uid:"
						+ uid + ",password:" + password + ",authtime:"
						+ authtime);
			}
		} catch (Exception e) {
			logger.error("Ö´ÐÐInitTest.beforeTestSuite´íÎó£º", e);
		}
	}

	@AfterSuite(alwaysRun = true)
	public void afterTestSuite() {
		afterSuite();
	}
}
