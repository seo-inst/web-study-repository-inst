<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%--  jstl 을 사용하기 위한 선언부  --%>   
 <%@ taglib prefix="c" uri="jakarta.tags.core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step3-jstl-choose.jsp</title>
</head>
<body>
<%--  
		EL Test 
		아래의 EL 표현식을 기존 JSP  스크립틀릿으로 표현하면 
		<%  
				MemberVo mvo =(MemberVo) request.getAttribute("mvo");				
		%>
		<%=mvo.getName() %> 
		아래의 mvo.name 은  MemberVo 객체의 getName() 을 호출하는
		것임 
  --%>
회원명 ${mvo.name}  주소 ${mvo.address} <br><br>
<%-- 
			jstl  choose ~ when ~ otherwise
		(	java 의  if ~ else if ~ else 구문의 역할 ) 
 --%>
 <c:choose>
 	<c:when test="${mvo.address == '뉴욕' }">
 		 ${mvo.name } 님 ${mvo.address}에 살고 있습니다
 	</c:when>
 	<c:when test="${mvo.address == '런던' }">
 		 ${mvo.name } 님 ${mvo.address}에 살고 있습니다
 	</c:when>
 	<c:otherwise>
 		이 부분은 else 구문입니다 
 	</c:otherwise>
 </c:choose>
</body>
</html>












