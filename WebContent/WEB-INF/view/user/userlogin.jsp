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
 <h1 align="center" >Online Test Application</h1>
 <hr width=600 >

 
 <form:form commandName="user" action="userlogin.html"  class="form-signin" >
 <table >
 <tr> <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"></tr>
 <tr><h1 class="h3 mb-3 font-weight-normal">Please sign in</h1></tr>
  <tr>
    <td><form:label path="userEmail" class="sr-only">User Email:</form:label></td>
    <td>
     <form:input path="userEmail" class="form-control"/>     
    </td>
  </tr>
  <tr>
    <td></td>
    <td>
      <FONT color="red"><form:errors path="userEmail"></form:errors></FONT>
    </td>
  </tr>
  <tr>
    <td><form:label path="password"  class="sr-only">Password:</form:label></td>
    <td>
      <form:password path="password" class="form-control"/>      
    </td>
  </tr>
  <tr>
    <td></td>
    <td>
      <FONT color="red"><form:errors path="password"></form:errors></FONT>
    </td>
  </tr>
  <tr>
    <td></td>
    <td>
      <input type="submit" value="Login" class="btn btn-lg btn-danger btn-block" /> or
      <a href="userregistration.jsp"> Sign up</a>
      <p class="mt-5 mb-3 text-muted"></p>
    </td>
  </tr> 
 </table>
 </form:form> 
 
 <!--  <form:form commandName="user" action="userlogin.html" class="form-signin">
  
      <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="userEmail" class="sr-only">Email address</label>
      <input type="email" id="userEmail" class="form-control" placeholder="Email address" required autofocus>
      <label for="password" class="sr-only">Password</label>
      <input type="password" id="password" class="form-control" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
      <p class="mt-5 mb-3 text-muted"></p>
    </form:form> 
 -->
 </div>
</div>

<%@ include file="../footer.jsp" %>  


</body>
</html>