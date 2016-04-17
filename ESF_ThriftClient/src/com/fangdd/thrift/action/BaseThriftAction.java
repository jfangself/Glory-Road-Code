package com.fangdd.thrift.action;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TMemoryBuffer;

import com.fangdd.utils.JsonFormatUtil;
import com.fangdd.utils.PropUtil;
import com.fangdd.utils.StringUtil;
import com.fangdd.utils.http.ThriftRequestBean;
import com.google.gson.Gson;

public class BaseThriftAction {
	private PropUtil PropUtil = new PropUtil("config/server.properties");
	private String charset = PropUtil.get("charset");
	protected ThriftRequestBean ThriftRequestBean;
	private String token;
	protected String req;
	protected String resp;
	protected Gson Gson = new Gson();
	protected TMemoryBuffer TMemoryBuffer;
	protected TJSONProtocol TJSONProtocol;
	protected Logger logger = Logger.getLogger(BaseThriftAction.class);

	public String getRequestData(Object request) throws Exception {
		String req = Gson.toJson(request);
		logger.debug("request data is : " + JsonFormatUtil.formatJson(req));
		TMemoryBuffer = new TMemoryBuffer(req.length());
		TJSONProtocol = new TJSONProtocol(TMemoryBuffer);
		Object thrift = request;
		Method method = thrift.getClass().getMethod("write",
				new Class[] { TProtocol.class });
		method.invoke(thrift, new Object[] { TJSONProtocol });
		byte[] bytes = Arrays.copyOf(TMemoryBuffer.getArray(),
				TMemoryBuffer.length());
		return new String(bytes, charset);
	}

	public Object getResponseData(String result, Class<?> response)
			throws Exception {
		Object thrift = null;
		if (result.indexOf("code") > 0) {
			thrift = Gson.fromJson(result, response);
		} else {
			TMemoryBuffer = new TMemoryBuffer(result.length());
			TJSONProtocol = new TJSONProtocol(TMemoryBuffer);
			TMemoryBuffer.write(result.getBytes(charset));
			thrift = response.newInstance();
			Method method = thrift.getClass().getMethod("read",
					new Class[] { TProtocol.class });
			method.invoke(thrift, new Object[] { TJSONProtocol });
		}
		logger.debug("response data is : "
				+ JsonFormatUtil.formatJson(Gson.toJson(thrift)));
		return thrift;
	}

	public Object invokerGet(String serviceName, String businessName,
			String methodName, Object request, Class<?> response)
			throws Exception {
		ThriftRequestBean = new ThriftRequestBean();
		req = this.getRequestData(request);
		if (!StringUtil.validateNull(token)) {
			ThriftRequestBean.setHeader("token", token);
		}
		resp = ThriftRequestBean.invokerGet(serviceName, businessName,
				methodName, req);
		return this.getResponseData(resp, response);
	}

	public Object invokerPost(String serviceName, String businessName,
			String methodName, Object request, Class<?> response)
			throws Exception {
		ThriftRequestBean = new ThriftRequestBean();
		req = this.getRequestData(request);
		if (!StringUtil.validateNull(token)) {
			ThriftRequestBean.setHeader("token", token);
		}
		resp = ThriftRequestBean.invokerPost(serviceName, businessName,
				methodName, req);
		return this.getResponseData(resp, response);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}