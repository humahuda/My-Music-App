package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tunehub.entities.Song;
import com.tunehub.entities.Users;
import com.tunehub.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{
	
	@Autowired
	UsersRepository repo;
	
//	@Autowired
//	JavaMailSender javaMailSender;
	
	@Override
	public String addUser(Users user)
	{
		repo.save(user);
		return "user is created and saved";
	}
	
	public boolean emailExists(String email) {
		
		if(repo.findByEmail(email) == null)
		{
			return false;
			
		}
		
		else
		{
			return true;
		}
				
	}

	public boolean userExist(String email)
	{
		Users user = repo.findByEmail(email);
		if(user == null)
		{
			return true;
		}
		
		else {
			return false;
		}
	}
	@Override
	public boolean validateUser(String email, String password) {
		Users user = repo.findByEmail(email);
		
		String db_password = user.getPassword();
		if(db_password.equals(password))		
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		return (repo.findByEmail(email).getRole());
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
		
	}
//
//	@Override
//	public String sendEmail(Users user) {
//		try {
//			String resetLink = generateResetToken(user);
//			SimpleMailMessage msg = new SimpleMailMessage();
//			msg.setFrom("humahuda473@gmail.com");
//			msg.setTo(user.getEmail());
//			
//			msg.setSubject("Welcome To My Tune Hub App");
//			msg.setText("Hello \n\n" + "Please Click on this link to reset your password :"+ resetLink+ ". \n\n" + "Regards \n" + "ABC");
//			
//			javaMailSender.send(msg);
//			
//			return "success";
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			return "error";
//		}
//		
//		
//	}
//
//	private String generateResetToken(Users user) {
//		
//		return null;
//	}

	
	
}
