package com.tunehub.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PasswordResetToken {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String token;
	LocalDateTime expiryDateTime;
	@OneToOne
	Users user;
	public PasswordResetToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PasswordResetToken(int id, String token, LocalDateTime expiryDateTime, Users user) {
		super();
		this.id = id;
		this.token = token;
		this.expiryDateTime = expiryDateTime;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LocalDateTime getExpiryDateTime() {
		return expiryDateTime;
	}
	public void setExpiryDateTime(LocalDateTime expiryDateTime) {
		this.expiryDateTime = expiryDateTime;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "PasswordResetToken [id=" + id + ", token=" + token + ", expiryDateTime=" + expiryDateTime + ", user="
				+ user + "]";
	}
	
	
	
}
