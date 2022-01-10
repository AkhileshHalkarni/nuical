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
import org.springframework.web.bind.annotation.RestController;

import com.nous.app.model.Region;
import com.nous.app.services.RegionService;

@RestController
@RequestMapping("regions")
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {

	@Autowired
	RegionService regionService;

	@GetMapping
	public ResponseEntity<List<Region>> getRegions() {
		ResponseEntity<List<Region>> responseEntity = null;
		List<Region> region = regionService.getRegions();
		responseEntity = new ResponseEntity<List<Region>>(region, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping
	public String saveRegion(@RequestBody Region region) {
		System.out.println(region);

		return regionService.saveRegion(region);

	}

	@PutMapping
	public ResponseEntity<String> updateRegion(@RequestBody Region region) {
		System.out.println(region);
		ResponseEntity<String> responseEntity = null;
		String message = null;
		if (regionService.isRegionExists(region.getRegionId())) {
			message = regionService.updateRegion(region);
			if (message.equals("Region updated succcessfully")) {
				responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<String>(message, HttpStatus.NOT_ACCEPTABLE);
			}

		} else {
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
			message = "Region with id " + region.getRegionId() + "does not exist";
		}
		return responseEntity;
	}

	@DeleteMapping("/{regionId}")
	public ResponseEntity<String> deleteRegion(@PathVariable("regionId") Long regionId) {
		ResponseEntity<String> responseEntity = null;
		String message = null;
		if (regionService.isRegionExists(regionId)) {
			message = regionService.deleteRegion(regionId);
			responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
			message = "Region with id " + regionId + "does not exist";
		}
		return responseEntity;
	}



	@GetMapping("/{regionId}")
	public ResponseEntity<List<Region>> getRegions(@PathVariable("regionId") Long regionId) {
		ResponseEntity<List<Region>> responseEntity = null;
		List<Region> region = new ArrayList<Region>();
		System.out.println(regionId);

		region = regionService.getRegions(regionId);

		if (region.size() == 0) {
			responseEntity = new ResponseEntity<List<Region>>(region, HttpStatus.NO_CONTENT); // 200
		} else {
			responseEntity = new ResponseEntity<List<Region>>(region, HttpStatus.OK); // 204
		}
		return responseEntity;
	}

}
