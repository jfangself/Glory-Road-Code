package com.fangdd.agentservice.bean;

public class Withdraw_list {
	private int city_id;
	private int status;
	private String start_time;
	private String end_time;
	private int settle_id;
	private String company_key;
	private String oper_user;
	private int page_index;
	private int page_size;

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public int getSettle_id() {
		return settle_id;
	}

	public void setSettle_id(int settle_id) {
		this.settle_id = settle_id;
	}

	public String getCompany_key() {
		return company_key;
	}

	public void setCompany_key(String company_key) {
		this.company_key = company_key;
	}

	public String getOper_user() {
		return oper_user;
	}

	public void setOper_user(String oper_user) {
		this.oper_user = oper_user;
	}

	public int getPage_index() {
		return page_index;
	}

	public void setPage_index(int page_index) {
		this.page_index = page_index;
	}

	public int getPage_size() {
		return page_size;
	}

	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}
}
