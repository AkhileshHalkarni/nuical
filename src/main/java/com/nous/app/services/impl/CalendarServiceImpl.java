package com.nous.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nous.app.model.Holiday;
import com.nous.app.repo.CalendarRepository;
import com.nous.app.services.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {
	
	@Autowired
	CalendarRepository calendarRepository;

	@Override
	public List<Holiday> getHolidays() {
		return (List <Holiday>) calendarRepository.findAll();
	}

	@Override
	public String saveHoliday(Holiday calendar) {
		if(calendar.getName() == null)
		{
			return "negative";
		}
		else {
			calendarRepository.save(calendar);
			return "saved successfully..!!";
		}
	}

	@Override
	public String updateHoliday(Holiday calendar) {
		if(calendar.getName() == null)
		{
			return " Provide valid name ";
		}
		else {
			calendarRepository.save(calendar);
			return "Updated successfully..!!";
		}
	}

	@Override
	public List<Holiday> findByName(String name) {
		return calendarRepository.findByName(name);
	}

	

	@Override
	public boolean isHolidayExists(Long holidayId) {
		Optional<Holiday> calendar = calendarRepository.findById(holidayId);
		Holiday cal = calendar.get();
		if(cal == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Holiday> getByName(String name) {
		return calendarRepository.findByName(name);
	}

	
	@Override
	public List<Holiday> getGeneralHolidays() {
		return null;
	}

	@Override
	public List<Holiday> getOptionalHolidays() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteHoliday(Long holidayId) {
		calendarRepository.deleteById(holidayId);
		return "Deleted Successfully";
	}

	@Override
	public List<Holiday> findByRegionId(Long regionId) {
		
		return calendarRepository.findByRegion(regionId);
	}

	@Override
	public List<Holiday> findByTypeId(Long typeId) {
		// TODO Auto-generated method stub
		return calendarRepository.findByHolidayType(typeId);
	}

	
}
