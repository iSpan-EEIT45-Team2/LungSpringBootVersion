package com.eeit45team2.lungspringbootversion.backend.member.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		theMemberBean.setMiPassword(passwordEncoder.encode(theMemberBean.getMiPassword())); //對密碼進行加密
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


	@Override
	public Boolean existsByMiAccount(String miAccount){
		return memberRepository.existsByMiAccount(miAccount);
	}

	@Override
	public MemberBean findByMiAccount(String miAccount){
		return memberRepository.findByMiAccount(miAccount);
	}

}
