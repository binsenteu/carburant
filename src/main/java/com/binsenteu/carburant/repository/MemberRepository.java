package com.binsenteu.carburant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binsenteu.carburant.model.members.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	
	public Optional<Member> findByUsername(String username);

}
