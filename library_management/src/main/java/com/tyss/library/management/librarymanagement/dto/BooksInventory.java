package com.tyss.library.management.librarymanagement.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "book_info")
public class BooksInventory {
	@Id
	@Column(name = "book_id")
	@GeneratedValue
	private int bid;
	@Column(name = "book_name")
	private String name;
	@Column(name = "book_anthor")
	private String author;
	@Column(name = "book_Publisher")
	private String Publisher;
	@Column(name = "YOP")
	private Date yearOfPublication;

	
}
