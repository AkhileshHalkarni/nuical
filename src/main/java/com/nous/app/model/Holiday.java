package com.nous.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

@Entity
@Table(name = "Holiday")

public class Holiday {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long holidayId;

	private String holidayName;
	private String name;
	private String date;
	private String day;
	private String description;
	private String note;
	@Lazy
	@ManyToOne
	@JoinColumn(name = "FK_regionId", nullable = false)
	private Region region;
    @Lazy 
	@ManyToOne
	@JoinColumn(name = "FK_holidayTypeId", nullable = false)
	private HolidayTypes holidayTypes;

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Holiday() {
		
		// TODO Auto-generated constructor stub
	}

	public Holiday(Long holidayId, String holidayName, String name, String date, String day, String description,
			String note) {
		
		this.holidayId = holidayId;
		this.holidayName = holidayName;
		this.name = name;
		this.date = date;
		this.day = day;
		this.description = description;
		this.note = note;
	}

	public Long getHolidayId() {
		return holidayId;
	}

	public void setHolidayId(Long holidayId) {
		this.holidayId = holidayId;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public HolidayTypes getHolidayTypes() {
		return holidayTypes;
	}

	public void setHolidayTypes(HolidayTypes holidayTypes) {
		this.holidayTypes = holidayTypes;
	}

	@Override
	public String toString() {
		return "Holiday [holidayId=" + holidayId + ", holidayName=" + holidayName + ", name=" + name + ", date=" + date
				+ ", day=" + day + ", description=" + description + ", note=" + note + "]";
	}

}
