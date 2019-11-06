package com.tyss.library.management.librarymanagement.dao;

import java.util.List;

import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;


public interface AdminInterface {
	
	public boolean registerUser(UserInfo user, String to, String subject, String body);	 
	public boolean deleteUser(String email);
	 public boolean updateUser(UserInfo  user );
	 public List<BooksInventory>getAllBook();
	 public List<UserInfo>getAllUser();
	public UserInfo login(String email, String password);
//	public UserInfo searchuser(UserInfo user);
	

}
