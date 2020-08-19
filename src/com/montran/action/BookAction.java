package com.montran.action;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.montran.dao.LibraryDAO;
import com.montran.form.GetDetailsForm; 
import com.montran.pojo.Book;
import com.montran.pojo.BookBorrow;
import com.montran.pojo.Member;

public class BookAction extends Action {
	 
     public ActionForward execute(ActionMapping mapping,ActionForm form,
    			HttpServletRequest request,HttpServletResponse response)
    			        throws Exception {
    	 
    	 GetDetailsForm getDetailsForm=(GetDetailsForm) form;
    	 LibraryDAO dao=new LibraryDAO(); 
    	 BookBorrow borrowDetails=null;
    	 Book book=null;
    	 Member member=null;
    	 
    	 if(request.getParameter("member")!=null) {
    	   if(request.getParameter("member").equals("getMember")) {
    		 System.out.println("Get member button clicked");
    		 System.out.println(getDetailsForm.getMemberCode());
    		 member=dao.getMemberName(getDetailsForm.getMemberCode());
    		 getDetailsForm.setMemberName(member.getMemberName());
    		 return mapping.findForward("book");
    		
    	}
    	 }
    	 
    	 
    	if(request.getParameter("book")!=null) {
          if(request.getParameter("book").equals("getBook")) {
        	System.out.println("Get book button clicked");
        	System.out.println(getDetailsForm.getBookCode());
        	book=dao.getBookName(getDetailsForm.getBookCode());
        	getDetailsForm.setBookTitle(book.getBookTitle());
        	getDetailsForm.setBookAuthor(book.getBookAuthor());
        	
        	LocalDate issueDate=LocalDate.now();
        	LocalDate returnDate=LocalDate.now();
        	
        	 member=dao.getMemberName(getDetailsForm.getMemberCode());
   		    getDetailsForm.setMemberName(member.getMemberName());
    	    if(member.getMemberType().contentEquals("student")) {
    	    	returnDate=returnDate.plusDays(8);
    	    }
    	    if(member.getMemberType().contentEquals("faculty")) {
    	    	returnDate=returnDate.plusDays(90);
    	    }
    	    
    	    getDetailsForm.setIssueDate(issueDate.toString());
    	    getDetailsForm.setReturnDate(returnDate.toString());
    	    System.out.println(getDetailsForm);
    	    
    	    HttpSession httpsession=request.getSession();
    	    httpsession.setAttribute("member", member);
    	    httpsession.setAttribute("book", book);
    	    httpsession.setAttribute("issueDate", issueDate);
    	    httpsession.setAttribute("returnDate", returnDate);
			return mapping.findForward("member");
    	    
    	    
    	    
    	    
    	    
    	   
          }
        }
    	
    	if(request.getParameter("issue")!=null) {
            if(request.getParameter("issue").equals("issueBook")) {
          	System.out.println("Issue button clicked");
          	LocalDate issueDate = null;
			LocalDate returnDate = null;
			HttpSession httpsession=request.getSession();
			if (httpsession.getAttribute("book") != null)
				book = (Book) httpsession.getAttribute("book");
			if (httpsession.getAttribute("member") != null)
				member = (Member) httpsession.getAttribute("member");
			if (httpsession.getAttribute("issueDate") != null)
				issueDate = (LocalDate) httpsession.getAttribute("issueDate");
			if (httpsession.getAttribute("returnDate") != null)
				returnDate = (LocalDate) httpsession.getAttribute("returnDate");

			
			Date issueD = Date.from(issueDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date returnD = Date.from(returnDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

			borrowDetails= new BookBorrow(getDetailsForm.getIssueSerialNo(), issueD, returnD, book, member);
			dao.issueNewBook(borrowDetails);
			System.out.println("Book Issued Successfully !!");
	
            }
          }
        
    	return mapping.findForward("success");
     
     
 
     
       
     }
}