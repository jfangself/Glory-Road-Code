package com.fangdd.agentservice.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.fangdd.agentservice.bean.Get_account_trade_record;
import com.fangdd.utils.PropUtil;
import com.fangdd.utils.StringUtil;
import com.fangdd.utils.http.AgentServiceRequestBean;

public class MyAccountAction {
	protected Logger logger = Logger.getLogger(MyAccountAction.class);
	private PropUtil PropUtil = new PropUtil("config/server.properties");
	private String agent_service_addr = PropUtil.get("agent_service_addr");
	private AgentServiceRequestBean request;
	private String url;
	private Map<String, Object> params;

	/**
	 * 查询我的资金账户余额信息
	 * 
	 * @param user_id
	 *            用户id，即账户id
	 * @return JSONObject
	 */
	public JSONObject get_account_balance(int user_id) {
		JSONObject jsonObject = null;
		url = agent_service_addr + "/external/get_account_balance.json";
		params = new HashMap<String, Object>();
		params.put("user_id", user_id);
		request = new AgentServiceRequestBean(url, params);
		try {
			jsonObject = new JSONObject(request.doGet(request));
		} catch (JSONException e) {
			logger.error("MyAcountAction get_account_balance() error", e);
		}
		return jsonObject;
	}

	/**
	 * 查询我的资金账户交易明细
	 * 
	 * @param get_account_trade_record
	 * @return JSONObject
	 */
	public JSONObject get_account_trade_record(
			Get_account_trade_record get_account_trade_record) {
		JSONObject jsonObject = null;
		url = agent_service_addr + "/external/get_account_trade_record.json";
		params = new HashMap<String, Object>();
		params.put("user_id", get_account_trade_record.getUser_id());
		params.put("trade_type", get_account_trade_record.getTrade_type());
		if (!StringUtil.validateNull(get_account_trade_record.getStart_time())) {
			params.put("start_time", get_account_trade_record.getStart_time());
		}
		if (!StringUtil.validateNull(get_account_trade_record.getEnd_time())) {
			params.put("end_time", get_account_trade_record.getEnd_time());
		}
		params.put("page_index", get_account_trade_record.getPage_index());
		params.put("page_size", get_account_trade_record.getPage_size());
		request = new AgentServiceRequestBean(url, params);
		try {
			jsonObject = new JSONObject(request.doGet(request));
		} catch (JSONException e) {
			logger.error("MyAcountAction get_account_trade_record() error", e);
		}
		return jsonObject;
	}

	public static void main(String[] args) {
		MyAccountAction MyAccountAction = new MyAccountAction();
		// MyAcountAction.get_account_balance(203317);

		Get_account_trade_record get_account_trade_record = new Get_account_trade_record();
		get_account_trade_record.setUser_id(203317);
		get_account_trade_record.setTrade_type(0);
		get_account_trade_record.setStart_time("");
		get_account_trade_record.setEnd_time("");
		get_account_trade_record.setPage_index(1);
		get_account_trade_record.setPage_size(20);
		MyAccountAction.get_account_trade_record(get_account_trade_record);
	}
}