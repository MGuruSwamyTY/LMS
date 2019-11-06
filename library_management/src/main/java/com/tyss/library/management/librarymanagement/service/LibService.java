package com.tyss.library.management.librarymanagement.service;

import java.util.List;

import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;

public interface LibService {

	UserInfo login(String email, String password);

	boolean addBook(BooksInventory booksInventory);

	boolean deleteBook(int bid);

	boolean updateBook(BooksInventory booksInventory);

	List<BooksInventory> getAllBook();

	boolean fine(UserInfo userfine);

}
