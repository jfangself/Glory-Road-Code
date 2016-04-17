package com.fangdd.utils.http;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.fangdd.utils.JsonFormatUtil;
import com.fangdd.utils.http.base.HttpClientUtils;
import com.fangdd.utils.http.base.UrlWrapper;
import com.fangdd.utils.http.base.UserAgent;

public class PhpRequestBean implements Serializable {
	private static final Logger logger = Logger.getLogger(PhpRequestBean.class);
	private String url;
	private Map<String, Object> params;

	public PhpRequestBean(String url, Map<String, Object> params) {
		this.url = url;
		this.params = params;
	}

	public static String doGet(PhpRequestBean request) throws Exception {
		logger.debug("###GET URL### :" + request.getUrl());
		logger.debug("###GET PARAMS### :" + request.getParams());
		UrlWrapper urlWrapper = new UrlWrapper(request.getUrl());
		urlWrapper.addAllParameter(request.getParams());
		String json;
		try {
			json = HttpClientUtils.fetchStringByGet(urlWrapper,
					UserAgent.FANGDD_SDK_JAVA);
			logger.debug("###GET Response JSON###:"
					+ JsonFormatUtil.formatJson(new JSONObject(json).toString()));
		} catch (Exception e) {
			json = "{\"error\":true}";
			logger.debug("###GET Response JSON###:" + json);
			logger.error("PhpRequestBean doGet() error:", e);
		}

		return json;
	}

	public static String doPost(PhpRequestBean request) throws Exception {
		logger.debug("###POST URL### :" + request.getUrl());
		logger.debug("###POST PARAMS### :" + request.getParams());
		UrlWrapper urlWrapper = new UrlWrapper(request.getUrl());
		urlWrapper.addAllParameter(request.getParams());
		String json;
		try {
			json = HttpClientUtils.fetchStringByPost(urlWrapper,
					UserAgent.FANGDD_SDK_JAVA);
			logger.debug("###GET Response JSON###:"
					+ JsonFormatUtil.formatJson(new JSONObject(json).toString()));
		} catch (Exception e) {
			json = "{\"error\":true}";
			logger.debug("###POST Response JSON###:" + json);
			logger.error("PhpRequestBean doPost() error:", e);
		}

		return json;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Object> getParams() {
		return this.params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public String toString() {
		return new ToStringBuilder(this).append("params", this.params)
				.toString();
	}
}