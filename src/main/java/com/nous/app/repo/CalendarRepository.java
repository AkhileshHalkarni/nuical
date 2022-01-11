package com.nous.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nous.app.model.Holiday;

public interface CalendarRepository extends CrudRepository<Holiday, Long>{

	public List<Holiday> findByName(String name);

	public String deleteByName(String name);
	
	@Query("FROM Holiday h where h.region.regionId = :regionId")
	public List<Holiday> findByRegion(Long regionId);
	
	@Query("FROM Holiday h where h.holidayTypes.holidayTypeId = :holidayTypeId")
	public List<Holiday> findByHolidayType(Long holidayTypeId);
	
	@Query("FROM Holiday h where h.holidayTypes.holidayTypeId = :holidayTypeId and h.region.regionId = :regionId")
	public List<Holiday> findByHolidayType(Long regionId, Long holidayTypeId);

}
