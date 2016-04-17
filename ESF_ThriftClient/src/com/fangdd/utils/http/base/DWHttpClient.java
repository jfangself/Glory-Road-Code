package com.fangdd.utils.http.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.fangdd.utils.PropUtil;

/**
 * Utility that makes HTTP requests to the web service interfaces Other classes
 * will extend this utility to implement specific HTTP requests to unit test
 * each service method
 * 
 * @since 0.4.0
 */
@SuppressWarnings("deprecation")
public class DWHttpClient {

	private static DefaultHttpClient client;
	private static PropUtil PropUtil = new PropUtil("config/server.properties");
	private static final int TIMEOUT = Integer
			.parseInt(PropUtil.get("timeout")) * 1000;

	private static Logger logger = Logger.getLogger(DWHttpClient.class);

	static {
		PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
		cm.setMaxTotal(10);
		client = new DefaultHttpClient(cm);

		HttpParams httpParams = client.getParams();
		httpParams.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
		httpParams.setParameter("http.protocol.expect-continue", Boolean.FALSE);
		HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT);
		HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				if (null != DWHttpClient.client)
					DWHttpClient.client.getConnectionManager().shutdown();
			}
		});
	}

	/**
	 * Sends a HTTP GET request with the provided uri
	 * 
	 * @param url
	 *            the url to send the request to
	 * @return DWHttpResponse
	 */
	public static String sendGetRequest(UrlWrapper urlWrapper) throws Exception {

		List pairs = getNameValuePairs(urlWrapper.getParameters());
		StringBuilder urlBulider = new StringBuilder(
				urlWrapper.getUrlRootAndPath());

		if ((null != pairs) && (pairs.size() > 0)) {
			urlBulider.append("?").append(
					URLEncodedUtils.format(pairs, WebConstant.DEFAULT_CHARSET));
		}
		HttpGet method = new HttpGet(urlBulider.toString());
		method.addHeader(new BasicHeader("Accept", WebConstant.WEB_ACCEPT_JSON));
		method.addHeader(new BasicHeader("ContentType",
				WebConstant.WEB_CONTENT_TYPE_JSON));

		logger.debug("----------------------------------------------");
		logger.debug("Http Request Url : " + urlBulider.toString());
		logger.debug("Http Request Method : " + method.getMethod());
		logger.debug("Http Request Headers : ");
		Header[] headers = method.getAllHeaders();
		for (Header h : headers) {
			logger.debug(h.getName() + ":" + h.getValue());
		}
		logger.debug("Http Request body : ");
		logger.debug(urlWrapper.getParameters());
		logger.debug("----------------------------------------------");

		DWHttpResponse response = sendRequest(method);
		if (null != method) {
			method.abort();
		}
		return response.getBody();
	}

	/**
	 * Sends a HTTP POST request to the specified url
	 * 
	 * @param url
	 *            the url to send the request
	 * @param requestData
	 *            the data to send
	 * @return DWHttpResponse
	 */
	public static String sendPostRequest(UrlWrapper urlWrapper)
			throws Exception {
		StringBuilder urlBulider = new StringBuilder(
				urlWrapper.getUrlRootAndPath());
		HttpPost method = new HttpPost(urlBulider.toString());
		method.addHeader(new BasicHeader("Accept", WebConstant.WEB_ACCEPT_JSON));
		method.addHeader(new BasicHeader("ContentType",
				WebConstant.WEB_CONTENT_TYPE_JSON));
		logger.debug("----------------------------------------------");
		logger.debug("Http Request Url : " + urlBulider.toString());
		logger.debug("Http Request Method : " + method.getMethod());
		logger.debug("Http Request Headers : ");
		Header[] headers = method.getAllHeaders();
		for (Header h : headers) {
			logger.debug(h.getName() + ":" + h.getValue());
		}
		logger.debug("Http Request body : ");
		logger.debug(urlWrapper.getParameters());
		logger.debug("----------------------------------------------");

		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
				getNameValuePairs(urlWrapper.getParameters()),
				WebConstant.DEFAULT_CHARSET);

		DWHttpResponse response;
		method.setEntity(formEntity);
		response = sendRequest(method);
		if (null != method) {
			method.abort();
		}
		return response.getBody();
	}

	/**
	 * This method sends an HTTP request based on the specified method
	 * 
	 * @param method
	 * @return DWHttpResponse
	 * @throws Exception
	 */
	private static DWHttpResponse sendRequest(HttpRequestBase method)
			throws Exception {

		DWHttpResponse res = new DWHttpResponse();
		HttpEntity entity = null;

		HttpResponse HttpResponse = client.execute(method);
		res.setStatusCode(HttpResponse.getStatusLine().getStatusCode());
		res.setStatusLine(HttpResponse.getStatusLine().toString());

		entity = HttpResponse.getEntity();
		res.setBody(new String(EntityUtils.toByteArray(entity),
				WebConstant.DEFAULT_CHARSET));

		Header[] headers = HttpResponse.getAllHeaders();
		for (Header h : headers) {
			res.addHeader(h.getName(), h.getValue());
		}
		res.printResponse();

		return res;
	}

	@SuppressWarnings("unchecked")
	private static List<NameValuePair> getNameValuePairs(
			Map<String, Object> parameters) {
		List pairs = new ArrayList();
		for (Map.Entry map : parameters.entrySet()) {
			pairs.add(new BasicNameValuePair((String) map.getKey(), map
					.getValue().toString()));
		}
		return pairs;
	}
}
