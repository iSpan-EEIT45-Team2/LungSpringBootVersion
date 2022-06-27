package com.eeit45team2.lungspringbootversion.backend.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit45team2.lungspringbootversion.backend.member.dao.MemberDao;
import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.backend.member.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	@Transactional
	public List<MemberBean> findAll() {
		return memberDao.findAll();
	}

	@Override
	@Transactional
	public void saveMember(MemberBean theMemberBean) {
		memberDao.saveMember(theMemberBean);
	}

	@Override
	@Transactional
	public MemberBean findById(Integer mi_no) {
		return memberDao.findById(mi_no);
	}

	@Override
	@Transactional
	public void deleteMember(Integer mi_no) {
		memberDao.deleteMember(mi_no);
	}

}
