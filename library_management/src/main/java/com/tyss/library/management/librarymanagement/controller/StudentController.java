package com.tyss.library.management.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.library.management.librarymanagement.dto.BookResponse;
import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;
import com.tyss.library.management.librarymanagement.dto.UserResponse;
import com.tyss.library.management.librarymanagement.service.StudentServiceImpl;

@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentServiceImpl std;
	@GetMapping(path="/login",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserInfo loginUser(@RequestParam("userName") String name,@RequestParam("password") String password){
		System.out.println("username..."+name);
		System.out.println("password...."+password);
		UserInfo user=std.login(name, password);
		System.out.println("--------------------------");
		System.out.println("Username..:"+user.getName());
		System.out.println("UserPasword..:"+user.getPassword());
		System.out.println("UserEmail..:"+user.getEmail());
		return user;
	}
	
	@GetMapping(path="/getallbooks",produces=MediaType.APPLICATION_JSON_VALUE)
	public  BookResponse getAllBook(@RequestParam("name")String name) {
		List<BooksInventory> book=std.getAllBook();
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
	

	@PutMapping(path="/changepwd",produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean changePassword(@RequestParam("email") String email,@RequestParam("password") String oldPassword,@RequestParam("newPassword") String newPassword) {
	UserInfo changepassword=std.changepassword(email, oldPassword, newPassword);
	UserResponse response=new UserResponse();
	if(changepassword!=null) {
		response.setStatusCode(200);
		response.setMessage("Success");
		response.setDescription("Data Found");	
	}
	else {
		response.setStatusCode(401);
		response.setMessage("Failure");
		response.setDescription("No data Found");
	}
		return false;
		
		
		
	}
	
	}

