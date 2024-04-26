package com.tunehub.services;

import java.util.List;

import com.tunehub.entities.CustomerPlayList;
import com.tunehub.entities.PlayList;

public interface PlayListService {

	public void addPlayList(PlayList playlist);
	
	public List<PlayList> getAllSongs();
	public List<CustomerPlayList> getAllCustSongs();

	public void addCustPlayList(CustomerPlayList custplaylist);
	
}
