package com.fangdd.utils.http.base;

import com.fangdd.utils.PropUtil;

public class WebConstant {
	private static PropUtil PropUtil = new PropUtil("config/server.properties");
	public final static String DEFAULT_CHARSET = PropUtil.get("charset");
	public final static String WEB_ACCEPT_XML = "application/xml";
	public final static String WEB_ACCEPT_JSON = "application/json";
	public final static String WEB_CONTENT_TYPE_XML = "application/xml; charset="
			+ DEFAULT_CHARSET;
	public final static String WEB_CONTENT_TYPE_JSON = "application/json; charset="
			+ DEFAULT_CHARSET;
}
