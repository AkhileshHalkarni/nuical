package com.nous.app.services;

import java.util.List;

import com.nous.app.model.Region;

public interface RegionService {
	
	public List<Region> getRegions();


	public List<Region> getRegionName(String regionName);
	public List<Region> getRegionId(int regionId);

}
