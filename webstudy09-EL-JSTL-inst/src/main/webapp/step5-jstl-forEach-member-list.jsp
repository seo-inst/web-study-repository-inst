<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 선언부 --%>
<%@taglib prefix="c"  uri="jakarta.tags.core"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step5-jstl-forEach-member-list</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse; /* 테두리 겹치게 설정  */
        }
        th{
            background-color: rgb(195, 229, 229);
        }
        th,td{
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
    </style>
</head>
<body>
<%--
			jstl forEach : java or jsp 의 for 문에 해당함 
			items : 배열 또는 컬렉션 
			var : 요소를 담을 임시변수 
 --%>
<h3>step5 jstl forEach</h3>
<%-- <c:forEach items="${foods}"  var="food">
	${food}<br> 
</c:forEach> --%>
<%--  종로에 사는 회원명단 과 같이 el 로 동적으로 표현해본다   --%>
<h4>${param.address} 에 사는 회원명단</h4>
<table>
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>			
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${memberList}" var="member">
		<tr>
			<td>${member.id}</td>
			<td>${member.name}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>









