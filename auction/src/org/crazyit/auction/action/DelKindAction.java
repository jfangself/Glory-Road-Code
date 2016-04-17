package org.crazyit.auction.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.crazyit.auction.action.base.BaseAction;
import org.crazyit.auction.business.ItemBean;

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
public class DelKindAction extends BaseAction {
	private int kindId;

	public int getKindId() {
		return kindId;
	}

	public void setKindId(int kindId) {
		this.kindId = kindId;
	}

	public String execute() throws Exception {
		try {
			ArrayList<ItemBean> items = (ArrayList<ItemBean>) mgr
					.getAllItemsByKind(kindId);
			if (items.size() > 0) {
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("DelKindAction", "该种类已有物品关联，不可删除！");
				return ERROR;
			}
			mgr.delKind(kindId);
			return SUCCESS;
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return ERROR;
	}
}