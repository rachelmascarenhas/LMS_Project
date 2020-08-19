<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic"  prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Issue Details</title>
</head>
<body>
   <h3>Book Issue Details</h3>
   <hr>
   <br>
   <html:form action="issuedBookDetailsAction">
     <table border="1">
       <tr>
          <th>Issue Serial Number</th>
          <th>Member Code</th>
          <th>Member Name</th>
          <th>Book Code</th>
          <th>Book Name</th>
          <th>Date of Issue</th>
          <th>Date of Return</th>
       </tr>
       <logic:iterate name="bookList" id="bookissue">
        <tr>
         <td><bean:write name="bookissue" property="issueSerialNo"/></td>
         <td><bean:write name="bookissue" property="member.memberCode"/></td>
         <td><bean:write name="bookissue" property="member.memberName"/></td>
         <td><bean:write name="bookissue" property="book.bookCode"/></td>
         <td><bean:write name="bookissue" property="book.bookTitle"/></td>
         <td><bean:write name="bookissue" property="issueDate"/></td>
         <td><bean:write name="bookissue" property="returnDate"/></td>
        </tr> 
       </logic:iterate>
     </table>
   </html:form>
   <br>
   <br>
   <a href="IssueNewBook.jsp">Issue New Book</a>
<%--    <html:link action="IssueNewBook.jsp">Issue New Book</html:link> --%>
<%--    <html:link action="UpdateBook.jsp">Update Book</html:link> --%>
<%--    <html:link action="DeleteBook.jsp">Delete Book</html:link> --%>
</body>
</html>