package org.crazyit.auction.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.crazyit.auction.action.base.BaseAction;
import org.crazyit.auction.business.BidBean;

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
public class DelItemAction extends BaseAction {

	private int itemId;;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	// 处理用户请求的execute方法
	public String execute() throws Exception {
		try {
			List<BidBean> bids = (List<BidBean>) mgr.getBidByItem(itemId);
			if (bids.size() > 0) {
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("DelItemAction", "该物品已有竞价关联，不可删除！");
				return ERROR;
			}
			mgr.delItem(itemId);
			return SUCCESS;
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return ERROR;
	}
}