<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
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

<div class="text-center">
 <h1 align="center" >User Registration</h1>
 <hr width=600 >
 <br clear="all"> <br clear="all"> <br clear="all">

 <form:form action="userregistration.html" commandName="userForm" >
  <table align="center" >
    <tr>
     <td>
       <form:label path="userName" >User Name:</form:label>
       <FONT color="red"><form:errors path="userName" /></FONT>
     </td>
    <tr>
    </tr> 
     <td>
       <form:input path="userName" size="26" />       
    </tr>
    <tr>
     <td>
      <form:label path="userEmail">User Email:</form:label>
      <FONT color="red"><form:errors path="userEmail" /></FONT>
     </td>
    <tr>
    </tr> 
     <td>
       <form:input path="userEmail" size="26" />
    </tr>
    <tr>
     <td>
      <form:label path="password">Password:</form:label>
      <FONT color="red"><form:errors path="password" /></FONT>
     </td>
    <tr>
    </tr> 
     <td>
       <form:password path="password" size="26" />
    </tr> 
    <tr>
     <td>
      <form:label path="confirmPassword">Confirm Password:</form:label>
     </td>
    <tr>
    </tr>  
     <td>
       <form:password path="confirmPassword" size="26" />
    </tr>
    </tr>    
     <td>
       <form:label path="userGender">Select Gender:</form:label>
       <FONT color="red"><form:errors path="userGender" /></FONT>
     </td>  
    </tr>
    </tr>    
     <td>
       <form:select path="userGender">
        <form:option label="--Select Gender--" value="-1" />
        <form:option label="Male" value="M" />
        <form:option label="Female" value="F" />     	
       </form:select>
     </td>  
    </tr>     
    <tr>
     <td>
      <form:label path="phoneNo">phone No:</form:label>
      <FONT color="red"><form:errors path="phoneNo" /></FONT>
     </td>
    <tr>
    </tr>  
     <td>
       <form:input path="phoneNo" size="26" />
    </tr>
    <tr>
     <td>
      <form:label path="address">Address:</form:label>
     </td>
   <tr>
   </tr>  
     <td>
       <form:textarea path="address" rows="5" ></form:textarea>
    </tr>       
    <tr>    
    <td>
      <input type="submit" value="Submit"/>     
    </td>
  </tr> 
</table>
</form:form>
</div>
<br clear="all"><br clear="all">
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>