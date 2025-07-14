<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login-ok</title>
</head>
<body>
<%--
			MemberVo mvo=(MemberVo)session.getAttribute("mvo");
			<%=mvo.getName() %>  을 아래 EL 간단히 처리 
 --%>
  ${sessionScope.mvo.name}님 로그인 성공하셨습니다 <a href="index.jsp">Home으로 이동</a>
</body>
</html>