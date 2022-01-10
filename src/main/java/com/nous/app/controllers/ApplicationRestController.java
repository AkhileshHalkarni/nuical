/**
 * 
 */
package com.nous.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nous.app.config.PropertiesConfig;
//import com.nous.app.services.CalendarService;

/**
 * @author mohanavelp
 *
 */
@RestController
@RequestMapping("/api")
public class ApplicationRestController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PropertiesConfig config;
	
//	@Autowired
//	private CalendarService calendarService;
	
	@RequestMapping("/wish/{name}")
	public String wishMyName(@PathVariable("name") String name) {
		System.out.println("Secondary properties file from config: " + config.getSecondaryFilePath());
		LOGGER.debug("Logged in with " + name);
		return "All the best " + name;
	}

	@RequestMapping("/admin/{name}")
	// @PreAuthorize("hasRole('ADMIN')")
	public String wishAdmmin(@PathVariable("name") String name) {
		LOGGER.debug("Logged in with " + name);
		return "Hello Admin " + name;
	}
	
	@RequestMapping("/restricted")
	// @PreAuthorize("hasAuthority('VIEW_AUTHORITY')")
	public String restrictedContent() {
		return "Only users with view authority is permitted.";
	}
	
//	@RequestMapping("/allHolidays")
//	public List<HolidayBean> fetchAllHolidays() {
//		return calendarService.fetchHolidays();
//	}
}
