package com.nous.app.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.nous.app.model.HolidayTypes;

public interface HolidayTypeRepository extends CrudRepository<HolidayTypes, Integer>{

	public List<HolidayTypes> findByHolidayTypeName(String holidayTypeName);
	public List<HolidayTypes> findByHolidayTypeId(int holidayTypeId);


}
