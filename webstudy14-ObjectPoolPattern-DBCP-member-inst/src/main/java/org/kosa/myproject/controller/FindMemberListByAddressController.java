package org.kosa.myproject.controller;

import org.kosa.myproject.model.MemberDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindMemberListByAddressController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("memberList", MemberDao.getInstance().findMemberByAddress(request.getParameter("address")));
		return "member-list.jsp";
	}
}
