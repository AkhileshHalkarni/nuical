package com.nous.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nous.app.model.Holiday;
import com.nous.app.model.HolidayTypes;
import com.nous.app.services.HolidayTypeService;

@RestController
@RequestMapping("TypesOfHoliday")
@CrossOrigin(origins = "http://localhost:4200")

public class HolidayTypeController {
	
	@Autowired
	HolidayTypeService holidayTypeService;
	
	
	@GetMapping
	public ResponseEntity<List<HolidayTypes>> getTypesOfHolidays()
{
		ResponseEntity <List<HolidayTypes>> responseEntity = null;
		List<HolidayTypes>typesOfHoliday  = holidayTypeService.getTypesOfHolidays();
		responseEntity = new ResponseEntity<List<HolidayTypes>>(typesOfHoliday, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/{holidayTypeId}")
	public ResponseEntity <List<HolidayTypes>> getHolidayTypeId(@PathVariable("holidayTypeId") int holidayTypeId)
	{
		ResponseEntity <List<HolidayTypes>> responseEntity = null;
	    List<HolidayTypes> typesOfHoliday = new ArrayList<HolidayTypes>();
	    System.out.println(holidayTypeId);
	 
	    
	    typesOfHoliday = holidayTypeService.getHolidayTypeId(holidayTypeId);
		
		if( typesOfHoliday.size() == 0)
		{	   
			responseEntity = new ResponseEntity <List<HolidayTypes >>(typesOfHoliday ,HttpStatus.NO_CONTENT); //200 
		}
		else
			{
				responseEntity = new ResponseEntity <List<HolidayTypes >>(typesOfHoliday ,HttpStatus.OK); //204
			}
		return responseEntity;
	}
//	
//	@GetMapping("/{holidayTypeName}")
//	public ResponseEntity<List<TypesOfHoliday>> getHolidayTypeName(@PathVariable("holidayTypeName") String holidayTypeName) {
//		ResponseEntity<List<TypesOfHoliday>> responseEntity = null;
//		List<TypesOfHoliday> typesOfHoliday = new ArrayList<TypesOfHoliday>();
//		
//		typesOfHoliday = holidayTypeService.getHolidayTypeName(holidayTypeName);
//
//		
//		if (typesOfHoliday.size() == 0) {
//			responseEntity = new ResponseEntity<List<TypesOfHoliday>>(typesOfHoliday, HttpStatus.NO_CONTENT); // 200
//		} 
//		else {
//			responseEntity = new ResponseEntity<List<TypesOfHoliday>>(typesOfHoliday, HttpStatus.OK); // 204
//		}
//		return responseEntity;
//	}
//	
//	@GetMapping
//	public ResponseEntity<List<TypesOfHoliday>> getTypesOfHolidays(@RequestParam(required = false) String holidayTypeName){
//		ResponseEntity<List<TypesOfHoliday>> responseEntity = null;
//		List<TypesOfHoliday> typesOfHoliday = new ArrayList<TypesOfHoliday>();
//		
//		if (holidayTypeName == null) {
//			System.out.println(holidayTypeName);
//			typesOfHoliday = holidayTypeService.getTypesOfHolidays();
//		} else {
//			System.out.println(holidayTypeName);
//			typesOfHoliday = holidayTypeService.getHolidayTypeName(holidayTypeName);
//		}
//		
//		
//		if (typesOfHoliday.size() == 0) {
//			responseEntity = new ResponseEntity<List<TypesOfHoliday>>(typesOfHoliday, HttpStatus.NO_CONTENT); // 200
//		} else {
//			responseEntity = new ResponseEntity<List<TypesOfHoliday>>(typesOfHoliday, HttpStatus.OK); // 204
//		}
//		return responseEntity;
//	}
	

	
	
	

}
