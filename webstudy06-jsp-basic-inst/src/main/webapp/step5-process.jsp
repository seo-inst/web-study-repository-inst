<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 서버프로그램에서 form data 처리</title>
</head>
<body bgcolor="yellow">
<h3>
		jsp 서버프로그램에서 form data 처리
</h3>
<%
		String userId=request.getParameter("userId");
//     동일한 name 으로 다수의 value 가 전달될 때 
//     아래와 같이 배열로 반환받을 수 있다 
        String foods[] = request.getParameterValues("menu");
%>
<p>사용자 아이디는 <%=userId %> 입니다.  </p>
<ul>
<%
		for(String food : foods){
%>
	<li><%=food %></li> 
<%
		}
%>
</ul>
</body>
</html>

















