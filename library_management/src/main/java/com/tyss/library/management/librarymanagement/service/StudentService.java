package com.tyss.library.management.librarymanagement.service;

import java.util.List;

import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;

public interface StudentService {
	public UserInfo login(String email, String password);
	public List<BooksInventory>getAllBook();
	public  BooksInventory sendRequest(String bname);
	//public  BooksInventory searchBook(BooksInventory name);
	public UserInfo changepassword(String email,String password,String newpassword);

}
