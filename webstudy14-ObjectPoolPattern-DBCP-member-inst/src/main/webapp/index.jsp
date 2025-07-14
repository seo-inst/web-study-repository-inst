<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="jakarta.tags.core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Object Pool Pattern : DBCP</title>
</head>
<body>
<h3>Object Pool Pattern : DBCP</h3>
<%--
			 querystring :   처리할 서버프로그램 url?name=value
 --%>
<a href="front?command=Test">web test</a>
<br><br><br>
<h3>회원관리</h3>
<%--
			index  -- Front -- HandlerMapping -- Controller
																			|
																		GetTotalMemberCountController   <--->   MemberDao <--> DataSourceManager(DBCP)
																		   | 
																		   | forward 
																		 member-count.jsp  	
 --%>
<a href="front?command=GetTotalMemberCount">총 회원수 보기</a> <br><br>
<form method="get" action="front">
<input type="hidden" name="command" value="FindMemberById">
<input type="text" name="id" placeholder="아이디"  required="required">
<button type="submit">회원검색</button>
</form>
<br><br>
<form method="get" action="front">
<input type="hidden" name="command" value="FindMemberListByAddress">
<input type="text" name="address" placeholder="주소" required="required">
<button type="submit">회원검색</button>
</form>
<br><br>
<%--   
       비 로그인 상태이면 아래 로그인 폼을 제공한다    
--%>
<c:choose>
	<c:when test="${sessionScope.mvo==null}">
	<form method="post" action="front">
	<input type="hidden" name="command" value="Login">
	<input type="text" name="id" placeholder="아이디" required="required"><br>
	<input type="password" name="password" placeholder="패스워드" required="required"><br>
	<button type="submit">로그인</button>
	</form>
	</c:when>
	<c:otherwise>
	${sessionScope.mvo.name} 님 로그인 상태입니다 <br><br>
	<%--
						F.C  -- H.M -- Controlller
													|
											  LogoutController
											  세션 체크 , 기존 세션 존재하면  session invalidate() 로 세션 무효화 후 
											  리다이렉트  index.jsp 		
	 --%>
	<form method="post" action="front">
	<input type="hidden" name="command" value="Logout">
		<button type="submit">로그아웃</button>
	</form>
	</c:otherwise>
</c:choose>


<%--
			jstl  library 와 선언부 확인, 없으면 등록하고 
			choose ~ when ~ otherwise 를 이용 : sessionScope.mvo 의 존재 유무로 
			비교 후 로그인 상태가 아니면 위의 로그인 폼을 보여주고
			로그인 상태이면 아래의 예처럼 사용자 정보와 로그아웃 버튼을 제공한다 
			
			손흥민님 로그인 상태입니다
			<form> ....
			<button>로그아웃</button> 
 --%>
<br><br><br>
<img src="front-all.png" width="70%">
</body>
</html>







