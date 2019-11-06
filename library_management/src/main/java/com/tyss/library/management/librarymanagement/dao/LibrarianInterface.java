package com.tyss.library.management.librarymanagement.dao;

import java.util.List;

import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;

public interface LibrarianInterface {
	// public BookInfo searchBook(int bid);
	 public UserInfo login(String email, String password);
	 public  boolean addBook(BooksInventory  booksInventory );
	 public boolean deleteBook(int bid);
	 public  boolean updateBook(BooksInventory booksInventory);
	 public List<BooksInventory>getAllBook();
	 public boolean fine(UserInfo userfine);
	 boolean returnBook(int bid);
	List<BooksInventory> getIssueBookList(int userId);
	BooksInventory acceptBookRequest(int userId, int bookId);
}
