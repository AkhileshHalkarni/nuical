package com.nous.app.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nous.app.model.Holiday;

public interface CalendarRepository extends CrudRepository<Holiday, Long>{

	public List<Holiday> findByName(String name);

	public String deleteByName(String name);

	

}
