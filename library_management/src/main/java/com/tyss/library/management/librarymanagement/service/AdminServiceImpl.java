package com.tyss.library.management.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.library.management.librarymanagement.dao.AdminImpl;
import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminImpl admin;
	@Override
	public boolean registerUser(UserInfo user, String to, String subject, String body) {
		return admin.registerUser(user,to,subject,body);
	}

	@Override
	public boolean deleteUser(String email) {
		return admin.deleteUser(email);
	}

	@Override
	public boolean updateUser(UserInfo user) {
		return admin.updateUser(user);
	}

	@Override
	public List<BooksInventory> getAllBook() {
		return admin.getAllBook();
	}

	@Override
	public List<UserInfo> getAllUser() {
		return admin.getAllUser();
	}

	@Override
	public UserInfo login(String email, String password) {
		return admin.login(email, password);
	}

//	@Override
//	public UserInfo searchUser(String email) {
//		return admin.searchuser(email);
//	}

}
