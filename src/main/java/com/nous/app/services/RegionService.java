package com.nous.app.services;

import java.util.List;

import com.nous.app.model.Region;

public interface RegionService {

	public List<Region> getRegions();

	public List<Region> getRegionName(String regionName);

	public List<Region> getRegions(Long regionId);

	public boolean isRegionExists(Long regionId);

	public String updateRegion(Region region);

	public String deleteRegion(Long regionId);

	public String saveRegion(Region region);

}
