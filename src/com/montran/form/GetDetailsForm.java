package com.montran.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.montran.dao.LibraryDAO;
import com.montran.pojo.Book;
import com.montran.pojo.Member;
import com.montran.pojo.BookBorrow;

public class GetDetailsForm extends ActionForm{
	 private int memberCode;
	 private String memberName;
	 private int bookCode;
	 private String bookAuthor;
	 private String bookTitle;
	 private int issueSerialNo;
	 private String issueDate;
	 private String returnDate;
      
	 @Override
	 public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
			ActionErrors errors = new ActionErrors();                                                          //Validation
			if (getMemberCode()<1) {
				errors.add("common.name.err", new ActionMessage("error.common.membercode.required"));
			}
			if (getBookCode()!=0) {
				errors.add("common.name.err", new ActionMessage("error.common.bookcode.required"));
			}		
			return errors;
		}

	 
	public int getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public int getIssueSerialNo() {
		return issueSerialNo;
	}
	public void setIssueSerialNo(int issueSerialNo) {
		this.issueSerialNo = issueSerialNo;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	
}
