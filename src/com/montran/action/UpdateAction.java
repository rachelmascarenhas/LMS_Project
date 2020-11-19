package com.montran.action;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.LibraryDAO;
import com.montran.form.UpdateForm;
import com.montran.pojo.Book;
import com.montran.pojo.BookBorrow;

public class UpdateAction extends Action {
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			        throws Exception {
		
		LibraryDAO dao=new LibraryDAO(); 
		UpdateForm updateForm = (UpdateForm) form;
			
		if(request.getParameter("UpdateButton")!=null)
	        {
	        	if(request.getParameter("UpdateButton").equals("Update")) {
	        		System.out.println(" Update button clicked");
	        		BookBorrow bookdetails=new BookBorrow();
	        		bookdetails=dao.checkBook(updateForm.getIssueSerialNo());
	        		if(bookdetails==null) {
	        			return mapping.findForward("failure");
	        		}
	        		else {
	        			bookdetails.setReturnDate(updateForm.getReturnDate());
	        			dao.updateBook(bookdetails);
	        			return mapping.findForward("success");
	        		}
	            
	        	}
	        }
		
	        return mapping.findForward("success");
	}
}
