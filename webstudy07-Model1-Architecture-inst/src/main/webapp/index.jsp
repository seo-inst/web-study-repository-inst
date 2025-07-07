<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model 1 Architecture</title>
</head>
<body>
<h2>Model 1 Architecture</h2>
<a href="step1-jsp-db.jsp">Model1 설계방식 이전의 예: 총 회원수 보기</a>
<br><br>
<img alt="Model1 설계방식" src="./images/Model1-Architecture.jpg">
<%--
			Model 1 설계방식로 위 예제를 리팩토링 해본다 
			리팩토링 : 입출력 동일하되 내부 구조 개선을 통한 가독성과 유지보수성 향상
 			 index -- step2-model1-member-count.jsp  <--> MemberDao <--> DB 
 			 			 요청분석 , java bean(Dao) 연동 			java bean(component)
 			 			 결과 View 를 클라이언트에게 응답        데이터 연동 로직 
 			 			 															1. getAllMemberCount()
 			 			 2.  jsp 구현 															
 --%>
 <a href="step2-model1-member-count.jsp">Model 1 아키텍쳐를 적용한 회원수 보기</a><br>
 <a href="step3-model1-find-member-form.jsp">Model 1 아키텍쳐를 적용한 회원 검색하기</a><br>
 
</body>
</html>












