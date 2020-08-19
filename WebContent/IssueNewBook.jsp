<%@page import="com.montran.dao.LibraryDAO"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Book</title>
</head>
<body>
   <h3>Issue New Book</h3>
   <br>
   <br>
   <hr>
  <html:form action="/bookAction" method="post">
     <table> 
       <tr>
                <td>Issue Serial Number</td>
                  <% LibraryDAO dao= new LibraryDAO();
                      int SerialNo= dao.getIssueSerialNumber();
                       String issueSerialNo= Integer.toString(SerialNo+1);
                   %>
        
       
                <td><html:text property="issueSerialNo" value="<%=issueSerialNo%>" disabled="true" ></html:text> 
       </tr>
       <tr>
				<td>Member Code</td>
				<td><html:text property="memberCode"/></td>

 				<td><html:submit property="member" value="getMember" >Get Member Details</html:submit></td>
	   </tr>
	   <tr>
				<td>Member Name</t>
				<td><html:text property="memberName" > </html:text></td>			
	  </tr>
	  <tr>
				<td>Book Code</td>
				<td><html:text property="bookCode"/></td>

 				<td><html:submit property="book" value="getBook" >Get Book Details</html:submit></td>         
	   </tr>
	   <tr>
	             <td>Book Title</td>
	             <td><html:text property="bookTitle"/></td>
	   </tr>
	   <tr>
	             <td>Book Author</td>
	             <td><html:text property="bookAuthor"/></td>   
	   </tr>    
	   <tr>
	            <td>Issue date</td>
	            <td><html:text property="issueDate"/></td>  
	   </tr>
	   <tr>     
	            <td>Return date</td>
	            <td><html:text property="returnDate"/></td>  


        <tr>
         <td>  <html:submit property="issue" value="issueBook">Issue New Book</html:submit> </td>  
         </tr>
     </table>
     
             
  </html:form>
   <div style="color:red">
	  <html:errors/>
   </div>
</body>
</html>
