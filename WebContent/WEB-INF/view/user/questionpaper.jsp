<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<%@ include file="../header.jsp"%>
	<%@ include file="../navbar.jsp"%>
</head>
<body>
	<div class="container-fluid mainContent">
		<div class="text-center  marginBottom_70">
			 <div id="countdowntimer"><span id="future_date"></span></div>
  <div id="dialog-confirm" title="Time Up Confirmation">
  	<p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>Your Time is Up</p>
  </div>
			<h2 align="center">Question Paper</h2>
			<form:form id="qstnPaper" action="questionpaper.thml">
				<core:if test="${!empty questionPaperList}">
					<%
							int i = 0;
					%>
					<core:forEach var="questionPaperCommand"
						items="${questionPaperList}">
						<input type="hidden" name="question" />
						<input type="hidden" value="${questionPaperCommand.questionId}"
							name="quesNum[<%=i%>]" />
						<div class="card">
							<div class="card-header">
								<core:out value="<%=i + 1%>"></core:out>
								<core:out value="${questionPaperCommand.question}"></core:out>
							</div>
							<ul class="list-group list-group-flush">
								<li class="list-group-item"><input type="radio"
									name="option[<%=i%>]" value="${questionPaperCommand.option1Id}">
									<core:out value="${questionPaperCommand.option1}"></core:out></li>
								<li class="list-group-item"><input type="radio"
									name="option[<%=i%>]" value="${questionPaperCommand.option2Id}">
									<core:out value="${questionPaperCommand.option2}"></core:out></li>
								<li class="list-group-item"><input type="radio"
									name="option[<%=i%>]" value="${questionPaperCommand.option3Id}">
									<core:out value="${questionPaperCommand.option3}"></core:out></li>
								<li class="list-group-item"><input type="radio"
									name="option[<%=i%>]" value="${questionPaperCommand.option4Id}">
									<core:out value="${questionPaperCommand.option4}"></core:out></li>
							</ul>
						</div>
						<%
							i++;
						%>
					</core:forEach>
					<input type="submit" value="Submit" />
				</core:if>
			</form:form>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>