package com.binsenteu.carburant.model.gasstation;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import com.binsenteu.carburant.views.Views;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


@Entity
@Table(name = "fuel")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 6)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
	@Type(value=E10.class, name="E10"),
	@Type(value=E85.class, name="E85"),
	@Type(value=GPLc.class, name="GPLc"),
	@Type(value=Gazole.class, name="Gazole"),
	@Type(value=SP95.class, name="SP95"),
	@Type(value=SP98.class, name="SP98")
})
@SequenceGenerator(name = "seqFuel", sequenceName = "seq_fuel", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Fuel {
	@JsonView(value = {Views.GasStationView.class})
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFuel")
	@Column(name = "id_fuel")
	private Integer id_fuel;
	@ManyToOne
	@JoinColumn(name = "id_gas_station", foreignKey = @ForeignKey(name = "gas_station_fuel_fk"))
	private GasStation gasStation;
	@JsonView(value = {Views.GasStationView.class})
	@Column(name = "available_fuel")
	private Boolean available;
	@JsonView(value = {Views.GasStationView.class})
	@Column(name = "price_fuel")
	private Double price;
	@JsonView(value = {Views.GasStationView.class})
	@Column(name = "date_fuel")
	@Temporal(TemporalType.DATE)
	private Date lastUpdate;
	@JsonView(value = {Views.GasStationView.class})
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
