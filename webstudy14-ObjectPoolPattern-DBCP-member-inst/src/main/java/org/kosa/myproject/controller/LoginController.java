package org.kosa.myproject.controller;

import org.kosa.myproject.model.MemberDao;
import org.kosa.myproject.model.MemberVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVo memberVo=MemberDao.getInstance().login(id, password);
		String path = null;
		if(memberVo!=null) { // 로그인 성공하면 
			HttpSession session = request.getSession();// 기존 세션 없으면 새로 생성, 있으면 기존 리턴 
			// 세션에 인증 정보 ( 회원 객체 ) 를 저장한다 
			session.setAttribute("mvo", memberVo);
			path = "redirect:login-ok.jsp";
		}else {
			path = "redirect:login-fail.jsp";
		}
		return path;
	}
}









