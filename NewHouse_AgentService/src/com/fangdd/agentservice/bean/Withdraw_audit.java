package com.fangdd.agentservice.bean;

public class Withdraw_audit {
	private int settle_id;
	private int status;
	private String comment;
	private int oper_user_id;
	private String oper_user_name;
	private String oper_role;
	private String oper_mobile;

	public int getSettle_id() {
		return settle_id;
	}

	public void setSettle_id(int settle_id) {
		this.settle_id = settle_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getOper_user_id() {
		return oper_user_id;
	}

	public void setOper_user_id(int oper_user_id) {
		this.oper_user_id = oper_user_id;
	}

	public String getOper_user_name() {
		return oper_user_name;
	}

	public void setOper_user_name(String oper_user_name) {
		this.oper_user_name = oper_user_name;
	}

	public String getOper_role() {
		return oper_role;
	}

	public void setOper_role(String oper_role) {
		this.oper_role = oper_role;
	}

	public String getOper_mobile() {
		return oper_mobile;
	}

	public void setOper_mobile(String oper_mobile) {
		this.oper_mobile = oper_mobile;
	}

}
