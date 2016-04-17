package com.fangdd.utils.http.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public final class UrlWrapper {
	private static Logger log = Logger.getLogger(UrlWrapper.class);
	private URL url;
	private Map<String, Object> headers = new HashMap();
	private Map<String, Object> parameters = new HashMap();

	public UrlWrapper(String strUrl) {
		if (StringUtils.isNotBlank(strUrl)) {
			try {
				this.url = new URL(strUrl);
			} catch (MalformedURLException e) {
				log.error(new StringBuilder().append("url ").append(strUrl)
						.append(" error.").toString(), e);
			}
		}
		this.parameters = getUrlParameters();
	}

	public Map<String, Object> getParameters() {
		return this.parameters;
	}

	public void addParameter(String key, Object value) {
		this.parameters.put(key, value);
	}

	public void addAllParameter(Map<String, Object> params) {
		this.parameters.putAll(params);
	}

	public void addAllHeaders(Map<String, Object> params) {
		this.headers.putAll(params);
	}

	public Map<String, Object> getHeaders() {
		return this.headers;
	}

	public void removeParameter(String key) {
		this.parameters.remove(key);
	}

	public String getUrlRootAndPath() {
		return new StringBuilder().append(getUrlRoot()).append(getPath())
				.toString();
	}

	public String getUrlRoot() {
		StringBuilder root = new StringBuilder();
		root.append(getProtocol()).append("://");
		root.append(getHost());
		if ((getPort() != -1) && (getPort() != 80)) {
			root.append(":").append(getPort());
		}
		return root.toString();
	}

	public String getFile() {
		return this.url.getFile();
	}

	public String getProtocol() {
		return this.url.getProtocol();
	}

	public String getHost() {
		return this.url.getHost();
	}

	public String getQuery() {
		return this.url.getQuery();
	}

	public int getPort() {
		return this.url.getPort() > 0 ? this.url.getPort() : 80;
	}

	public String getPath() {
		return this.url.getPath();
	}

	private Map<String, Object> getUrlParameters() {
		Map result = new HashMap();
		if (StringUtils.isNotEmpty(getQuery())) {
			String[] queries = getQuery().split("&");

			int len = 2;
			for (String query : queries)
				if (StringUtils.isNotEmpty(query)) {
					String[] tempStrs = query.split("=");
					if (tempStrs.length == 2) {
						result.put(tempStrs[0], tempStrs[1]);
					}
				}
		}
		return result;
	}

	public int hashCode() {
		int hashCode = 0;
		hashCode += this.url.hashCode();
		return hashCode;
	}

	public boolean equals(Object obj) {
		return ((obj instanceof UrlWrapper)) && (obj.hashCode() == hashCode());
	}

	public String toString() {
		return new StringBuilder().append("URLWrap{url=").append(this.url)
				.append('}').toString();
	}
}