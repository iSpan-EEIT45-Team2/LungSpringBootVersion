package com.eeit45team2.lungspringbootversion.login.dao;

import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;

public interface LoginDao {
	
	public boolean checkLogin(MemberBean member);

}
