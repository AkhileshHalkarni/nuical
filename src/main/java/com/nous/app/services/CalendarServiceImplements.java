package com.nous.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nous.app.model.Holiday;
import com.nous.app.repo.CalendarRepository;

@Service
public class CalendarServiceImplements implements CalendarService {
	
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
	public String deleteHoliday(String name) {
		calendarRepository.deleteByName(name);
		return "Deleted successfully..!!";
	}

	@Override
	public boolean isHolidayExists(String name) {
		List<Holiday> calendar = calendarRepository.findByName(name);
		Holiday cal = calendar.get(0);
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

	
}
