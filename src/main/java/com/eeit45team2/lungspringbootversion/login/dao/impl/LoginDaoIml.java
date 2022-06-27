package com.eeit45team2.lungspringbootversion.login.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.login.dao.LoginDao;

@Repository
@Transactional
public class LoginDaoIml implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean checkLogin(MemberBean member) {
		Session session = sessionFactory.getCurrentSession();  //OpenSession?
		
		String hql = "FROM MemberBean mb WHERE mb.mi_account = :account and mb.mi_password = :password ";
		Query<MemberBean> query = session.createQuery(hql, MemberBean.class);
		query.setParameter("account", member.getMi_account().toUpperCase());  //要怎麼區分大小寫
		query.setParameter("password", member.getMi_password());
        
        MemberBean memberbean = query.uniqueResult();
        
        if(memberbean!=null) {
        	return true;
        }
		return false;
		
	}
	
	
}
