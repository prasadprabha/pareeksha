<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<%@ include file="../header.jsp"%>
</head>
<body>
	<%@ include file="../navbar.jsp"%>
	<div class="container-fluid">
		<div class="text-center marginBottom_70">
			<h2 align="center">Result</h2>
			<%int i = 0;%>
			<table class="table">
				<thead>
				    <tr>
				      <th scope="col">No</th>
				      <th scope="col">Question</th>
				      <th scope="col">Answer</th>
				    </tr>
				  </thead>
				<core:forEach var="questionPaperCommand"
					items="${questionPaperList}">
					<tr>
						<th scope="row"><core:out value="<%=i + 1%>"></core:out></th>
						<td class="float-none"><core:out value="${questionPaperCommand.question}"></core:out></td>
						<td class="float-none"><font color="green"><core:out value="Answer : "></core:out></font>
							<core:out value="${questionPaperCommand.option1}"></core:out>
					</tr>
					<%
						i++;
					%>
				</core:forEach>
			</table>
			<div class="card text-green bg-light mb-3">
				<div class="card-header">Result</div>
				<ul class="list-group list-group-flush text-green">
					<li class="list-group-item text-left "><core:out
							value="Total Questions : "></core:out> <core:out
							value="${totalQuestion}"></core:out></li>
					<li class="list-group-item text-left"><core:out value="Result Marks : "></core:out>
						<core:out value="${rightAnswer}"></core:out></li>
					<li class="list-group-item text-left"><core:out
							value="Number of right answers : "></core:out> <core:out
							value="${rightAnswer}"></core:out></li>

					<li class="list-group-item text-left"><core:out
							value="Number of wrong answers : "></core:out> <core:out
							value="${wongAnswer}"></core:out></li>
				</ul>
			</div>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>

</body>
</html>