package org.crazyit.auction.schedule;

import java.util.TimerTask;

import org.crazyit.auction.exception.AuctionException;
import org.crazyit.auction.service.AuctionManager;

/**
 * Description: <br/>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>
 * Copyright (C), 2001-2010, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class CheckWiner extends TimerTask {
	// ������������ҵ���߼����
	private AuctionManager mgr;

	// ����ע��ҵ���߼���������setter����
	public void setMgr(AuctionManager mgr) {
		this.mgr = mgr;
	}

	// �������ִ����
	public void run() {
		try {
			mgr.updateWiner();
		} catch (AuctionException ae) {
			ae.printStackTrace();
		}
	}
}