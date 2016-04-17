package com.fangdd.utils.http;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import com.fangdd.utils.GlobalData;
import com.fangdd.utils.PropUtil;
import com.fangdd.utils.http.base.HttpClientUtils;
import com.fangdd.utils.http.base.UrlWrapper;
import com.fangdd.utils.http.base.UserAgent;

public class ThriftRequestBean implements Serializable {
	private static final Logger logger = Logger
			.getLogger(ThriftRequestBean.class);
	private PropUtil PropUtil = new PropUtil("config/server.properties");
	private String version = PropUtil.get("version");
	/**
	 * platform - 请求来源平台(1: APP, 2: 400系统, 3: 内部服务, 4: CRM, 5: 苹果APP, 6: 安卓APP)
	 */
	private final int platform = Integer.parseInt(PropUtil.get("platform"));
	/**
	 * platformVersion - 请求来源平台版本号(如platformVersion=100013)
	 */
	private final int platformVersion = Integer.parseInt(PropUtil
			.get("platformVersion"));
	private String url;
	private Map<String, Object> headers = new HashMap<String, Object>();

	private Map<String, Object> params = new HashMap<String, Object>();

	public ThriftRequestBean() {
	}

	public ThriftRequestBean(String url, Map<String, Object> params) {
		this.url = url;
		this.params = params;
	}

	public ThriftRequestBean(String url, Map<String, Object> headers,
			Map<String, Object> params) {
		this.url = url;
		this.headers = headers;
		this.params = params;
	}

	public String getApiUrl(String serviceName, String businessName,
			String methodName) {
		String host = "";
		String apiUrl = "";
		host = PropUtil.get("thrift.service.host") + ":"
				+ PropUtil.get("thrift.service.port");

		apiUrl = new StringBuilder().append("http://").append(host).append("/")
				.append(version).append("/").append(serviceName).append("/")
				.append(businessName).append("/").append(methodName).toString();
		logger.debug("clien request url is : " + apiUrl);
		return apiUrl;
	}

	public void setHeader(String headerName, Object headerValue) {
		this.headers.put(headerName, headerValue);
	}

	public void getHeader(String headerName) {
		this.headers.get(headerName);
	}

	public void setHeaders(Map<String, Object> headers) {
		this.headers = headers;
	}

	public Map<String, Object> getHeaders() {
		headers.put("platform", platform);
		headers.put("platformVersion", platformVersion);
		return headers;
	}

	public String invokerGet(String serviceName, String businessName,
			String methodName, Object param) {
		String url = this.getApiUrl(serviceName, businessName, methodName);
		headers = getHeaders();
		params.put("data", param);
		return doGet(new ThriftRequestBean(url, headers, params));
	}

	public String invokerPost(String serviceName, String businessName,
			String methodName, Object param) {
		String url = this.getApiUrl(serviceName, businessName, methodName);
		headers = getHeaders();
		params.put("data", param);
		return doPost(new ThriftRequestBean(url, headers, params));
	}

	public String doGet(ThriftRequestBean request) {
		logger.debug("###GET URL### :" + request.getUrl());
		logger.debug("###GET HEADERS### :" + request.getHeaders());
		logger.debug("###GET PARAMS### :" + request.getParams());
		UrlWrapper urlWrapper = new UrlWrapper(request.getUrl());
		urlWrapper.addAllHeaders(request.getHeaders());
		urlWrapper.addAllParameter(request.getParams());
		String json;
		try {
			json = HttpClientUtils.fetchStringByGet(urlWrapper,
					UserAgent.FANGDD_SDK_JAVA);
		} catch (Exception e) {
			json = "{\"code\": " + GlobalData.Code + ",\"msg\": \""
					+ e.getMessage() + "\"}";
			logger.error("ThriftRequestBean doGet() error:", e);
		}
		logger.debug("###GET Response JSON###:" + json);
		return json;
	}

	public String doPost(ThriftRequestBean request) {
		logger.debug("###POST URL### :" + request.getUrl());
		logger.debug("###POST HEADERS### :" + request.getHeaders());
		logger.debug("###POST PARAMS### :" + request.getParams());
		UrlWrapper urlWrapper = new UrlWrapper(request.getUrl());
		urlWrapper.addAllHeaders(request.getHeaders());
		urlWrapper.addAllParameter(request.getParams());
		String json;
		try {
			json = HttpClientUtils.fetchStringByPost(urlWrapper,
					UserAgent.FANGDD_SDK_JAVA);
		} catch (Exception e) {
			json = "{\"code\": " + GlobalData.Code + ",\"msg\": \""
					+ e.getMessage() + "\"}";
			logger.error("ThriftRequestBean doPost() error:", e);
		}
		logger.debug("###POST Response JSON###:" + json);
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