package org.crazyit.auction.action;

import java.util.List;

import org.crazyit.auction.action.base.BaseAction;

/**
 * Description: <br/>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> <br/>
 * Copyright (C), 2001-2010, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ViewItemAction extends BaseAction {
	private int kindId;
	private String kind;
	private List items;

	public String execute() throws Exception {
		if (kindId <= 0) {
			addActionError("您必须选择有效的种类");
			return ERROR;
		} else {
			setKind(mgr.getKind(kindId));
			setItems(mgr.getItemsByKind(kindId));
			return SUCCESS;
		}
	}

	public void setKindId(int kindId) {
		this.kindId = kindId;
	}

	public int getKindId() {
		return this.kindId;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getKind() {
		return this.kind;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public List getItems() {
		return this.items;
	}
}