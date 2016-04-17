package com.kernel.action;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.kernel.httputil.DWHttpClient;
import com.kernel.httputil.DWHttpResponse;
import com.kernel.util.FileUtil;
import com.kernel.util.PropUtil;
import com.kernel.util.Utils;

public class LoginAction {
	private DWHttpClient request = new DWHttpClient();
	private DWHttpResponse response;
	private String url;
	private String template;
	private static PropUtil PropUtil = new PropUtil(
			"config/httptest.properties");
	private static Logger logger = Logger.getLogger(LoginAction.class);

	public LoginAction() {
		String secret = PropUtil.get("secret");
		StringBuffer sb = new StringBuffer();
		String baseUrl = PropUtil.get("baseUrl") + "/mktvportal/mktv/login";
		String queryString1 = "timestamp=" + System.currentTimeMillis();
		String queryString2 = "&signature="
				+ Utils.md5((queryString1 + secret).getBytes());
		url = sb.append(baseUrl).append("?").append(queryString1)
				.append(queryString2).toString();
		FileUtil file = new FileUtil();
		logger.debug("url is :" + url);
		template = file.getContent("login.template");
		logger.debug("template is :");
		logger.debug(template);

	}

	public JSONObject login(String email, String password) {
		String body = String.format(template, new Object[] { email, password });
		response = request.sendPostRequest(url, body);
		response.printResponse();
		if (response.getStatusCode() == 200) {
			return response.getBodyAsJson();
		}
		return null;

	}

	public static void main(String[] args) {
		JSONObject JSONObject = new LoginAction().login("kernel001@test.com",
				"111111");
		if (JSONObject != null) {
			logger.debug(JSONObject.optJSONObject("result").optInt("users"));
		}
	}
}
