package com.binsenteu.carburant.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.binsenteu.carburant.model.members.Member;
import com.binsenteu.carburant.repository.MemberRepository;

@Service
public class AuthService implements UserDetailsService{

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> opt = memberRepository.findByUsername(username);
		if (!opt.isPresent()) {
			throw new UsernameNotFoundException("Utilisateur inconnu");
		}
		Utilisateur user = new Utilisateur(opt.get());
		return user;
	}
	
}
