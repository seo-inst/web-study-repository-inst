<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 검색 결과</title>
</head>
<body>
<h3>고객 정보 검색 결과</h3>
<%--
		클라이언트 폼에서 전달한 정보 
		<input type="text" name="customerId" required="required" placeholder="고객아이디">
		
		아래는 request.getParameter("customerId"); 를 간단하게 EL 로 표현 
 --%>
고객 아이디 ${param.customerId} <br>
<%--
			FrontControllerServlet 에서   request.setAttribute("customer",customerVo); 로 공유한 정보를 
			<%   CustomerVo customer = (CustomerVo)request.getAttribute("customer"); %>
			<%=customer.getName() %>
			
			${customer.name} 은 상세히 기술하면 ${requestScope.customer.name} 으로 표현할 수 있는데 scope 는 생략 가능  
 --%>
고객명 ${customer.name} <br>
주소 ${customer.address}
</body>
</html>






