<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<MemberVO> list = new ArrayList<MemberVO>();
list.add(new MemberVO("angel", null, "아이유", "수원"));
list.add(new MemberVO("joy", null, "손흥민", "런던"));
list.add(new MemberVO("peace", null, "이강인", "파리"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VO List JSP 활용</title>
<style>
table {
	width: 100%;
	border-collapse: collapse; /* 테두리 겹치게 설정  */
}

th {
	background-color: rgb(195, 229, 229);
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: center;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getId() %></td>
				<td><%=list.get(i).getName() %></td>
				<td><%=list.get(i).getAddress() %></td>
			</tr>
			<%
			}
			%>  
		</tbody>
	</table>
</body>
</html>












