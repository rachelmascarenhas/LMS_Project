package com.montran.pojo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="book_borrow_master")
public class BookBorrow {
   
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   @Column(name="issue_serial_no")
   private int issueSerialNo;
   
   @Column(name="issue_date")
   private Date issueDate;
   
   @Column(name="return_date")
   private Date returnDate;
   
   @OneToOne
   @JoinColumn(name="book_code")
   private Book book;
   
   @OneToOne
   @JoinColumn(name="member_code")
   private Member member;

   
   
   
public BookBorrow() {
	super();
}

public BookBorrow(int issueSerialNo, Date issueDate, Date returnDate, Book book, Member member) {
	super();
	this.issueSerialNo = issueSerialNo;
	this.issueDate = issueDate;
	this.returnDate = returnDate;
	this.book = book;
	this.member = member;
}

public int getIssueSerialNo() {
	return issueSerialNo;
}

public void setIssueSerialNo(int issueSerialNo) {
	this.issueSerialNo = issueSerialNo;
}

public Date getIssueDate() {
	return issueDate;
}

public void setIssueDate(Date issueDate) {
	this.issueDate = issueDate;
}



public Date getReturnDate() {
	return returnDate;
}

public void setReturnDate(Date returnDate) {
	this.returnDate = returnDate;
}

public Book getBook() {
	return book;
}

public void setBook(Book book) {
	this.book = book;
}

public Member getMember() {
	return member;
}

public void setMember(Member member) {
	this.member = member;
}

@Override
public String toString() {
	return "BookBorrow [issueSerialNo=" + issueSerialNo + ", issueDate=" + issueDate + ", returnDate=" + returnDate
			+ ", book=" + book + ", member=" + member + "]";
}

   
   

   
}
