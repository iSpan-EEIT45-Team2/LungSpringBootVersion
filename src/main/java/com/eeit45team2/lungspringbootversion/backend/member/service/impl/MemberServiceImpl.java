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
		if(theMemberBean.getMiNo()!=null){ //是修改時
			String oldPassword = memberRepository.findById(theMemberBean.getMiNo()).get().getMiPassword();
			if(!theMemberBean.getMiPassword().equals(oldPassword)){ //有修改密碼
				theMemberBean.setMiPassword(passwordEncoder.encode(theMemberBean.getMiPassword())); //對密碼進行加密
			}
		}else{  //是新增時
			theMemberBean.setMiPassword(passwordEncoder.encode(theMemberBean.getMiPassword())); //對密碼進行加密
		}
		memberRepository.save(theMemberBean);
	}

	@Override
	public MemberBean findById(Long miNo) {
		return memberRepository.findById(miNo).get();
	}

	@Override
	public void delete(Long miNo) {
		memberRepository.deleteById(miNo);
	}

	@Override
	public void testDelete(String miNo) {
		Long id = Long.valueOf(miNo);
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
