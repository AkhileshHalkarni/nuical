package com.nous.app.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nous.app.model.Holiday;
//import com.nous.app.model.Calendar;
import com.nous.app.model.Region;
//import com.nous.app.services.CalendarService;
//import com.nous.app.services.CalendarService;
import com.nous.app.services.RegionService;


@RestController
@RequestMapping("regions")
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {
	
	@Autowired
	RegionService regionService;
	
	//@GetMapping("/getRegionByName/{regionName}")
	//public ResponseEntity<List<Region>>getRegion(@PathVariable("regionName")String regionName) {
	//ResponseEntity<List<Region>> responseEntity = null;
	//List<Region> region=RegionService.getRegionByName(regionName);
	//if(region.size()==0) {
	//responseEntity=new ResponseEntity<List<Region>>(region, HttpStatus.NO_CONTENT);
	//}
	//else {
	//responseEntity=new ResponseEntity<List<Region>>(region, HttpStatus.OK);
	//}
	//return responseEntity;
	//}
	
	@GetMapping
	public ResponseEntity<List<Region>> getRegions()
	{
		ResponseEntity <List<Region>> responseEntity = null;
		List<Region> region = regionService.getRegions();
		responseEntity = new ResponseEntity<List<Region>>(region, HttpStatus.OK);
		return responseEntity;
	}
	
	
//	@GetMapping("/{regionName}")
//	public ResponseEntity <List<Region>> getRegionName(@PathVariable("regionName") String regionName)
//	{
//		ResponseEntity <List<Region>> responseEntity = null;
//	    List<Region> region = new ArrayList<Region>();
//	    System.out.println(regionName);
//	 
//	    
//		region = regionService.getRegionName(regionName);
//		
//		if(region.size() == 0)
//		{	   
//			responseEntity = new ResponseEntity <List<Region>>(region,HttpStatus.NO_CONTENT); //200 
//		}
//		else
//			{
//				responseEntity = new ResponseEntity <List<Region>>(region,HttpStatus.OK); //204
//			}
//		return responseEntity;
//	}
	
	@GetMapping("/{regionId}")
	public ResponseEntity <List<Region>> getRegionId(@PathVariable("regionId") int regionId)
	{
		ResponseEntity <List<Region>> responseEntity = null;
	    List<Region> region = new ArrayList<Region>();
	    System.out.println(regionId);
	 
	    
		region = regionService.getRegionId(regionId);
		
		if(region.size() == 0)
		{	   
			responseEntity = new ResponseEntity <List<Region>>(region,HttpStatus.NO_CONTENT); //200 
		}
		else
			{
				responseEntity = new ResponseEntity <List<Region>>(region,HttpStatus.OK); //204
			}
		return responseEntity;
	}
	
	
	

}
