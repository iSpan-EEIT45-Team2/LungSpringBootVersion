package com.eeit45team2.lungspringbootversion.backend.member.service;

import java.util.List;

import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;

public interface MemberService {
	
	//show all
	public List<MemberBean> findAll();
	
	//save
	public void save(MemberBean theMemberBean);
	
	//findById
	public MemberBean findById(Long mi_no);
	
	//delete
	public void delete(Long mi_no);

	public void testDelete(String mi_no);
	
}
