package org.crazyit.auction.action;

import org.crazyit.auction.action.base.BaseAction;

/**
 * Description: <br/>
 * 利嫋: <a href="http://www.crazyit.org">決髄Java選男</a> <br/>
 * Copyright (C), 2001-2010, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class DelBidAction extends BaseAction {
	private int bidId;

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public String execute() throws Exception {
		try {
			mgr.delBid(bidId);
			return SUCCESS;
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return ERROR;
	}
}