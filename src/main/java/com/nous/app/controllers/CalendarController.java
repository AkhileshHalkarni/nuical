package com.nous.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nous.app.model.Holiday;
import com.nous.app.services.CalendarService;

@RestController
@RequestMapping("holidays")
@CrossOrigin(origins = "http://localhost:4200")

public class CalendarController {

	@Autowired
	CalendarService calendarService;

	@PostMapping
	public ResponseEntity<String> saveHoliday(@RequestBody Holiday calendar) {
		ResponseEntity<String> responseEntity = null;
		String holiday = calendarService.saveHoliday(calendar);
		responseEntity = new ResponseEntity<String>(holiday, HttpStatus.OK);
		return responseEntity;
	}

	// code to delete

	@GetMapping("/ByName/{name}")
	public ResponseEntity<List<Holiday>> getHolidays(@PathVariable("name") String name) {
		ResponseEntity<List<Holiday>> responseEntity = null;
		List<Holiday> calendar = new ArrayList<Holiday>();
		System.out.println(name);
		if (name == null) {
			calendar = calendarService.getHolidays();
		} else {
			calendar = calendarService.getByName(name);
		}
		if (calendar.size() == 0) {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.NO_CONTENT); // 200
		} else {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.OK); // 204
		}
		return responseEntity;
	}

	@GetMapping("/Generalholidays")
	public ResponseEntity<List<Holiday>> getGeneralHolidays() {
		ResponseEntity<List<Holiday>> responseEntity = null;
		List<Holiday> calendar = calendarService.findByTypeId(1L);
		
		responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/Optionalholidays")
	public ResponseEntity<List<Holiday>> getOptionalHolidays() {
		ResponseEntity<List<Holiday>> responseEntity = null;
		List<Holiday> calendar = calendarService.findByTypeId(2L);
		responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/{regionName}")
	public ResponseEntity<List<Holiday>> getRegion(@PathVariable("regionName") String regionName) {
		ResponseEntity<List<Holiday>> responseEntity = null;
		List<Holiday> calendar = new ArrayList<Holiday>();

		// calendar = calendarService.getregionByName(regionName);

		if (calendar.size() == 0) {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.NO_CONTENT); // 200
		} else {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.OK); // 204
		}
		return responseEntity;
	}
	
	@GetMapping("/region/{regionId}")
	public ResponseEntity<List<Holiday>> getRegion(@PathVariable("regionId") Long regionId) {
		ResponseEntity<List<Holiday>> responseEntity = null;
		List<Holiday> calendar = new ArrayList<Holiday>();

		calendar = calendarService.findByRegionId(regionId);

		if (calendar.size() == 0) {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.NO_CONTENT); // 200
		} else {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.OK); // 204
		}
		return responseEntity;
	}

	@GetMapping("/type/{typeId}")
	public ResponseEntity<List<Holiday>> getByType(@PathVariable("typeId") Long typeId) {
		ResponseEntity<List<Holiday>> responseEntity = null;
		List<Holiday> calendar = new ArrayList<Holiday>();

		calendar = calendarService.findByTypeId(typeId);

		if (calendar.size() == 0) {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.NO_CONTENT); // 200
		} else {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.OK); // 204
		}
		return responseEntity;
	}
	@GetMapping
	public ResponseEntity<List<Holiday>> getRegions() {
		ResponseEntity<List<Holiday>> responseEntity = null;
		List<Holiday> calendar = new ArrayList<Holiday>();
		calendar = calendarService.getHolidays();
		if (calendar.size() == 0) {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.NO_CONTENT); // 200
		} else {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.OK); // 204
		}
		return responseEntity;
	}



	@PutMapping
	public ResponseEntity<String> updateCalender(@RequestBody Holiday calender) {
		System.out.println(calender);
		ResponseEntity<String> responseEntity = null;
		String message = null;
		if (calendarService.isHolidayExists(calender.getHolidayId())) {
			message = calendarService.updateHoliday(calender);
			if (message.equals("Calender updated succcessfully")) {
				responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<String>(message, HttpStatus.NOT_ACCEPTABLE);
			}

		} else {
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
			message = "Holiday with id " + calender.getHolidayId() + "does not exist";
		}
		return responseEntity;
	}

	@DeleteMapping("/{holidayId}")
	public ResponseEntity<String> deleteCalender(@PathVariable("holidayId") Long holidayId) {
		ResponseEntity<String> responseEntity = null;
		String message = null;
		if (calendarService.isHolidayExists(holidayId)) {
			message = calendarService.deleteHoliday(holidayId);
			responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
			message = "Holiday with id " + holidayId + "does not exist";
		}
		return responseEntity;
	}

	@GetMapping("/{slno}")
	public List<Holiday> isCalenExists(@PathVariable("holidayId") int holidayId) {
		return calendarService.getHolidays();
	}

}
