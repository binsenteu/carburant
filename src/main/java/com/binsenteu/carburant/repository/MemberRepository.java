package com.binsenteu.carburant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binsenteu.carburant.entity.members.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	public Optional<Member> findByUsername(String username);

}
