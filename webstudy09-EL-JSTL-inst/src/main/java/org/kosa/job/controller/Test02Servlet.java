package org.kosa.job.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Test02Servlet
 */
@WebServlet("/Test02Servlet")
public class Test02Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		// 요청 분석 
		// 모델 연동 
		request.getRequestDispatcher("step2-jstl-if.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}








