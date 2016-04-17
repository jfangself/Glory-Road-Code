package com.fangdd.agentservice.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.fangdd.utils.PropUtil;
import com.fangdd.utils.http.AgentServiceRequestBean;

public class CityAction {
	protected Logger logger = Logger.getLogger(CityAction.class);
	private PropUtil PropUtil = new PropUtil("config/server.properties");
	private String agent_service_addr = PropUtil.get("agent_service_addr");
	private AgentServiceRequestBean request;
	private String url;
	private Map<String, Object> params;

	/**
	 * 查看某城市开通企业版结佣的时间点
	 * 
	 * @param city_id
	 *            查询城市id
	 * @return JSONObject
	 */
	public JSONObject get_publish_time(int city_id) {
		JSONObject jsonObject = null;
		url = agent_service_addr + "/external/city/get_publish_time.json";
		params = new HashMap<String, Object>();
		params.put("city_id", city_id);
		request = new AgentServiceRequestBean(url, params);
		try {
			jsonObject = new JSONObject(request.doGet(request));
		} catch (JSONException e) {
			logger.error("CityAction get_publish_time() error", e);
		}
		return jsonObject;
	}

	public static void main(String[] args) {
		CityAction CityAction = new CityAction();
		CityAction.get_publish_time(1337);
	}
}