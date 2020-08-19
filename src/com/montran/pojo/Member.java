package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="member_master")
public class Member {
	
   @Id
   @Column(name="member_code")
   private int memberCode;
   
   @Column(name="member_type")
   private String memberType;
   
   @Column(name="member_name")
   private String memberName;
   
   @Column(name="no_of_books_issued")
   private int noOfBooksIssued;

   
   
public Member() {
	super();
}



public Member(int memberCode, String memberType, String memberName, int noOfBooksIssued) {
	super();
	this.memberCode = memberCode;
	this.memberType = memberType;
	this.memberName = memberName;
	this.noOfBooksIssued = noOfBooksIssued;
}



public int getMemberCode() {
	return memberCode;
}



public void setMemberCode(int memberCode) {
	this.memberCode = memberCode;
}



public String getMemberType() {
	return memberType;
}



public void setMemberType(String memberType) {
	this.memberType = memberType;
}



public String getMemberName() {
	return memberName;
}



public void setMemberName(String memberName) {
	this.memberName = memberName;
}



public int getNoOfBooksIssued() {
	return noOfBooksIssued;
}



public void setNoOfBooksIssued(int noOfBooksIssued) {
	this.noOfBooksIssued = noOfBooksIssued;
}



@Override
public String toString() {
	return "Member [memberCode=" + memberCode + ", memberType=" + memberType + ", memberName=" + memberName
			+ ", noOfBooksIssued=" + noOfBooksIssued + "]";
}
   
   
   
    
}
