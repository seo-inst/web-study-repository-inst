package org.kosa.myproject.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Ver 4 : MVC + Singleton + Front Controller + Command Design Pattern
 */
@WebServlet("/FrontControllerServletVer4")
public class FrontControllerServletVer4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 공통 작업
			// client 요청 분석
			String command = request.getParameter("command");
			// 추상화된 인터페이스 타입
			Controller controller = null;
			if (command.equals("findbyid")) {
				controller = new FindCustomerByIdController();
			}
			String path = controller.handleRequest(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp"); // Front 에서 예외 처리 공통 정책을 실행 
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doDispatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 하위 버전에서는 POST 방식일 경우 별도의 한글처리가 필요
		request.setCharacterEncoding("UTF-8");
		this.doDispatch(request, response);
	}
}
