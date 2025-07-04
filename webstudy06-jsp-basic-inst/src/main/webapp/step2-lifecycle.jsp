<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp lifecycle</title>
</head>
<body>
<%! 
		// 인스턴스 변수 
		int count;
		public void jspInit(){
			System.out.println("init() 초기화");
		}
		public void jspDestroy(){
			System.out.println("destroy() 소멸직전 실행 ");
		}
%>
<%--  아래 조회수가 jspService() 메서드 내에서 실행된다    --%>
<%
       System.out.println("jspService()  요청시마다 매번 실행 ");
%>
<h3>조회수:<%=++count %></h3>
</body>
</html>







