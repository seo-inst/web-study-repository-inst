package org.kosa.myproject.controller;

import org.kosa.myproject.model.MemberDao;
import org.kosa.myproject.model.MemberVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindMemberByIdController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		MemberVo vo=MemberDao.getInstance().findMemberById(id);
		String path=null;
		if(vo!=null) {
			path = "findbyid-ok.jsp";
			request.setAttribute("member", vo);
		}else {
			path = "findbyid-fail.jsp";
		}
		return path;
	}

}




