package org.kosa.job.controller;

import java.io.IOException;
import java.util.List;

import org.kosa.job.model.MemberDao;
import org.kosa.job.model.MemberVo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test05Servlet
 */
@WebServlet("/Test05Servlet")
public class Test05Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String address = request.getParameter("address");
			List<MemberVo> list = MemberDao.getInstance().findMemberByAddress(address);
			request.setAttribute("memberList", list);
			request.getRequestDispatcher("step5-jstl-forEach-member-list.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}







