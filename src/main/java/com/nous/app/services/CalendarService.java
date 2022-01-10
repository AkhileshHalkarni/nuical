/**
 * 
 */
package com.nous.app.services;

import java.util.List;

import com.nous.app.model.Holiday;



public interface CalendarService {

	public List<Holiday> getHolidays();

	public String saveHoliday(Holiday calendar);
	
	public String updateHoliday(Holiday calendar);

	public List<Holiday> findByName(String name);

	public String deleteHoliday(String name);

	public boolean isHolidayExists(String name);

	public List<Holiday> getByName(String name);

	public List<Holiday> getGeneralHolidays();
	
	public List<Holiday> getOptionalHolidays();
	
	


	


}
