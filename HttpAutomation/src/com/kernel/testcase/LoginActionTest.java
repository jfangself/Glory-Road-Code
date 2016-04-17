package com.kernel.testcase;

import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kernel.action.LoginAction;
import com.kernel.basecase.BaseCase;
import com.kernel.util.Base64;
import com.kernel.util.ExcelUtil;

@Test(groups = { "LoginActionTest" }, description = "µ«¬º≤‚ ‘")
public class LoginActionTest extends BaseCase {
	private LoginAction LoginAction;
	private Logger logger = Logger.getLogger(LoginActionTest.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		try {
			beforeClass();
			LoginAction = new LoginAction();
		} catch (Exception e) {
			logger.error("÷¥––LoginActionTest.beforeClassTest¥ÌŒÛ£∫", e);
		}
	}

	@Test(enabled = true, alwaysRun = true, description = "µ«¬º≤‚ ‘")
	public void testLogin() {
		boolean flag = false;

		try {
			beforeTest("testLogin");
			Map<String, String> userMap = ExcelUtil.importDataTable(
					"testdata.xls", "LoginActionTest", "testLogin");
			String email = userMap.get("email");
			String password = Base64.encode(userMap.get("password"), "utf-8");
			JSONObject JSONObject = LoginAction.login(email, password);
			String actualEmail = JSONObject.getJSONObject("result")
					.optJSONObject("user").optString("email");
			String token = JSONObject.getJSONObject("result")
					.optJSONObject("user").optString("token");
			String errorcode = JSONObject.getJSONObject("result").optString(
					"errorcode");
			if (email.equals(actualEmail) && !"".equals(token)
					&& "ok".equals(errorcode)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.error("÷¥––LoginActionTest.testLogin¥ÌŒÛ£∫", e);
		}
		afterTest("testLogin", flag);
		Assert.assertEquals(flag, true, className + ".testLogin failed!");
	}

	@Test(dependsOnMethods = { "testLogin" }, enabled = true, alwaysRun = true, description = "µ«¬º√‹¬Î¥ÌŒÛ≤‚ ‘")
	public void testLoginWithPwdError() {
		boolean flag = false;

		try {
			beforeTest("testLoginWithPwdError");
			Map<String, String> userMap = ExcelUtil.importDataTable(
					"testdata.xls", "LoginActionTest", "testLoginWithPwdError");
			String email = userMap.get("email");
			String password = Base64.encode(userMap.get("password"), "utf-8");
			JSONObject JSONObject = LoginAction.login(email, password);
			String errorcode = JSONObject.getJSONObject("result").optString(
					"errorcode");
			if ("2201".equals(errorcode)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.error("÷¥––LoginActionTest.testLoginWithPwdError¥ÌŒÛ£∫", e);
		}
		afterTest("testLoginWithPwdError", flag);
		Assert.assertEquals(flag, true, className
				+ ".testLoginWithPwdError failed!");
	}

	@AfterClass(alwaysRun = true)
	public void afterClassTest() {
		try {
			afterClass();
		} catch (Exception e) {
			logger.error("÷¥––LoginActionTest.afterClassTest¥ÌŒÛ£∫", e);
		}

	}
}
