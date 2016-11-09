<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students List</title>
<!-- Bootstrap CSS -->
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style type="text/css">
.myrow-container {
	margin: 20px;
}
</style>
</head>
<body>
	<table class="table table-hover table-bordered">
		<thead style="background-color: #bce8f1;">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Surname</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studentList}" var="student">
				<tr>
					<th><c:out value="${student.id}" /></th>
					<th><c:out value="${student.name}" /></th>
					<th><c:out value="${student.surname}" /></th>
					
			
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>