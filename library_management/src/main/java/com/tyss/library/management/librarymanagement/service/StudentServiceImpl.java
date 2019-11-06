package com.tyss.library.management.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.library.management.librarymanagement.dao.StuImpl;
import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StuImpl std;
	
	
	@Override
	public UserInfo login(String email, String password) {
		return std.login(email, password);
	}

	@Override
	public List<BooksInventory> getAllBook() {
		return std.getAllBook();
	}

	@Override
	public BooksInventory sendRequest(String bname) {
		return std.sendRequest(bname);
	}

//	@Override
//	public BooksInventory searchBook(BooksInventory name) {
//		
//		return std.searchBook(name);
//	}

	@Override
	public UserInfo changepassword(String email, String password, String newpassword) {
		
		return std.changepassword(email, password, newpassword);
	}

}
