package com.fangdd.thrift.action;

import org.apache.log4j.Logger;

import com.fangdd.thrift.combine.cell.request.SearchCellRequest;
import com.fangdd.thrift.combine.cell.response.SearchCellResponse;
import com.fangdd.thrift.combine.house.request.SearchHouseRequest;
import com.fangdd.thrift.combine.house.response.SearchHouseResponse;
import com.fangdd.utils.GlobalData;

/**
 * 组合服务
 * 
 * @author hexin
 * 
 */
public class CombineThriftAction extends BaseThriftAction {
	protected Logger logger = Logger.getLogger(CombineThriftAction.class);

	/**
	 * 根据关键字查询小区名
	 * 
	 * @param SearchCellRequest
	 * @return SearchCellResponse
	 */
	public SearchCellResponse cell_search_cell(
			SearchCellRequest SearchCellRequest) {
		SearchCellResponse SearchCellResponse = null;
		try {
			SearchCellResponse = (SearchCellResponse) invokerGet("combine",
					"cell", "search_cell", SearchCellRequest,
					SearchCellResponse.class);
		} catch (Exception e) {
			SearchCellResponse = new SearchCellResponse();
			SearchCellResponse.setCode(GlobalData.Code);
			SearchCellResponse.setMsg(e.getMessage());
			logger.error("CombineThriftAction cell_search_cell() error:", e);
		}
		return SearchCellResponse;
	}

	/**
	 * 查询房源列表
	 * 
	 * @param SearchHouseRequest
	 * @return SearchHouseResponse
	 */
	public SearchHouseResponse house_search_house(
			SearchHouseRequest SearchHouseRequest) {
		SearchHouseResponse SearchHouseResponse = null;
		try {
			SearchHouseResponse = (SearchHouseResponse) invokerGet("combine",
					"house", "search_house", SearchHouseRequest,
					SearchHouseResponse.class);
		} catch (Exception e) {
			SearchHouseResponse = new SearchHouseResponse();
			SearchHouseResponse.setCode(GlobalData.Code);
			SearchHouseResponse.setMsg(e.getMessage());
			logger.error("CombineThriftAction house_search_house() error:", e);
		}
		return SearchHouseResponse;
	}

	public static void main(String[] args) {

		SearchCellRequest SearchCellRequest = new SearchCellRequest();
		SearchCellRequest.setCityId(1337);
		SearchCellRequest.setKeyword("科技");

		CombineThriftAction CombineThriftAction = new CombineThriftAction();
		SearchCellResponse SearchCellResponse =CombineThriftAction.cell_search_cell(SearchCellRequest);
	}
}