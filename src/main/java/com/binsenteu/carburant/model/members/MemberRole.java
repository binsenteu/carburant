package com.binsenteu.carburant.model.members;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "member_role")
@SequenceGenerator(name = "seqMemberRole", sequenceName = "seq_member_role", initialValue = 100, allocationSize = 1)
public class MemberRole {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMemberRole")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "username_member", foreignKey = @ForeignKey(name = "member_role_username_fk"))
	private Member member;
	@Enumerated(EnumType.STRING)
	@Column(name = "role", length = 30)
	private Role role;

	public MemberRole() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberRole other = (MemberRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
