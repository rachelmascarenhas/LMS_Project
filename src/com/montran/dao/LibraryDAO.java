package com.montran.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.loader.entity.plan.EntityLoader.Builder;
import org.hibernate.query.Query;

import com.montran.pojo.*;
import com.montran.util.SessionFactoryUtil;
import org.hibernate.Criteria;
public class LibraryDAO {
	private Session session;
	private Transaction transaction;
	private SessionFactory factory = SessionFactoryUtil.getFactory();

	

//	public List<Employee> getAllEmployees() {
//		session = factory.openSession();
//		Query query = session.createQuery("from employee_struts_hibernate_master");
//		List<Employee> employeeList = query.list();
//		return employeeList;
//	}	
	
	public int getIssueSerialNumber() {                 // to retrieve the issue serial number
		session = factory.openSession();
		Query query = session.createQuery("select max(issueSerialNo) from book_borrow_master");
		int issueSerialNo= (int)query.getSingleResult();
		System.out.println(issueSerialNo);
		session.close();
		return issueSerialNo;
	}
	
	public Member getMemberName(int memberCode) {
		session = factory.openSession();
		Member memberDetails = session.get(Member.class,memberCode);
		System.out.println(memberDetails);
		session.close();
		return memberDetails;
		
	}
	
	public Book getBookName(int bookCode) {
		session = factory.openSession();
		Book bookDetails = session.get(Book.class,bookCode);
		System.out.println(bookDetails);
		session.close();
		return bookDetails;
		
	}
	
	public void issueNewBook(BookBorrow borrowDetails) {
		session = SessionFactoryUtil.getFactory().openSession();
		transaction = session.beginTransaction();
		session.save(borrowDetails);
		transaction.commit();
		session.close();
	}
	
	public List<BookBorrow> getAllBookBorrowDetails(){
		session = factory.openSession();
		Query query = session.createQuery("from book_borrow_master");
		List<BookBorrow> bookList = query.list();
		session.close();
		return bookList;
	}
	
}