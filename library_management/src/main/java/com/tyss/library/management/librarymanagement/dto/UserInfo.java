package com.tyss.library.management.librarymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "users_info")
public class UserInfo {

	@Column(name = "user_id")
	@GeneratedValue
	private int id;
	@Column(name = "user_name")
	private String name;
	@Id
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_password")
	private String password;
	@Column(name = "librarian")
	private boolean librarian;

	
}
