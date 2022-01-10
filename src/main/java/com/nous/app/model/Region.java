package com.nous.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Region")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "holidays"})

public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regionId;
	private String regionName;
	@OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
	private Set<Holiday> holidays = new HashSet<Holiday>();

	public Region() {

	}

	public Region(Long regionId, String regionName) {
		
		this.regionId = regionId;
		this.regionName = regionName;
	
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Set<Holiday> getHolidays() {
		return holidays;
	}

	public void setHolidays(Set<Holiday> holidays) {
		this.holidays = holidays;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + "]";
	}

}