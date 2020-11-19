package com.montran.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.LibraryDAO;

import com.montran.form.GetDetailsForm;
import com.montran.pojo.BookBorrow;


public class DeleteAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		GetDetailsForm getDetailsForm=(GetDetailsForm) form;
		LibraryDAO dao=new LibraryDAO();
		BookBorrow bookdetails=new BookBorrow();
		bookdetails=dao.checkBook(getDetailsForm.getIssueSerialNo());
		if(bookdetails==null) {
			return mapping.findForward("failure");
		}
		else {
			dao.deleteBook(bookdetails);
			return mapping.findForward("success");
		}
		
	}
}
