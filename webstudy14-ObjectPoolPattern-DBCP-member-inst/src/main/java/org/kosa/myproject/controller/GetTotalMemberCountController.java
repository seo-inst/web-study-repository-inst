package org.kosa.myproject.controller;

import org.kosa.myproject.model.MemberDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetTotalMemberCountController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("totalMemberCount", MemberDao.getInstance().getTotalMemberCount());
		return "member-count.jsp";
	}
}
