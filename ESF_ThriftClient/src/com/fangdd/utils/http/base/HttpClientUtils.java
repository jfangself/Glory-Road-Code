package com.fangdd.utils.http.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
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

@SuppressWarnings("deprecation")
public final class HttpClientUtils {
	private static PropUtil PropUtil = new PropUtil("config/server.properties");
	private static final String DEFAULT_CHARSET = PropUtil.get("charset");
	private static final int TIMEOUT = Integer
			.parseInt(PropUtil.get("timeout")) * 1000;
	private static Logger log = Logger.getLogger(HttpClientUtils.class);
	private static HttpClient httpClient = null;

	public static String fetchStringByPost(UrlWrapper urlWrapper,
			UserAgent userAgent) throws IOException {
		return fetchStringByHttp(urlWrapper, DEFAULT_CHARSET, userAgent, "POST");
	}

	public static String fetchStringByGet(UrlWrapper urlWrapper,
			UserAgent userAgent) throws IOException {
		return fetchStringByHttp(urlWrapper, DEFAULT_CHARSET, userAgent, "GET");
	}

	@SuppressWarnings("unchecked")
	public static String fetchStringByHttp(UrlWrapper urlWrapper,
			String charset, UserAgent userAgent, String requestMethod)
			throws IOException {
		HttpUriRequest httpUriRequest = null;
		try {
			if (requestMethod.equalsIgnoreCase("POST"))
				httpUriRequest = fetchHttpUriRequestByPost(urlWrapper, charset,
						userAgent);
			else {
				httpUriRequest = fetchHttpUriRequestByGet(urlWrapper, charset,
						userAgent);
			}
			String result = null;
			if (null != httpUriRequest) {
				result = (String) httpClient.execute(httpUriRequest,
						new ResponseHandler() {
							public String handleResponse(HttpResponse response)
									throws IOException {
								String result = null;
								HttpEntity entity = response.getEntity();
								if (null != entity) {
									result = new String(EntityUtils
											.toByteArray(entity),
											DEFAULT_CHARSET);
								}
								return result;
							}
						});
			}
			return result;
		} finally {
			if (null != httpUriRequest)
				httpUriRequest.abort();
		}
	}

	public static byte[] fetchByteArrayByPost(UrlWrapper urlWrapper,
			UserAgent userAgent) throws IOException {
		return fetchByteArrayByHttp(urlWrapper, DEFAULT_CHARSET, userAgent,
				"POST");
	}

	public static byte[] fetchByteArrayByGet(UrlWrapper urlWrapper,
			UserAgent userAgent) throws IOException {
		return fetchByteArrayByHttp(urlWrapper, DEFAULT_CHARSET, userAgent,
				"GET");
	}

	@SuppressWarnings("unchecked")
	public static byte[] fetchByteArrayByHttp(UrlWrapper urlWrapper,
			String charset, UserAgent userAgent, String requestMethod)
			throws IOException {
		HttpUriRequest httpRequest = null;
		try {
			if (requestMethod.equalsIgnoreCase("POST"))
				httpRequest = fetchHttpUriRequestByPost(urlWrapper, charset,
						userAgent);
			else {
				httpRequest = fetchHttpUriRequestByGet(urlWrapper, charset,
						userAgent);
			}
			byte[] result = null;
			if (null != httpRequest) {
				result = (byte[]) httpClient.execute(httpRequest,
						new ResponseHandler() {
							public byte[] handleResponse(HttpResponse response)
									throws IOException {
								HttpEntity entity = response.getEntity();
								byte[] result = null;
								if (null != entity) {
									result = EntityUtils.toByteArray(entity);
								}
								return result;
							}
						});
			}
			return result;
		} finally {
			if (null != httpRequest)
				httpRequest.abort();
		}
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

	private static HttpUriRequest fetchHttpUriRequestByPost(
			UrlWrapper urlWrapper, String charset, UserAgent userAgent) {
		if (null == urlWrapper) {
			return null;
		}

		HttpPost httpPost = new HttpPost(urlWrapper.getUrlRootAndPath());
		try {
			UrlEncodedFormEntity formEntity;
			if (StringUtils.isBlank(charset)) {
				charset = DEFAULT_CHARSET;
				formEntity = new UrlEncodedFormEntity(
						getNameValuePairs(urlWrapper.getParameters()), charset);
			} else {
				formEntity = new UrlEncodedFormEntity(
						getNameValuePairs(urlWrapper.getParameters()), charset);
			}
			HttpParams params = httpPost.getParams();
			params.setParameter("http.useragent", userAgent.getCode());
			params.setParameter("http.protocol.content-charset", charset);
			
			if (!urlWrapper.getHeaders().isEmpty()) {
				for (Map.Entry map : urlWrapper.getHeaders().entrySet()) {
					httpPost.addHeader(new BasicHeader(map.getKey().toString(),
							map.getValue().toString()));
				}
			}
			
			httpPost.setParams(params);
			httpPost.setEntity(formEntity);
			log.debug("HttpClientUtils Post URL is : "
					+ urlWrapper.getUrlRootAndPath());
			log.debug("HttpClientUtils Post Headers is : ");
			Header[] headers = httpPost.getAllHeaders();
			for (Header h : headers) {
				log.debug(h.getName() + ":" + h.getValue());
			}
			log.debug("HttpClientUtils Post Params is : "
					+ urlWrapper.getParameters());

			return httpPost;
		} catch (Exception e) {
			log.error(new StringBuilder().append("fetch HttpRequestBase ")
					.append(urlWrapper).append(" error").toString(), e);
		}
		return null;
	}

	private static HttpUriRequest fetchHttpUriRequestByGet(
			UrlWrapper urlWrapper, String charset, UserAgent userAgent) {
		if (null == urlWrapper) {
			return null;
		}
		HttpGet httpGet = null;
		try {
			List pairs = getNameValuePairs(urlWrapper.getParameters());
			StringBuilder url = new StringBuilder(
					urlWrapper.getUrlRootAndPath());
			;
			if (StringUtils.isBlank(charset)) {
				charset = DEFAULT_CHARSET;
			}
			if ((null != pairs) && (pairs.size() > 0)) {
				url.append("?").append(URLEncodedUtils.format(pairs, charset));
			}
			httpGet = new HttpGet(url.toString());
			HttpParams params = httpGet.getParams();
			params.setParameter("http.useragent", userAgent.getCode());
			params.setParameter("http.protocol.content-charset", charset);
			
			if (!urlWrapper.getHeaders().isEmpty()) {
				for (Map.Entry map : urlWrapper.getHeaders().entrySet()) {
					httpGet.addHeader(new BasicHeader(map.getKey().toString(),
							map.getValue().toString()));
				}
			}			
			
			httpGet.setParams(params);
			log.debug("HttpClientUtils Get URL is : " + url.toString());
			log.debug("HttpClientUtils Get Headers is : ");
			Header[] headers = httpGet.getAllHeaders();
			for (Header h : headers) {
				log.debug(h.getName() + ":" + h.getValue());
			}
			log.debug("HttpClientUtils Get Params is : "
					+ urlWrapper.getParameters());
			return httpGet;
		} catch (Exception e) {
			log.error(new StringBuilder().append("fetch HttpRequestBase ")
					.append(urlWrapper).append(" error").toString(), e);
		}
		return null;
	}

	static {
		PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
		cm.setMaxTotal(10);
		httpClient = new DefaultHttpClient(cm);

		HttpParams httpParams = httpClient.getParams();
		httpParams.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
		httpParams.setParameter("http.protocol.expect-continue", Boolean.FALSE);
		HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT);
		HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				if (null != HttpClientUtils.httpClient)
					HttpClientUtils.httpClient.getConnectionManager()
							.shutdown();
			}
		});
	}
}