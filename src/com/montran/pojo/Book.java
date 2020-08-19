package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="book_master")
public class Book {
    
   @Id
   @Column(name="book_code")
   private int bookCode;
   
   @Column(name="book_author")
   private String bookAuthor;
   
   @Column(name="book_title")
   private String bookTitle;
 
   @Column(name="book_availability")
   private String bookAvailability;

public Book() {
	
}

public Book(int bookCode, String bookAuthor, String bookTitle, String bookAvailability) {
	super();
	this.bookCode = bookCode;
	this.bookAuthor = bookAuthor;
	this.bookTitle = bookTitle;
	this.bookAvailability = bookAvailability;
}

public int getBookCode() {
	return bookCode;
}

public void setBookCode(int bookCode) {
	this.bookCode = bookCode;
}

public String getBookAuthor() {
	return bookAuthor;
}

public void setBookAuthor(String bookAuthor) {
	this.bookAuthor = bookAuthor;
}

public String getBookTitle() {
	return bookTitle;
}

public void setBookTitle(String bookTitle) {
	this.bookTitle = bookTitle;
}

public String getBookAvailability() {
	return bookAvailability;
}

public void setBookAvailability(String bookAvailability) {
	this.bookAvailability = bookAvailability;
}
   
   
   

   
}
