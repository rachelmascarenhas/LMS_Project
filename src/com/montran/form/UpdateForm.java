package com.montran.form;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

public class UpdateForm extends ActionForm{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int issueSerialNo;
	private Date returnDate;
	
	public int getIssueSerialNo() {
		return issueSerialNo;
	}
	public void setIssueSerialNo(int issueSerialNo) {
		this.issueSerialNo = issueSerialNo;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
