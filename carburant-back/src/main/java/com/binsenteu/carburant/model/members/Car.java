package com.binsenteu.carburant.model.members;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.binsenteu.carburant.model.gasstation.GasStation;

@Entity
@Table(name = "car")
@SequenceGenerator(name = "seqCar", sequenceName = "seq_car", initialValue = 100, allocationSize = 1)

public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCar")
	@Column(name = "id_car")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "username_member", foreignKey = @ForeignKey(name = "member_car_fk"))
	private Member member;
	@Column(name = "make_car")
	private String make;
	@Column(name = "model_car")
	private String model;
	@Column(name = "fuel_type_car")
	private FuelType fuelType;
	@Version
	private int version;

	public Car() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
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
		Car other = (Car) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
