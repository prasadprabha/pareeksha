<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <h2 align="center" >Question Paper</h2>
 <hr width=600 >
<form:form action="questionpaper.thml" >
 <table align="center" >
 <core:if test="${!empty questionPaperList}"> 
   <% int i=0; %>
   
   <core:forEach var="questionPaperCommand" items="${questionPaperList}" >
     <input type="hidden"  name="question" />   
     <input type="hidden" value="${questionPaperCommand.questionId}" name="quesNum[<%=i%>]" />   
     <tr>       
       <td>
          <core:out value="<%=i+1%>"></core:out>
          <core:out value="."></core:out>
          <core:out value="Question :"></core:out>
          <core:out value="${questionPaperCommand.question}"></core:out></td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option1Id}">
        <core:out value="${questionPaperCommand.option1}"></core:out>
       </td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option2Id}">
        <core:out value="${questionPaperCommand.option2}"></core:out>
       </td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option3Id}">
        <core:out value="${questionPaperCommand.option3}"></core:out>
       </td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option4Id}">
        <core:out value="${questionPaperCommand.option4}"></core:out>
       </td>
     </tr>
     <% i++; %>   
    </core:forEach>   
     
     <tr>
       <td> 
         <input type="submit" value="Submit"  />
       </td>
     </tr>
  </core:if> 
  <core:if test="${empty questionPaperList}">
    <tr>
      <td>
       <core:out value="No questions available for this exam"></core:out>
      </td> 
    </tr>
  </core:if>    
 </table>
</form:form>
</div></div>

<%@ include file="../footer.jsp" %>  
</body>
</html>