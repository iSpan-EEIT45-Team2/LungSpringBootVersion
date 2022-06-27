package com.eeit45team2.lungspringbootversion.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.login.dao.LoginDao;
import com.eeit45team2.lungspringbootversion.login.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public boolean checkLogin(MemberBean member) {
		return loginDao.checkLogin(member);
	}

}
