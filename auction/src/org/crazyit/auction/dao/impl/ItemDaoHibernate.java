package org.crazyit.auction.dao.impl;

import java.util.List;

import org.crazyit.auction.dao.ItemDao;
import org.crazyit.auction.model.Item;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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
public class ItemDaoHibernate extends HibernateDaoSupport implements ItemDao {
	/**
	 * ��������������Ʒ
	 * 
	 * @param itemId
	 *            ����ҵ���Ʒ��id;
	 * @return id��Ӧ����Ʒ
	 */
	public Item get(Integer itemId) {
		return (Item) getHibernateTemplate().get(Item.class, itemId);
	}

	/**
	 * ������Ʒ
	 * 
	 * @param item
	 *            ��Ҫ�������Ʒ
	 */
	public void save(Item item) {
		getHibernateTemplate().save(item);
	}

	/**
	 * �޸���Ʒ
	 * 
	 * @param item
	 *            ��Ҫ�޸ĵ���Ʒ
	 */
	public void update(Item item) {
		getHibernateTemplate().saveOrUpdate(item);
	}

	/**
	 * ɾ����Ʒ
	 * 
	 * @param id
	 *            ��Ҫɾ������Ʒid
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ɾ����Ʒ
	 * 
	 * @param item
	 *            ��Ҫɾ������Ʒ
	 */
	public void delete(Item item) {
		getHibernateTemplate().delete(item);
	}

	/**
	 * ���ݲ�Ʒ���࣬��ȡ��ǰ������ȫ����Ʒ
	 * 
	 * @param kindId
	 *            ����id;
	 * @return �����ȫ����Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<Item> findItemByKind(Integer kindId) {
		return (List<Item>) getHibernateTemplate().find(
				"from Item as i where i.kind.id = ? and i.itemState.id = 1",
				kindId);
	}

	/**
	 * ��ȡ��Ʒ�����µ�ȫ����Ʒ
	 * 
	 * @param kindId
	 *            ����id;
	 * @return �����ȫ����Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<Item> findAllItemByKind(Integer kindId) {
		return (List<Item>) getHibernateTemplate().find(
				"from Item as i where i.kind.id = ?", kindId);
	}

	/**
	 * ���������߲��Ҵ��������е���Ʒ
	 * 
	 * @param useId
	 *            ������Id;
	 * @return ָ���û����������е�ȫ����Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<Item> findItemByOwner(Integer userId) {
		return (List<Item>) getHibernateTemplate().find(
				"from Item as i where i.owner.id = ? and i.itemState.id = 1",
				userId);
	}

	/**
	 * ����Ӯȡ�߲�����Ʒ
	 * 
	 * @param userId
	 *            Ӯȡ��Id;
	 * @return ָ���û�Ӯȡ��ȫ����Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<Item> findItemByWiner(Integer userId) {
		return (List<Item>) getHibernateTemplate().find(
				"from Item as i where i.winer.id = ? and i.itemState.id = 2",
				userId);
	}

	/**
	 * ������Ʒ״̬������Ʒ
	 * 
	 * @param stateId
	 *            ״̬Id;
	 * @return ��״̬�µ�ȫ����Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<Item> findItemByState(Integer stateId) {
		return (List<Item>) getHibernateTemplate().find(
				"from Item as i where i.itemState.id = ?", stateId);
	}
}