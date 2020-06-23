package com.binsenteu.carburant.entity.gasstation;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "gas_station_hours")
public class Hours {
	@EmbeddedId
	private HoursPK id;
	@Column(name = "day")
	@Enumerated(EnumType.STRING)
	private DayOfWeek day;
	@Column(name = "opening")
	private LocalTime opening;
	@Column(name = "closing")
	private LocalTime closing;
	
	public Hours(DayOfWeek day, LocalTime opening, LocalTime closing) {
		this.day = day;
		this.opening = opening;
		this.closing = closing;
	}

	public Hours() {
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
		result = prime * result + ((closing == null) ? 0 : closing.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((opening == null) ? 0 : opening.hashCode());
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
		if (closing == null) {
			if (other.closing != null)
				return false;
		} else if (!closing.equals(other.closing))
			return false;
		if (day != other.day)
			return false;
		if (opening == null) {
			if (other.opening != null)
				return false;
		} else if (!opening.equals(other.opening))
			return false;
		return true;
	}
	
	
	
}
