package com.binsenteu.carburant.entity.gasstation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "fuel")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 4)
@SequenceGenerator(name = "seqFuel", sequenceName = "seq_fuel", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Fuel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFuel")
	@Column(name = "id_fuel")
	private Integer id_fuel;
	@ManyToOne
	@JoinColumn(name = "id_gas_station", foreignKey = @ForeignKey(name = "gas_station_fuel_fk"))
	private GasStation gasStation;
	@Column(name = "available_fuel")
	private Boolean available;
	@Column(name = "price_fuel")
	private Double price;
	@Column(name = "date_fuel")
	@Temporal(TemporalType.DATE)
	private Date lastUpdate;
	@Version
	private int version;

	public Fuel() {
	}

	public Integer getId() {
		return id_fuel;
	}

	public void setId(Integer id) {
		this.id_fuel = id;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_fuel == null) ? 0 : id_fuel.hashCode());
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
		Fuel other = (Fuel) obj;
		if (id_fuel == null) {
			if (other.id_fuel != null)
				return false;
		} else if (!id_fuel.equals(other.id_fuel))
			return false;
		return true;
	}



}
