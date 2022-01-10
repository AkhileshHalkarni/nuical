package com.nous.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nous.app.model.Region;
import com.nous.app.repo.RegionRepository;
import com.nous.app.services.RegionService;

@Service
public class RegionServiceImpl  implements RegionService {
	
	@Autowired
	RegionRepository regionRepository;

	@Override
	public List<Region> getRegionName(String regionName) {
		// TODO Auto-generated method stub
		return regionRepository.findByRegionName(regionName);
	}

	@Override
	public List<Region> getRegions() {
		List <Region> regions=new ArrayList<Region>();
		for(Region region: regionRepository.findAll()) {
			regions.add(region);
		}
		return regions;
	}

	@Override
	public List<Region> getRegions(Long regionId) {
		// TODO Auto-generated method stub
		 return  regionRepository.findByRegionId(regionId);
	}

	

	@Override
	public String saveRegion(Region region) {
		// TODO Auto-generated method stub

		regionRepository.save(region);
		return "saved region";
	}

	@Override
	public String updateRegion(Region region) {
		// TODO Auto-generated method stub

		regionRepository.save(region);
		return "update region";
	}

	@Override
	public String deleteRegion(Long regionId) {
		// TODO Auto-generated method stub
		regionRepository.deleteById(regionId);
		return "Deleted succesfully";
	}

	@Override
	public boolean isRegionExists(Long regionId) {
		// TODO Auto-generated method stub
		Optional<Region>region=regionRepository.findById(regionId);
		return region.isPresent();
	}
	
	

}
