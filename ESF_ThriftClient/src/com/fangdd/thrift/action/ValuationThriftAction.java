package com.fangdd.thrift.action;

import org.apache.log4j.Logger;

import com.fangdd.thrift.valuation.request.NewValuationRequest;
import com.fangdd.thrift.valuation.response.AgentValuationResponse;
import com.fangdd.utils.GlobalData;

/**
 * 估价服务
 * 
 * @author hexin
 * 
 */
public class ValuationThriftAction extends BaseThriftAction {
	protected Logger logger = Logger.getLogger(ValuationThriftAction.class);

	/**
	 * 添加经纪人估价房源
	 * 
	 * @param NewValuationRequest
	 * @return AgentValuationResponse
	 */
	public AgentValuationResponse agent_newValuation(
			NewValuationRequest NewValuationRequest) {
		AgentValuationResponse AgentValuationResponse = null;
		try {
			AgentValuationResponse = (AgentValuationResponse) invokerGet(
					"valuation", "agent_valuation", "insert",
					NewValuationRequest, AgentValuationResponse.class);
		} catch (Exception e) {
			AgentValuationResponse = new AgentValuationResponse();
			AgentValuationResponse.setCode(GlobalData.Code);
			AgentValuationResponse.setMsg(e.getMessage());
			logger.error("ValuationThriftAction agent_newValuation() error:", e);
		}
		return AgentValuationResponse;
	}
}