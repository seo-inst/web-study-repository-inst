package org.kosa.job.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Test04Servlet
 */
@WebServlet("/Test04Servlet")
public class Test04Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// jstl forEach 구문 연습용으로  Array 를 request에 공유 
			String foods [] = {"치킨","피자","곱창"};
			request.setAttribute("foods", foods);
			request.getRequestDispatcher("step4-jstl-forEach.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}









