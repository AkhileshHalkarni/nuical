package com.nous.app.services;

import java.util.List;


import com.nous.app.model.HolidayTypes;

public interface HolidayTypeService {
	
	public List<HolidayTypes> getTypesOfHolidays();

//	public String saveTypesOfHoliday(String typesOfHoliday1);
	public List<HolidayTypes> getHolidayTypeName(String holidayTypeName);
	public List<HolidayTypes> getHolidayTypeId(int holidayTypeId);


	
}
