package org.crazyit.auction.dao.impl;

import java.util.List;

import org.crazyit.auction.dao.KindDao;
import org.crazyit.auction.model.Kind;
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
public class KindDaoHibernate extends HibernateDaoSupport implements KindDao {
	/**
	 * ����id��������
	 * 
	 * @param id
	 *            ��Ҫ���ҵ������id
	 */
	public Kind get(Integer id) {
		return (Kind) getHibernateTemplate().get(Kind.class, id);
	}

	/**
	 * ��������
	 * 
	 * @param kind
	 *            ��Ҫ���ӵ�����
	 */
	public void save(Kind kind) {
		getHibernateTemplate().save(kind);
	}

	/**
	 * �޸�����
	 * 
	 * @param kind
	 *            ��Ҫ�޸ĵ�����
	 */
	public void update(Kind kind) {
		getHibernateTemplate().saveOrUpdate(kind);
	}

	/**
	 * ɾ������
	 * 
	 * @param id
	 *            ��Ҫɾ��������id
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ɾ������
	 * 
	 * @param kind
	 *            ��Ҫɾ��������
	 */
	public void delete(Kind kind) {
		getHibernateTemplate().delete(kind);
	}

	/**
	 * ��ѯȫ������
	 * 
	 * @return ���ȫ������
	 */
	@SuppressWarnings("unchecked")
	public List<Kind> findAll() {
		return (List<Kind>) getHibernateTemplate().find("from Kind");
	}
}
