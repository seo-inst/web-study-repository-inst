<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC + FrontController Design Pattern</title>
</head>
<body>
<h2>Web MVC 기반 Front Controller Design Pattern 적용</h2>
<form action="FrontControllerServletVer5" method="get">
<%--  하나의 프론트 컨트롤러로 다양한 요청이 이루어지므로 어떤 요청인지를
		 hidden 으로 알린다 
   --%>
   <input type="hidden" name="command" value="findbyid">
<input type="text" name="customerId" required="required" placeholder="고객아이디">
<button type="submit">검색</button>
</form>
<br><br>
<%--  다양한 요청을 Front 즉 하나의 진입점에서 처리하도록 한다
		 index -- 고객등록요청 -- FrontControllerServlet  --HandlerMapping   			Controller
		 										doDispatch()                    					  					  		|        ---------------- MockDao
		 										 |										 												 |
		 										 									 											 RegisterCustomerController 	
		 										 |
		 										register-result.jsp 로 리다이렉트  
  --%>
<form action="FrontControllerServletVer5" method="post">
<input type="hidden" name="command" value="registerCustomer">
<input type="text" name="id" placeholder="아이디" required="required"><br>
<input type="text" name="name" placeholder="이름" required="required"><br>
<input type="text" name="address" placeholder="주소" required="required"><br>
<button type="submit">고객등록</button>
</form>
<br><br>
<%--
			구현할 부분 : HandlerMapping (추가 구현) 과 UpdateCustomerController ( 신규 개발 )
			응답은 redirect 방식으로 한다   
 --%>
<form action="FrontControllerServletVer5" method="post">
<input type="hidden" name="command" value="updateCustomer">
<input type="text" name="id" placeholder="아이디" required="required"><br>
<input type="text" name="name" placeholder="이름" required="required"><br>
<input type="text" name="address" placeholder="주소" required="required"><br>
<button type="submit">고객수정</button>
</form>
<br><br>


<img alt="Front Controller Pattern" src="front.png" width="50%">
</body>
</html>














