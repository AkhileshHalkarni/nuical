package com.nous.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nous.app.model.Holiday;
import com.nous.app.model.Region;
import com.nous.app.repo.RegionRepository;

@Service
public class RegionServiceImplements  implements RegionService {
	
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
	public List<Region> getRegionId(int regionId) {
		// TODO Auto-generated method stub
		 return  regionRepository.findByRegionId(regionId);
	}
	
	

}
