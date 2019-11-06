package com.tyss.library.management.librarymanagement.dao;

import java.util.List;

import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;

public interface StudentInterface {

	public UserInfo login(String email, String password);
	public List<BooksInventory>getAllBook();
	public  BooksInventory sendRequest(String name);
	//public  BooksInventory searchBook(BooksInventory name);
	public UserInfo changepassword(String email,String password,String newpassword);
}
