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
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nous.app.model.Holiday;
import com.nous.app.model.Region;
import com.nous.app.services.CalendarService;
import com.nous.app.services.RegionService;

@RestController
@RequestMapping("holidays")
@CrossOrigin(origins = "http://localhost:4200")

public class CalendarController {

	@Autowired
	CalendarService calendarService;

//	@GetMapping
//	public ResponseEntity<List<Calendar>> getHolidays()
//	{
//		ResponseEntity <List<Calendar>> responseEntity = null;
//		List<Calendar> calendar = calendarService.getHolidays();
//		responseEntity = new ResponseEntity<List<Calendar>>(calendar, HttpStatus.OK);
//		return responseEntity;
//	}

	@PostMapping
	public ResponseEntity<String> saveHoliday(@RequestBody Holiday calendar) {
		ResponseEntity<String> responseEntity = null;
		String holiday = calendarService.saveHoliday(calendar);
		responseEntity = new ResponseEntity<String>(holiday, HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping
	public ResponseEntity<String> updateHoliday(@RequestBody Holiday calendar) {
		ResponseEntity<String> responseEntity = null;
		System.out.println(calendar);
		String success = null;
		if (calendarService.isHolidayExists(calendar.getName())) {
			success = calendarService.updateHoliday(calendar);
			if (success.equals("Updated successfully..!!")) {
				responseEntity = new ResponseEntity<String>(success, HttpStatus.OK); // 200
			} else {
				responseEntity = new ResponseEntity<String>(success, HttpStatus.NOT_ACCEPTABLE); // 406
			}
		} else {
			responseEntity = new ResponseEntity<String>(success, HttpStatus.NO_CONTENT); // 204
			success = "Holiday for " + calendar.getName() + " does not exists...";
		}
		return responseEntity;
	}

	// code to delete
	@DeleteMapping("/{name}")
	public ResponseEntity<String> deleteHoliday(@PathVariable("name") String name) {
		ResponseEntity<String> responseEntity = null;
		calendarService.deleteHoliday(name);
		responseEntity = new ResponseEntity<String>("deleted successfully", HttpStatus.NO_CONTENT); // 204
		return responseEntity;
	}

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
		List<Holiday> calendar = calendarService.getHolidays();
		responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/Optionalholidays")
	public ResponseEntity<List<Holiday>> getOptionalHolidays() {
		ResponseEntity<List<Holiday>> responseEntity = null;
		List<Holiday> calendar = calendarService.getGeneralHolidays();
		responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/{regionName}")
	public ResponseEntity<List<Holiday>> getRegion(@PathVariable("regionName") String regionName) {
		ResponseEntity<List<Holiday>> responseEntity = null;
		List<Holiday> calendar = new ArrayList<Holiday>();
		
		//calendar = calendarService.getregionByName(regionName);
		
		if (calendar.size() == 0) {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.NO_CONTENT); // 200
		} else {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.OK); // 204
		}
		return responseEntity;
	}
	
	@GetMapping
	public ResponseEntity<List<Holiday>> getRegions(@RequestParam(required = false) String regionName){
		ResponseEntity<List<Holiday>> responseEntity = null;
		List<Holiday> calendar = new ArrayList<Holiday>();
		
		if (regionName == null) {
			System.out.println(regionName);
			calendar = calendarService.getHolidays();
		} else {
			System.out.println(regionName);
			//calendar = calendarService.getregionByName(regionName);
		}
		
		
		if (calendar.size() == 0) {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.NO_CONTENT); // 200
		} else {
			responseEntity = new ResponseEntity<List<Holiday>>(calendar, HttpStatus.OK); // 204
		}
		return responseEntity;
	}

}
