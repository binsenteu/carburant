package com.binsenteu.carburant.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.binsenteu.carburant.model.members.Member;
import com.binsenteu.carburant.model.members.MemberRole;

public class Utilisateur implements UserDetails {

	private Member member;
	
	public Utilisateur(Member member) {
		this.member = member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		for (MemberRole memberRole : member.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(memberRole.getRole().toString()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		return member.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		//return member.isEnabled() ??
		return true;
	}

}
