package org.kosa.job.controller;

import java.io.IOException;

import org.kosa.job.model.MemberDao;
import org.kosa.job.model.MemberVo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test03Servlet
 */
@WebServlet("/Test03Servlet")
public class Test03Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 요청 분석 
			String id = request.getParameter("id");
			MemberVo vo = MemberDao.getInstance().findMemberById(id);
			request.setAttribute("mvo", vo);
		request.getRequestDispatcher("step3-jstl-choose.jsp").forward(request, response);
		}catch(Exception e) { // 예외 처리 로직 
			e.printStackTrace();
		}
	}
}








