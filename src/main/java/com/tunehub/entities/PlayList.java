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
public class PlayList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String playListName;
	
	@ManyToMany
	List<Song> song;
	
	@ManyToOne
	Users user;

	public PlayList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayList(int id, String playListName, List<Song> song, Users user) {
		super();
		this.id = id;
		this.playListName = playListName;
		this.song = song;
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

	public List<Song> getSong() {
		return song;
	}

	public void setSong(List<Song> song) {
		this.song = song;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PlayList [id=" + id + ", playListName=" + playListName + ", song=" + song + ", user=" + user + "]";
	}


	
}
