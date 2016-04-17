package com.fangdd.agentservice.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.fangdd.agentservice.bean.Withdraw_audit;
import com.fangdd.agentservice.bean.Withdraw_list;
import com.fangdd.utils.PropUtil;
import com.fangdd.utils.StringUtil;
import com.fangdd.utils.http.AgentServiceRequestBean;

public class AccountAction {
	protected Logger logger = Logger.getLogger(AccountAction.class);
	private PropUtil PropUtil = new PropUtil("config/server.properties");
	private String agent_service_addr = PropUtil.get("agent_service_addr");
	private AgentServiceRequestBean request;
	private String url;
	private Map<String, Object> params;

	/**
	 * 审核提现单
	 * 
	 * @param withdraw_audit
	 * @return JSONObject
	 */
	public JSONObject withdraw_audit(Withdraw_audit withdraw_audit) {
		JSONObject jsonObject = null;
		url = agent_service_addr + "/external/account/withdraw_audit.json";
		params = new HashMap<String, Object>();
		params.put("settle_id", withdraw_audit.getSettle_id());
		params.put("status", withdraw_audit.getStatus());
		if (!StringUtil.validateNull(withdraw_audit.getComment())) {
			params.put("comment", withdraw_audit.getComment());
		}
		params.put("oper_user_id", withdraw_audit.getOper_user_id());
		params.put("oper_user_name", withdraw_audit.getOper_user_name());
		params.put("oper_role", withdraw_audit.getOper_role());
		params.put("oper_mobile", withdraw_audit.getOper_mobile());
		request = new AgentServiceRequestBean(url, params);
		try {
			jsonObject = new JSONObject(request.doPost(request));
		} catch (JSONException e) {
			logger.error("AcountAction withdraw_audit() error", e);
		}
		return jsonObject;
	}

	/**
	 * 查询提现单列表
	 * 
	 * @param withdraw_list
	 * @return JSONObject
	 */
	public JSONObject withdraw_list(Withdraw_list withdraw_list) {
		JSONObject jsonObject = null;
		url = agent_service_addr + "/external/account/withdraw_list.json";
		params = new HashMap<String, Object>();
		if (withdraw_list.getCity_id() > 0) {
			params.put("city_id", withdraw_list.getCity_id());
		}
		params.put("status", withdraw_list.getStatus());
		if (!StringUtil.validateNull(withdraw_list.getStart_time())) {
			params.put("start_time", withdraw_list.getStart_time());
		}
		if (!StringUtil.validateNull(withdraw_list.getEnd_time())) {
			params.put("end_time", withdraw_list.getEnd_time());
		}
		if (withdraw_list.getSettle_id() > 0) {
			params.put("settle_id", withdraw_list.getSettle_id());
		}
		if (!StringUtil.validateNull(withdraw_list.getCompany_key())) {
			params.put("company_key", withdraw_list.getCompany_key());
		}
		if (!StringUtil.validateNull(withdraw_list.getOper_user())) {
			params.put("oper_user", withdraw_list.getOper_user());
		}
		params.put("page_index", withdraw_list.getPage_index());
		params.put("page_size", withdraw_list.getPage_size());
		request = new AgentServiceRequestBean(url, params);
		try {
			jsonObject = new JSONObject(request.doGet(request));
		} catch (JSONException e) {
			logger.error("AcountAction withdraw_list() error", e);
		}
		return jsonObject;
	}

	/**
	 * 查询指定提现单操作明细
	 * 
	 * @param settle_id
	 *            提现单ID
	 * @return JSONObject
	 */
	public JSONObject withdraw_oper_list(int settle_id) {
		JSONObject jsonObject = null;
		url = agent_service_addr + "/external/account/withdraw_oper_list.json";
		params = new HashMap<String, Object>();
		params.put("settle_id", settle_id);
		request = new AgentServiceRequestBean(url, params);
		try {
			jsonObject = new JSONObject(request.doGet(request));
		} catch (JSONException e) {
			logger.error("AcountAction withdraw_oper_list() error", e);
		}
		return jsonObject;
	}

	/**
	 * 查询指定提现单详情
	 * 
	 * @param settle_id
	 *            提现单ID
	 * @return JSONObject
	 */
	public JSONObject withdraw_detail(int settle_id) {
		JSONObject jsonObject = null;
		url = agent_service_addr + "/external/account/withdraw_detail.json";
		params = new HashMap<String, Object>();
		params.put("settle_id", settle_id);
		request = new AgentServiceRequestBean(url, params);
		try {
			jsonObject = new JSONObject(request.doGet(request));
		} catch (JSONException e) {
			logger.error("AcountAction withdraw_detail() error", e);
		}
		return jsonObject;
	}

	/**
	 * 接收支付系统付款结果
	 * 
	 * @param withdraw_id
	 *            由支付系统或结佣系统生成的唯一标识一笔付款(提现)单的ID
	 * @param result
	 *            付款结果:0-付款成功;1-付款失败
	 * @param comment
	 *            如果付款失败的原因等
	 * @return JSONObject
	 */
	public JSONObject receive_pay_result(String withdraw_id, int result,
			String comment) {
		JSONObject jsonObject = null;
		url = agent_service_addr + "/external/account/receive_pay_result.json";
		params = new HashMap<String, Object>();
		params.put("withdraw_id", withdraw_id);
		params.put("result", result);
		if (!StringUtil.validateNull(comment)) {
			params.put("comment", comment);
		}
		request = new AgentServiceRequestBean(url, params);
		try {
			jsonObject = new JSONObject(request.doGet(request));
		} catch (JSONException e) {
			logger.error("AcountAction receive_pay_result() error", e);
		}
		return jsonObject;
	}

	public static void main(String[] args) {
		AccountAction AccountAction = new AccountAction();
		AccountAction.receive_pay_result("1234567890123456789", 1, "失败");
	}
}