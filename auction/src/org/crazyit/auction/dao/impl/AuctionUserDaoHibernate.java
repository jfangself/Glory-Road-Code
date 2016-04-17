package org.crazyit.auction.dao.impl;

import java.util.List;

import org.crazyit.auction.dao.AuctionUserDao;
import org.crazyit.auction.model.AuctionUser;
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
public class AuctionUserDaoHibernate extends HibernateDaoSupport implements
		AuctionUserDao {
	/**
	 * ����id�����û�
	 * 
	 * @param id
	 *            ��Ҫ���ҵ��û�id
	 */
	public AuctionUser get(Integer id) {
		return (AuctionUser) getHibernateTemplate().get(AuctionUser.class, id);
	}

	/**
	 * �����û�
	 * 
	 * @param user
	 *            ��Ҫ���ӵ��û�
	 */
	public void save(AuctionUser user) {
		getHibernateTemplate().save(user);
	}

	/**
	 * �޸��û�
	 * 
	 * @param user
	 *            ��Ҫ�޸ĵ��û�
	 */
	public void update(AuctionUser user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	/**
	 * ɾ���û�
	 * 
	 * @param id
	 *            ��Ҫɾ�����û�id
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ɾ���û�
	 * 
	 * @param user
	 *            ��Ҫɾ�����û�
	 */
	public void delete(AuctionUser user) {
		getHibernateTemplate().delete(user);
	}

	/**
	 * ��ѯȫ���û�
	 * 
	 * @return ���ȫ���û�
	 */
	@SuppressWarnings("unchecked")
	public List<AuctionUser> findAll() {
		return (List<AuctionUser>) getHibernateTemplate().find(
				"from AuctionUser");
	}

	/**
	 * �����û�������������û�
	 * 
	 * @param username
	 *            ��ѯ������û���
	 * @param pass
	 *            ��ѯ���������
	 * @return ָ���û����������Ӧ���û�
	 */
	public AuctionUser findUserByNameAndPass(String username, String pass) {
		// ִ��HQL��ѯ
		@SuppressWarnings("unchecked")
		List<AuctionUser> find = (List<AuctionUser>) getHibernateTemplate()
				.find("from AuctionUser au where au.username = ? and au.userpass = ?",
						username, pass);
		// ���ز�ѯ�õ��ĵ�һ��AuctionUser����
		if (find.size() == 1) {
			return (AuctionUser) find.get(0);
		}
		return null;
	}
}