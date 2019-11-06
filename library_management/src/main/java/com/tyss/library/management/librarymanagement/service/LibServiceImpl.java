package com.tyss.library.management.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.library.management.librarymanagement.dao.Libimpl;
import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;

@Service
public class LibServiceImpl implements LibService {
	@Autowired
	private Libimpl lib;

	@Override
	public UserInfo login(String email, String password) {
		return lib.login(email, password);
	}

	@Override
	public boolean addBook(BooksInventory booksInventory) {
		return lib.addBook(booksInventory);
	}

	@Override
	public boolean deleteBook(int bid) {
		return lib.deleteBook(bid);
	}

	@Override
	public boolean updateBook(BooksInventory booksInventory) {
		return lib.updateBook(booksInventory);
	}

	@Override
	public List<BooksInventory> getAllBook() {
		return lib.getAllBook();
	}

	@Override
	public boolean fine(UserInfo userfine) {
		
		return lib.fine(userfine);
	}



}
