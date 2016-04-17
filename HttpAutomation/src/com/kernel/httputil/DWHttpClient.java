package com.kernel.httputil;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * Utility that makes HTTP requests to the web service interfaces Other classes
 * will extend this utility to implement specific HTTP requests to unit test
 * each service method
 * 
 * @since 0.4.0
 */
public class DWHttpClient {

	private DefaultHttpClient client = new DefaultHttpClient();
	private Logger logger = Logger.getLogger(DWHttpClient.class);

	/**
	 * Sends a HTTP GET request with the provided uri
	 * 
	 * @param url
	 *            the url to send the request to
	 * @return DWHttpResponse
	 */
	public DWHttpResponse sendGetRequest(String url) {
		HttpGet method = new HttpGet(url);
		method.addHeader(new BasicHeader("Accept", WebConstant.WEB_ACCEPT_JSON));
		method.addHeader(new BasicHeader("ContentType",
				WebConstant.WEB_CONTENT_TYPE_JSON));
		logger.debug("----------------------------------------------");
		logger.debug("Http Request Url : " + url);
		logger.debug("Http Request Method : " + method.getMethod());
		logger.debug("Http Request Headers : ");
		Header[] headers = method.getAllHeaders();
		for (Header h : headers) {
			logger.debug(h.getName() + ":" + h.getValue());
		}
		logger.debug("----------------------------------------------");

		DWHttpResponse response = sendRequest(method);
		return response;
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
	public DWHttpResponse sendPostRequest(String url, String body) {
		HttpPost method = new HttpPost(url);
		method.addHeader(new BasicHeader("Accept", WebConstant.WEB_ACCEPT_JSON));
		method.addHeader(new BasicHeader("ContentType",
				WebConstant.WEB_CONTENT_TYPE_JSON));
		logger.debug("----------------------------------------------");
		logger.debug("Http Request Url : " + url);
		logger.debug("Http Request Method : " + method.getMethod());
		logger.debug("Http Request Headers : ");
		Header[] headers = method.getAllHeaders();
		for (Header h : headers) {
			logger.debug(h.getName() + ":" + h.getValue());
		}
		logger.debug("Http Request body : ");
		logger.debug(body);
		logger.debug("----------------------------------------------");

		DWHttpResponse response = null;

		try {
			StringEntity se = new StringEntity(body);
			se.setContentEncoding(WebConstant.CHARSET_UTF8);
			se.setContentType(WebConstant.WEB_ACCEPT_JSON);
			method.setEntity(se);
			response = sendRequest(method);
		} catch (Exception e) {
			logger.error("sendPostRequest error : ", e);
		}

		return response;
	}

	/**
	 * This method sends an HTTP request based on the specified method
	 * 
	 * @param method
	 * @return DWHttpResponse
	 */
	private DWHttpResponse sendRequest(HttpRequestBase method) {

		DWHttpResponse res = new DWHttpResponse();
		HttpEntity entity = null;

		try {
			HttpResponse HttpResponse = client.execute(method);
			res.setStatusCode(HttpResponse.getStatusLine().getStatusCode());
			res.setStatusLine(HttpResponse.getStatusLine().toString());

			entity = HttpResponse.getEntity();
			String charset = EntityUtils.getContentCharSet(entity);
			res.setBody(EntityUtils.toString(entity, charset));

			Header[] headers = HttpResponse.getAllHeaders();
			for (Header h : headers) {
				res.addHeader(h.getName(), h.getValue());
			}

		} catch (Exception e) {
			logger.error("sendRequest error : ", e);
		}

		return res;

	}
}
