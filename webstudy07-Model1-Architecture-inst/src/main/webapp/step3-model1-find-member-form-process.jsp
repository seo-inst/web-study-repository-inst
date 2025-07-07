<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.kosa.member.model.*"%>
<%
		 MemberDao dao = new MemberDao();
		 // client 가 보낸 회원 아이디를 받는다
		 String memberId = request.getParameter("memberId");
         MemberVo  member = dao.findMemberById(memberId);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model1 회원검색 결과</title>
</head>
<body>
<%-- step3-model1-find-member-form-process.jsp  --%>
<h3>Model1 회원 검색 결과</h3>
<%-- 
			java 아이디에 대한 회원 정보 
			이름 :  손흥민   주소 : 런던 
			or 
			java7 아이디에 대한 회원 정보
			회원 정보가 존재하지 않습니다  
  --%>
  <p><%=memberId%>아이디에 대한 회원 정보 </p>
  <%
		if(member!=null){  
  %>
  <p>이름:<%=member.getName() %>  주소:<%=member.getAddress() %></p>
  <%
		}else{
  %>
  <p>회원 정보가 존재하지 않습니다</p>
  <%
		}
  %>
</body>
</html>









