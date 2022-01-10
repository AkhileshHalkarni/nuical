package com.nous.app.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.nous.app.model.Region;


	public interface RegionRepository extends CrudRepository<Region, Long>{

		public List<Region> findByRegionName(String regionName);
		public List<Region> findByRegionId(Long regionId);


		
	}
		


	
