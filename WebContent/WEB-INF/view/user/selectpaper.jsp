<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
 <%@ include file="../header.jsp" %>  
</head>
<body>
<%@ include file="../navbar.jsp" %> 
<div class="container-fluid">
<div class="text-center  marginBottom_70">
<h2 align="center" >Select Paper</h2>
 <form:form commandName="exam"   action="selectpaper.html" >
 <table align="center" >
 <tr>
  <td>
   Select Exam:
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
 </div></div>

<%@ include file="../footer.jsp" %>  

</body>
</html>