package com.fangdd.utils.http.base;

import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A bean class that represents the response from an HTTP request to a service
 * call
 * 
 * @since 0.4.0
 */
public class DWHttpResponse {
	private String statusLine = null;
	private int statusCode = 0;
	private String body;
	private HashMap<String, String> headers = new HashMap<String, String>();
	private Logger logger = Logger.getLogger(DWHttpResponse.class);

	public JSONObject getBodyAsJson() {
		try {
			return new JSONObject(body);
		} catch (JSONException e) {
			logger.error("getBodyAsJson error:", e);
		}
		return null;
	}

	public String getBody() {
		return body;
	}

	void setBody(String body) {
		this.body = body;
	}

	public int getStatusCode() {
		return statusCode;
	}

	void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusLine() {
		return statusLine;
	}

	void setStatusLine(String statusLine) {
		this.statusLine = statusLine;
	}

	void addHeader(String name, String value) {
		headers.put(name, value);
	}

	public String getHeader(String name) {
		return headers.get(name);
	}

	public Set<String> getHeaderNames() {
		return headers.keySet();
	}

	/**
	 * Print the response to STD out. Method for testing purposes.
	 */
	public void printResponse() {
		logger.debug("----------------------------------------------");
		logger.debug("Http Response statusCode: " + statusCode);
		logger.debug("Http Response statusLine: " + statusLine);
		logger.debug("Http Response Headers:");
		for (String name : getHeaderNames()) {
			logger.debug(name + ": " + getHeader(name));
		}
		logger.debug("Http Response Body:");
		logger.debug(getBody());
		logger.debug("----------------------------------------------");
	}

}
