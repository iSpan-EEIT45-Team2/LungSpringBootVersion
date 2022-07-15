package com.eeit45team2.lungspringbootversion.backend.member.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberBean memberBean;

	public CustomUserDetails(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public CustomUserDetails() {
	}

	@Override
	public String getPassword() {
		return this.memberBean.getMiPassword();
	}
	
	@Override
	public String getUsername() {
		return this.memberBean.getMiName();
	}
	
	@Override
	public boolean isAccountNonExpired() {
//		return this.user.isAccountNonExpired();
		return true;
	}
	




	@Override
	public boolean isAccountNonLocked() {
//		return this.user.isAccountNonLocked();
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
//		return this.user.isCredentialsNonExpired();
		return true;
	}

	@Override
	public boolean isEnabled() {
//		return this.user.isEnabled();
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return AuthorityUtils.createAuthorityList(user.getRole());
		return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
	}

	public MemberBean getUser() {
		return memberBean;
	}

	public void setUser(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	
	}

