package com.fangdd.utils.http;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import com.fangdd.utils.GlobalData;
import com.fangdd.utils.JsonFormatUtil;
import com.fangdd.utils.http.base.DWHttpClient;
import com.fangdd.utils.http.base.UrlWrapper;

public class AgentServiceRequestBean implements Serializable {
	private static final Logger logger = Logger
			.getLogger(AgentServiceRequestBean.class);
	private String url;
	private Map<String, Object> params;

	public AgentServiceRequestBean(String url, Map<String, Object> params) {
		this.url = url;
		this.params = params;
	}

	public String doGet(AgentServiceRequestBean request) {
		logger.debug("###GET URL### :" + request.getUrl());
		logger.debug("###GET PARAMS### :" + request.getParams());
		UrlWrapper urlWrapper = new UrlWrapper(request.getUrl());
		urlWrapper.addAllParameter(request.getParams());
		String json;
		try {
			json = DWHttpClient.sendGetRequest(urlWrapper);
		} catch (Exception e) {
			json = "{\"code\": " + GlobalData.Code + ",\"msg\": \""
					+ e.getMessage() + "\"}";
			logger.error("AgentServiceRequestBean doGet() error:", e);
		}
		logger.debug("###GET Response JSON###:"
				+ JsonFormatUtil.formatJson(json));
		return json;
	}

	public String doPost(AgentServiceRequestBean request) {
		logger.debug("###POST URL### :" + request.getUrl());
		logger.debug("###POST PARAMS### :" + request.getParams());
		UrlWrapper urlWrapper = new UrlWrapper(request.getUrl());
		urlWrapper.addAllParameter(request.getParams());
		String json;
		try {
			json = DWHttpClient.sendPostRequest(urlWrapper);
		} catch (Exception e) {
			json = "{\"code\": " + GlobalData.Code + ",\"msg\": \""
					+ e.getMessage() + "\"}";
			logger.error("AgentServiceRequestBean doPost() error:", e);
		}
		logger.debug("###POST Response JSON###:"
				+ JsonFormatUtil.formatJson(json));
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