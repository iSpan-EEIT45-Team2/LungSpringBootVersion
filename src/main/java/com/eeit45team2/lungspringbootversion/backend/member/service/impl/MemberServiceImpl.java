package com.eeit45team2.lungspringbootversion.backend.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit45team2.lungspringbootversion.backend.member.repository.MemberRepository;
import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.backend.member.service.MemberService;


@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public List<MemberBean> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public void save(MemberBean theMemberBean) {
		memberRepository.save(theMemberBean);
	}

	@Override
	public MemberBean findById(Long mi_no) {
		return memberRepository.findById(mi_no).get();
	}

	@Override
	public void delete(Long mi_no) {

		memberRepository.deleteById(mi_no);
	}

	@Override
	public void testDelete(String mi_no) {
		Long id = Long.valueOf(mi_no);
		memberRepository.deleteById(id);

	}


}
