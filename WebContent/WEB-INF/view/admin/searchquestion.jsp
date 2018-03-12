<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h4 align="center" >
   <a href="addexam.html">Add Exam</a>&nbsp;&nbsp;
   <a href="questionlist.html" >Question list</a>&nbsp;&nbsp;
   <a href="addquestion.html" >Add Question</a>&nbsp;&nbsp;
   <a href="searchquestion.html" >Search Question</a>&nbsp;&nbsp;
   <a href="questionlist.html" >Delete Question</a>
 </h4> 
<h2 align="center" >Search Question</h2>
<hr width=600 >
<div align="right" style="top:0 " >
  <%if(session.getAttribute("adminName")!=null){ %>
    Welcome :<% out.print(session.getAttribute("adminName"));%>
  <%} %>&nbsp;
  <a href="logout.thml" >LogOut</a> 
</div>
 <form:form commandName="exam"   action="searchquestion.html" >
 <table align="center" >
 <tr>
  <td>
   Search Question:
  </td>
  <td>
    <form:select path="examId">
     <form:option label="--Select Exam--" value="-1" />
     <form:options items="${examlist}" itemLabel="examName" itemValue="examId" />     	
    </form:select>  
  </td>
 </tr>
 <tr> 
  <td></td>
  <td><font color="red" ><core:out value="${errormessage}"></core:out></font></font> </td>  
 </tr> 
 <tr> 
  <td></td>
  <td><input type="submit" value="Submit"  /></td>  
 </tr> 
</table> 
 
</form:form>
 
</body>
</html>