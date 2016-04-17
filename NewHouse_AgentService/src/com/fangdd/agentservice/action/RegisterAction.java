package com.fangdd.agentservice.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.fangdd.utils.PropUtil;
import com.fangdd.utils.http.AgentServiceRequestBean;

public class RegisterAction {
	protected Logger logger = Logger.getLogger(RegisterAction.class);
	private PropUtil PropUtil = new PropUtil("config/server.properties");
	private String agent_service_addr = PropUtil.get("agent_service_addr");
	private AgentServiceRequestBean request;
	private String url;
	private Map<String, Object> params;

	/**
	 * 经纪服务门店申请资金账号开户
	 * 
	 * @param shopId
	 *            门店码
	 * @return JSONObject
	 */
	public JSONObject enterprise_register(int shopId) {
		JSONObject jsonObject = null;
		url = agent_service_addr + "/external/enterprise_register.json";
		params = new HashMap<String, Object>();
		params.put("shopId", shopId);
		request = new AgentServiceRequestBean(url, params);
		try {
			jsonObject = new JSONObject(request.doPost(request));
		} catch (JSONException e) {
			logger.error("RegisterAction enterprise_register() error", e);
		}
		return jsonObject;
	}

	/**
	 * 经纪服务查询门店是否激活企业版
	 * 
	 * @param shopIdList
	 *            门店码列表,单个或批量,多个之间用逗号分隔,最多一次请求不超过30个门店
	 * @return JSONObject
	 */
	public JSONObject is_regist_enterprise(String shopIdList) {
		JSONObject jsonObject = null;
		url = agent_service_addr + "/external/is_regist_enterprise.json";
		params = new HashMap<String, Object>();
		params.put("shopIdList", shopIdList);
		request = new AgentServiceRequestBean(url, params);
		try {
			jsonObject = new JSONObject(request.doGet(request));
		} catch (JSONException e) {
			logger.error("RegisterAction is_regist_enterprise() error", e);
		}
		return jsonObject;
	}

	public static void main(String[] args) {
		RegisterAction RegisterAction = new RegisterAction();
		RegisterAction.enterprise_register(10010);
		// RegisterAction.is_regist_enterprise("1,2");
	}
}