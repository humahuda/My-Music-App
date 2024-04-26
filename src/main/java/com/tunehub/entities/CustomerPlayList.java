package com.tunehub.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class CustomerPlayList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String playListName;
	
	@ManyToMany
	List<Song> songs;
	
	@ManyToOne
	Users user;

	public CustomerPlayList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerPlayList(int id, String playListName, List<Song> songs, Users user) {
		super();
		this.id = id;
		this.playListName = playListName;
		this.songs = songs;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayListName() {
		return playListName;
	}

	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CustomerPlayList [id=" + id + ", playListName=" + playListName + ", songs=" + songs + ", user=" + user
				+ "]";
	}

		
	

	
	
}
