package com.tyss.library.management.librarymanagement.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.library.management.librarymanagement.dto.BookResponse;
import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;
import com.tyss.library.management.librarymanagement.dto.UserResponse;
import com.tyss.library.management.librarymanagement.service.LibServiceImpl;

@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
@RestController
@RequestMapping("library")
public class LibController {
	@Autowired
	private LibServiceImpl lib;
	@GetMapping(path="/login",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserInfo loginUser(@RequestParam("userName") String name,@RequestParam("password") String password){
		System.out.println("username..."+name);
		System.out.println("password...."+password);
		UserInfo user=lib.login(name, password);
		System.out.println("--------------------------");
		System.out.println("Username..:"+user.getName());
		System.out.println("UserPasword..:"+user.getPassword());
		System.out.println("UserEmail..:"+user.getEmail());
		return user;
	}

	@GetMapping(path="/getallbooks",produces=MediaType.APPLICATION_JSON_VALUE)
	public  BookResponse getAllBook(@RequestParam("name")String name) {
		List<BooksInventory> book=lib.getAllBook();
		BookResponse response=new BookResponse();
		if(book==null) {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data Found");
		}else
		{
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Data Found");
		}
		return response;
	}
	@PostMapping(path="/registerbook",produces=MediaType.APPLICATION_JSON_VALUE)
	public  BookResponse addBook(@RequestBody BooksInventory booksInventory ) {
		BookResponse response=new BookResponse();
		if(lib.addBook(booksInventory))
		{	
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Book added");

		}else
		{
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data Found");
		}
		return response;
	}
	@PutMapping(path="/modify",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public  BookResponse updateBook(@RequestBody BooksInventory book) {
		BookResponse response=new BookResponse();
		if(lib.updateBook(book)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Book Updated");
		}else
		{
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("no data modified");

		}
		return response;
	}
	@DeleteMapping(path="/remove/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
	public BookResponse deleteBook(@PathVariable("email")String email) {
		List<BooksInventory> user=lib.getAllBook();
		BookResponse response=new BookResponse();
		if(user==null) {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book Not Deleted");
		}else
		{
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Book Deleted");
			

		}
		return response;

	}

}
