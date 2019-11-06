package com.tyss.library.management.librarymanagement.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Table
@Entity
public class BooksTransaction {
	@Id
	@Column
	private int trancactionid;
	@Column
	private int fine;
	@Column
	private String name;
	@Column
	private Date issueDate;
	@Column
	private Date returnDate;
	@Column
	private int registertionid;

}
