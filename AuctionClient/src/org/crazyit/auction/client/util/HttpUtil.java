/**
 * 
 */
package org.crazyit.auction.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * Description: <br/>
 * ��վ: <a href="http://www.crazyit.org">���ava����</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class HttpUtil {
	// ����HttpClient����
	public static HttpClient httpClient = new DefaultHttpClient();
	public static final String BASE_URL = "http://192.168.10.118:8080/auction/android/";
	public static final String TAG = "HttpUtil";

	/**
	 * 
	 * @param url
	 *            ���������URL
	 * @return ��������Ӧ�ַ���
	 * @throws Exception
	 */
	public static String getRequest(String url) throws Exception {
		Log.d(TAG, "execute getRequest method, request url:" + url);
		// ����HttpGet����
		HttpGet get = new HttpGet(url);
		// ����GET����
		HttpResponse httpResponse = httpClient.execute(get);
		// ����������ɹ��ط�����Ӧ
		if (httpResponse.getStatusLine().getStatusCode() == 200) {
			// ��ȡ��������Ӧ�ַ���
			String result = new String(EntityUtils.toString(
					httpResponse.getEntity()).getBytes("gbk"), "gbk");
			Log.d(TAG, "execute getRequest method, response:" + result);
			return result;
		}
		return null;
	}

	/**
	 * 
	 * @param url
	 *            ���������URL
	 * @param params
	 *            �������
	 * @return ��������Ӧ�ַ���
	 * @throws Exception
	 */
	public static String postRequest(String url, Map<String, String> rawParams)
			throws Exception {
		Log.d(TAG, "execute postRequest method, request url:" + url
				+ ";request params:" + rawParams);
		// ����HttpPost����
		HttpPost post = new HttpPost(url);
		// ������ݲ��������Ƚ϶�Ļ����ԶԴ��ݵĲ������з�װ
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (String key : rawParams.keySet()) {
			// ��װ�������
			params.add(new BasicNameValuePair(key, rawParams.get(key)));
		}
		// �����������
		post.setEntity(new UrlEncodedFormEntity(params, "gbk"));
		// ����POST����
		HttpResponse httpResponse = httpClient.execute(post);
		// ����������ɹ��ط�����Ӧ
		if (httpResponse.getStatusLine().getStatusCode() == 200) {
			// ��ȡ��������Ӧ�ַ���
			String result = new String(EntityUtils.toString(
					httpResponse.getEntity()).getBytes("gbk"), "gbk");
			Log.d(TAG, "execute postRequest method, response:" + result);
			return result;
		}
		return null;
	}
}
