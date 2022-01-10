/**
 * 
 */
package com.nous.app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nous.app.services.dto.HolidayBean;

/**
 * @author mohanavelp
 *
 */
@Component
public class CalendarDAO {

	public List<HolidayBean> fetchHolidays() {
		List<HolidayBean> holidays = new ArrayList<>();
		holidays.add(createHoliday("New Year Eve", new Date(), "New Year Eve"));
		holidays.add(createHoliday("Kannada Rajyotsava", new Date(), "Kannada Rajyotsava"));
		return holidays;
	}
	
	private HolidayBean createHoliday(String name, Date date, String shortDescription) {
		HolidayBean bean = new HolidayBean();
		bean.setName(name);
		bean.setDate(date);
		bean.setDescription(shortDescription);
		return bean;
	}

	
	
}
