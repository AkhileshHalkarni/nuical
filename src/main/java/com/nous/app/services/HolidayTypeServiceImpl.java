package com.nous.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nous.app.model.Holiday;
import com.nous.app.model.Region;
import com.nous.app.repo.HolidayTypeRepository;
import com.nous.app.model.HolidayTypes;

@Service
public class HolidayTypeServiceImpl implements HolidayTypeService{
	
	@Autowired
	HolidayTypeRepository holidayTypeRepository;

	@Override
	public List<HolidayTypes> getTypesOfHolidays() {
		// TODO Auto-generated method stub
		return (List <HolidayTypes>)  holidayTypeRepository.findAll();
	}

	@Override
	public List<HolidayTypes> getHolidayTypeName(String holidayTypeName) {
		// TODO Auto-generated method stub
		return holidayTypeRepository.findByHolidayTypeName(holidayTypeName);
	}

	@Override
	public List<HolidayTypes> getHolidayTypeId(int holidayTypeId) {
		// TODO Auto-generated method stub
		return holidayTypeRepository.findByHolidayTypeId(holidayTypeId);
	}

//	@Override
	//public String saveTypesOfHoliday(TypesOfHoliday typesOfHoliday) {
		//if(typesOfHoliday.getHolidayTypeName() == null)
		//{
			//return "negative";
		//}
		//else {
			//holidayTypeRepository.save(typesOfHoliday);
			//return "saved successfully..!!";
		//}
	//}
}
