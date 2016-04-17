package com.fangdd.thrift.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fangdd.thrift.action.CombineThriftAction;
import com.fangdd.thrift.combine.cell.request.SearchCellRequest;
import com.fangdd.thrift.combine.cell.response.SearchCellResponse;
import com.fangdd.thrift.combine.house.request.SearchHouseRequest;
import com.fangdd.thrift.combine.house.response.SearchHouseResponse;
import com.fangdd.utils.StringUtil;
import com.google.gson.Gson;

/**
 * 组合服务
 * 
 * @author hexin
 * 
 */
@WebServlet(urlPatterns = "/thrift/combineServlet")
public class CombineServlet extends HttpServlet {
	private CombineThriftAction CombineThriftAction;
	private Gson Gson;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		CombineThriftAction = new CombineThriftAction();
		Gson = new Gson();

	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = request.getParameter("action");
		switch (action) {
		case "cell_search_cell":
			this.cell_search_cell(request, response);
			break;
		case "house_search_house":
			this.house_search_house(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 根据关键字查询小区名
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void cell_search_cell(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		String keyword = request.getParameter("keyword");

		SearchCellRequest SearchCellRequest = new SearchCellRequest();
		SearchCellRequest.setCityId(cityId);
		SearchCellRequest.setKeyword(keyword);
		SearchCellResponse SearchCellResponse = CombineThriftAction
				.cell_search_cell(SearchCellRequest);
		String req = Gson.toJson(SearchCellRequest);
		String resp = Gson.toJson(SearchCellResponse);
		request.setAttribute("req", req);
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}

	/**
	 * 查询房源列表
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void house_search_house(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		int Property = Integer.parseInt(request.getParameter("Property"));

		String cellIdString = request.getParameter("cellId");
		long cellId = 0;
		if (!StringUtil.validateNull(cellIdString)) {
			cellId = Long.parseLong(cellIdString);
		}
		String pageNoString = request.getParameter("pageNo");
		int pageNo = 0;
		if (!StringUtil.validateNull(pageNoString)) {
			pageNo = Integer.parseInt(pageNoString);
		}
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = 20;
		if (!StringUtil.validateNull(pageSizeString)) {
			pageSize = Integer.parseInt(pageSizeString);
		}

		SearchHouseRequest SearchHouseRequest = new SearchHouseRequest();
		SearchHouseRequest.setCityId(cityId);
		if (cellId > 0) {
			SearchHouseRequest.setCellId(cellId);
		}
		SearchHouseRequest.setProperty(Property);
		SearchHouseRequest.setPageNo(pageNo);
		SearchHouseRequest.setPageSize(pageSize);
		SearchHouseResponse SearchHouseResponse = CombineThriftAction
				.house_search_house(SearchHouseRequest);
		String req = Gson.toJson(SearchHouseRequest);
		String resp = Gson.toJson(SearchHouseResponse);
		request.setAttribute("req", req);
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}
}