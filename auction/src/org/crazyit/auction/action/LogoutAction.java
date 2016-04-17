package org.crazyit.auction.action;

import java.util.Map;

import org.crazyit.auction.action.base.BaseAction;

import com.opensymphony.xwork2.ActionContext;

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
public class LogoutAction extends BaseAction {

	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}
}