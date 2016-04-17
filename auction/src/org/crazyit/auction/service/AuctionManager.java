package org.crazyit.auction.service;

import java.util.List;

import org.crazyit.auction.business.BidBean;
import org.crazyit.auction.business.ItemBean;
import org.crazyit.auction.business.KindBean;
import org.crazyit.auction.exception.AuctionException;

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
public interface AuctionManager {
	/**
	 * ����Ӯȡ�߲�ѯ��Ʒ
	 * 
	 * @param winerId
	 *            Ӯȡ�ߵ�ID
	 * @return Ӯȡ�߻�õ�ȫ����Ʒ
	 */
	List<ItemBean> getItemByWiner(Integer winerId) throws AuctionException;

	/**
	 * ��ѯ���ĵ�ȫ����Ʒ
	 * 
	 * @return ȫ��������Ʒ
	 */
	List<ItemBean> getFailItems() throws AuctionException;

	/**
	 * �����û�����������֤��¼�Ƿ�ɹ�
	 * 
	 * @param username
	 *            ��¼���û���
	 * @param pass
	 *            ��¼������
	 * @return ��¼�ɹ������û�ID�����򷵻�-1
	 */
	int validLogin(String username, String pass) throws AuctionException;

	/**
	 * ��ѯ�û���ȫ������
	 * 
	 * @param userId
	 *            �����û���ID
	 * @return �û���ȫ������
	 */
	List<BidBean> getBidByUser(Integer userId) throws AuctionException;

	/**
	 * ������Ʒ���Ҿ���
	 * 
	 * @param itemId
	 *            ��Ʒid
	 * 
	 * @return ��Ʒ��Ӧ��ȫ������
	 */
	List<BidBean> getBidByItem(Integer itemId) throws AuctionException;

	/**
	 * �����û�����Ŀǰ���������е�ȫ����Ʒ
	 * 
	 * @param userId
	 *            �����ߵ�ID
	 * @return ���ڵ�ǰ�û��ġ����������е�ȫ����Ʒ��
	 */
	List<ItemBean> getItemsByOwner(Integer userId) throws AuctionException;

	/**
	 * ��ѯȫ������
	 * 
	 * @return ϵͳ��ȫ��ȫ������
	 */
	List<KindBean> getAllKind() throws AuctionException;

	/**
	 * �����Ʒ
	 * 
	 * @param name
	 *            ��Ʒ����
	 * @param desc
	 *            ��Ʒ����
	 * @param remark
	 *            ��Ʒ��ע
	 * @param avail
	 *            ��Ч����
	 * @param kind
	 *            ��Ʒ����
	 * @param userId
	 *            ����ߵ�ID
	 * @return ������Ʒ������
	 */
	int addItem(String name, String desc, String remark, double initPrice,
			int avail, int kind, Integer userId) throws AuctionException;

	/**
	 * ɾ����Ʒ
	 * 
	 * @param id
	 *            ��Ʒid
	 */
	void delItem(Integer id) throws AuctionException;

	/**
	 * �������
	 * 
	 * @param name
	 *            ��������
	 * @param desc
	 *            ��������
	 * @return �������������
	 */
	int addKind(String name, String desc) throws AuctionException;

	/**
	 * ɾ������
	 * 
	 * @param id
	 *            ����id
	 */
	void delKind(Integer id) throws AuctionException;

	/**
	 * ���ݲ�Ʒ���࣬��ȡ���������е�ȫ����Ʒ
	 * 
	 * @param kindId
	 *            ����id;
	 * @return �����ȫ����Ʒ
	 */
	List<ItemBean> getItemsByKind(int kindId) throws AuctionException;

	/**
	 * ��ȡ��Ʒ�����µ�ȫ����Ʒ
	 * 
	 * @param kindId
	 *            ����id;
	 * @return �����ȫ����Ʒ
	 */
	public List<ItemBean> getAllItemsByKind(int kindId) throws AuctionException;

	/**
	 * ��������id��ȡ������
	 * 
	 * @param kindId
	 *            ����id;
	 * @return �����������
	 */
	String getKind(int kindId) throws AuctionException;

	/**
	 * ������Ʒid����ȡ��Ʒ
	 * 
	 * @param itemId
	 *            ��Ʒid;
	 * @return ָ��id��Ӧ����Ʒ
	 */
	ItemBean getItem(int itemId) throws AuctionException;

	/**
	 * �����µľ��ۣ����Ծ����û����ʼ�֪ͨ
	 * 
	 * @param itemId
	 *            ��Ʒid;
	 * @param bidPrice
	 *            ���ۼ۸�
	 * @param userId
	 *            �����û���ID
	 * @return �����������ۼ�¼��ID
	 */
	int addBid(int itemId, double bidPrice, Integer userId)
			throws AuctionException;

	/**
	 * �����µľ��ۣ����Ծ����û����ʼ�֪ͨ
	 * 
	 * @param bidId
	 *            ����id;
	 */
	void delBid(int bidId) throws AuctionException;

	/**
	 * ����ʱ�����޸���Ʒ��Ӯȡ��
	 */
	void updateWiner() throws AuctionException;
}