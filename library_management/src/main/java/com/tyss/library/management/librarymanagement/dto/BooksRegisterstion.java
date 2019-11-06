package com.tyss.library.management.librarymanagement.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class BooksRegisterstion {
	@Id
	@Column
private int registerationid;
	@Column
private int booksid;
	@Column
private int userid;
	@Column
private Date registrationDate;

}
