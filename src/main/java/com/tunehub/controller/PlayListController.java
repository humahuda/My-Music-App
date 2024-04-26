package com.tunehub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.entities.CustomerPlayList;
import com.tunehub.entities.PlayList;
import com.tunehub.entities.Song;
import com.tunehub.entities.Users;
import com.tunehub.services.PlayListService;
import com.tunehub.services.SongService;
import com.tunehub.services.UsersService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin("*")
@Controller
public class PlayListController {
	
	//connecting of PlayListService class
	@Autowired
	PlayListService playService;
	
	//connecting of SongService class
	@Autowired
	SongService songS;
	
	@Autowired
	UsersService userS;

	//mapping of createplaylist from
@GetMapping("/createplaylist")
public String createPlayList(Model model)
{
	//fetch the data from database using song service and store in the variable as a list
	List<Song> songList = songS .getAllSongs();
	
	//adding the songs in the model 
	model.addAttribute("songList", songList);
	
	//this method return create playlist form
	return "createplaylist";
}

//mapping of addplaylist
@PostMapping("/addplaylist")
public String addPlayList(@ModelAttribute PlayList playlist ) {
	//adding playlist
	playService.addPlayList(playlist);

	List<Song> songsList= playlist.getSong();
	for(Song song : songsList) {
		song.getPlayList().add(playlist);
		songS.updateSong(song);
	}
	
	return "playlistsuccess";
}


@GetMapping("/viewPlaylist")
public String viewPlaylists(Model model) {
	List<PlayList> plist= playService.getAllSongs();
//	System.out.println(plist);
	model.addAttribute("plist", plist);
	return "viewPlaylist";
}

@GetMapping("/viewcusplaylist")
public String viewCusPlaylist(HttpSession session, Model model) {
	
		String email = (String) session.getAttribute("email");
		
		Users user = userS.getUser(email);
		
		boolean userStatus = user.isPremium();
		if(userStatus == true) {
			List<PlayList> plist= playService.getAllSongs();

			model.addAttribute("plist", plist);
			return "customerviewPlaylist";
		}
		else {
			return "makepayment";
		}
}


@GetMapping("/crCustPlayList")
public String createCusPlayList(Model model)
{
	//fetch the data from database using song service and store in the variable as a list
	List<Song> cusplayList =  songS.getAllSongs();
	System.out.println(cusplayList);
	//adding the songs in the model 
	model.addAttribute("cusplayList", cusplayList);
	
	//this method return create playlist form
	return "createcustplaylist";
}


//mapping of addplaylist
@PostMapping("/addcustplaylist")
public String addCustPlayList(@ModelAttribute CustomerPlayList custplaylist, HttpSession session, Model model) {
	//adding playlist
	
	String userEmail = (String) session.getAttribute("email");
	Users users = userS.getUser(userEmail);
	
	custplaylist.setUser(users);
	
	
	
	playService.addCustPlayList(custplaylist);
	
	//update song table
	
	List<Song> songsList= custplaylist.getSongs();
	for(Song songs : songsList) {
		songs.getCustPlayList().add(custplaylist);
		songS.updateSongs(songs);
	}
	
	List<CustomerPlayList> customerPlayLists = users.getCusP();
	customerPlayLists.add(custplaylist);
	users.setAddress(userEmail);
	userS.updateUser(users);
	
	return "playlistsuccess";
}


@GetMapping("/viewCustomerPlayList")
public String viewPlaylistCust(Model model, HttpSession session) {
	
	String userEmail = (String) session.getAttribute("email");
	Users users = userS.getUser(userEmail);
	
	List<CustomerPlayList> plist= users.getCusP();
	
//	System.out.println(plist);
	model.addAttribute("plist", plist);
	return "customerplaylist";
}

@GetMapping("/viewPlayListAdmin")
public String viewPlaylistAdmin(Model model, @RequestParam String email) {
	
		Users users = userS.getUser(email);
	
	List<CustomerPlayList> plist= users.getCusP();
	
//	System.out.println(plist);
	model.addAttribute("plist", plist);
	return "customerplaylist";
}

}

