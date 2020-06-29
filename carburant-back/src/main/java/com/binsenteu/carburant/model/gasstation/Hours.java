package com.binsenteu.carburant.model.gasstation;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.binsenteu.carburant.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "gas_station_hours")
@SequenceGenerator(name = "seqHours", sequenceName = "seq_hours", initialValue = 50, allocationSize = 1)
public class Hours {
	@JsonView(value = {Views.GasStationView.class})
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqHours")
	private Integer id_hours;
	@ManyToOne
	@JoinColumn(name = "id_gas_station", foreignKey = @ForeignKey(name = "gas_station_hours_fk"))
	private GasStation gasStation;
	@JsonView(value = {Views.GasStationView.class})
	@Column(name = "day")
	@Enumerated(EnumType.STRING)
	private DayOfWeek day;
	@JsonView(value = {Views.GasStationView.class})
	@Column(name = "opening")
	private LocalTime opening;
	@JsonView(value = {Views.GasStationView.class})
	@Column(name = "closing")
	private LocalTime closing;
	
	public Hours(DayOfWeek day, LocalTime opening, LocalTime closing) {
		this.day = day;
		this.opening = opening;
		this.closing = closing;
	}

	public Hours() {
	}
	
	

	public Integer getId_hours() {
		return id_hours;
	}

	public void setId_hours(Integer id_hours) {
		this.id_hours = id_hours;
	}

	public GasStation getGasStation() {
		return gasStation;
	}

	public void setGasStation(GasStation gasStation) {
		this.gasStation = gasStation;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public LocalTime getOpening() {
		return opening;
	}

	public void setOpening(LocalTime opening) {
		this.opening = opening;
	}

	public LocalTime getClosing() {
		return closing;
	}

	public void setClosing(LocalTime closing) {
		this.closing = closing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_hours == null) ? 0 : id_hours.hashCode());
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
		Hours other = (Hours) obj;
		if (id_hours == null) {
			if (other.id_hours != null)
				return false;
		} else if (!id_hours.equals(other.id_hours))
			return false;
		return true;
	}


	
	
	
}
