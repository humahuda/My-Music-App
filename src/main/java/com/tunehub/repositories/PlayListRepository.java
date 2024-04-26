package com.tunehub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.entities.CustomerPlayList;
import com.tunehub.entities.PlayList;


public interface PlayListRepository extends JpaRepository<PlayList, Integer> {

	public void save(CustomerPlayList custplaylist);
	 

	
	

}
