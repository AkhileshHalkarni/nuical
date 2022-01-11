package com.nous.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="HolidayTypes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "holidays"})
public class HolidayTypes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long holidayTypeId;
	
	@Column(name="holidayTypeName")
	private String holidayTypeName;
	@OneToMany(mappedBy = "holidayTypes", cascade = CascadeType.ALL)
	private Set<Holiday> holidays = new HashSet<Holiday>();

	
	public HolidayTypes() {
		
	}

	public HolidayTypes(Long holidayTypeId, String holidayTypeName) {
	
		this.holidayTypeId = holidayTypeId;
		this.holidayTypeName = holidayTypeName;
	}

	
	public Long getHolidayTypeId() {
		return holidayTypeId;
	}

	public void setHolidayTypeId(Long holidayTypeId) {
		this.holidayTypeId = holidayTypeId;
	}

	public String getHolidayTypeName() {
		return holidayTypeName;
	}

	public void setHolidayTypeName(String holidayTypeName) {
		this.holidayTypeName = holidayTypeName;
	}

	public Set<Holiday> getHolidays() {
		return holidays;
	}

	public void setHolidays(Set<Holiday> holidays) {
		this.holidays = holidays;
	}

	@Override
	public String toString() {
		return "TypesOfHoliday [holidayTypeId=" + holidayTypeId + ", holidayTypeName=" + holidayTypeName + "]";
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HolidayTypes )) return false;
        return holidayTypeId != null && holidayTypeId.equals(((HolidayTypes) o).getHolidayTypeId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
