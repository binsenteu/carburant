package com.binsenteu.carburant.entity.gasstation;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "gas_station")
@SequenceGenerator(name = "seqGasStation", sequenceName = "seq_gas_station", initialValue = 100, allocationSize = 1)
public class GasStation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGasStation")
	@Column(name = "id_gas_station")
	private Integer id;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "adresse", column = @Column(name = "address_gas_station", length = 200)),
		@AttributeOverride(name = "codePostal", column = @Column(name = "zip_code_gas_station", length = 20)),
		@AttributeOverride(name = "ville", column = @Column(name = "city_gas_station", length = 150)),
		@AttributeOverride(name = "pop", column = @Column(name = "pop_gas_station")),
		@AttributeOverride(name = "longitude", column = @Column(name = "longitude_gas_station")),
		@AttributeOverride(name = "latitude", column = @Column(name = "latitude_gas_station"))
	})
	private Localisation localisation;
	@Column(name = "automate")
	private Boolean automate247;
	//TODO - change hours to set
	private Hours hours;
	@OneToMany(mappedBy = "id.fuel")
	private Set<Fuel> fuel;
	@Version
	private int version;

	public GasStation() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Localisation getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}

	public Boolean getAutomate247() {
		return automate247;
	}

	public void setAutomate247(Boolean automate247) {
		this.automate247 = automate247;
	}

	public Hours getHours() {
		return hours;
	}

	public void setHours(Hours hours) {
		this.hours = hours;
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
		GasStation other = (GasStation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}