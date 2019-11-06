package com.tyss.library.management.librarymanagement.service;

import java.util.List;

import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;

public interface AdminService {
	// public boolean registerUser(UserInfo user);
	 public boolean deleteUser(String email);
	 public boolean updateUser(UserInfo  user );
	 public List<BooksInventory>getAllBook();
	 public List<UserInfo>getAllUser();
	public UserInfo login(String email, String password);
	//public UserInfo searchUser(String email);
	public boolean registerUser(UserInfo user, String to, String subject, String body);
	//public boolean registeruser(UserInfo user);
}
