package com.binsenteu.carburant.entity.gasstation;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class HoursPK implements Serializable {

	@ManyToOne
	@JoinColumn(name = "hours", foreignKey = @ForeignKey(name = "gas_station_hours_hours_fk"))
	private Hours hours;
	@ManyToOne
	@JoinColumn(name = "gas_station", foreignKey = @ForeignKey(name = "gas_station_hours_station_fk"))
	private GasStation gasStation;

	public HoursPK() {
	}

	public Hours getHours() {
		return hours;
	}

	public void setHours(Hours hours) {
		this.hours = hours;
	}

	public GasStation getGasStation() {
		return gasStation;
	}

	public void setGasStation(GasStation gasStation) {
		this.gasStation = gasStation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gasStation == null) ? 0 : gasStation.hashCode());
		result = prime * result + ((hours == null) ? 0 : hours.hashCode());
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
		HoursPK other = (HoursPK) obj;
		if (gasStation == null) {
			if (other.gasStation != null)
				return false;
		} else if (!gasStation.equals(other.gasStation))
			return false;
		if (hours == null) {
			if (other.hours != null)
				return false;
		} else if (!hours.equals(other.hours))
			return false;
		return true;
	}

}
