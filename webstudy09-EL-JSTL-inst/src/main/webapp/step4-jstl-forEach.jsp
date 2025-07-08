<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 선언부 --%>
<%@taglib prefix="c"  uri="jakarta.tags.core"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step4-jstl-forEach</title>
</head>
<body>
<%--
			jstl forEach : java or jsp 의 for 문에 해당함 
			items : 배열 또는 컬렉션 
			var : 요소를 담을 임시변수 
 --%>
<h3>step4 jstl forEach</h3>
<c:forEach items="${foods}"  var="food">
	${food}<br> 
</c:forEach>
</body>
</html>









