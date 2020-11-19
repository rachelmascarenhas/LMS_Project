package com.montran.form;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateF extends ActionForm{
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
	
	@Override
	 public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
			ActionErrors errors = new ActionErrors();                                        //Validation
			System.out.println("In validate ()");
			
				if(issueSerialNo!= 0)
					System.out.println("issue serial no is not zero");
				else {
					System.out.println("issue serial no is zero");
					errors.add("common.name.err", new ActionMessage("error.common.issueserailno.required"));
					System.out.println("Going to print errors");
				}
				
			
					if((getReturnDate().equals(""))||getReturnDate().equals("0")) {
						System.out.println("Return date value is either zero or empty");
					    errors.add("common.name.err", new ActionMessage("error.common.returndate.required"));
					    System.out.println("Going to print errors object");
					}    
			
			System.out.println(errors);
			return errors;
		}
}
