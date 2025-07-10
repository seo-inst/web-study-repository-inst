package org.kosa.myproject.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Ver 6 : MVC + Singleton + Front Controller + Command + Factory Design Pattern
 *             Reflection API 를 적용해 Dynamic Factory 로 업데이트 
 */
@WebServlet("/FrontControllerServletVer6")
public class FrontControllerServletVer6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 공통 작업
			// client 요청 분석
			String command = request.getParameter("command");
			// 컨트롤러 객체 생성을 전담하는  Factory 객체인 HandlerMapping 을 이용해 
			// 적절한 컨트롤러를 반환받는다 
			Controller controller = HandlerMapping.getInstance().create(command);		
			String path = controller.handleRequest(request, response);			
			if(path.trim().startsWith("redirect:")) {
					response.sendRedirect(path.trim().substring(9));
			}else {				
					request.getRequestDispatcher(path).forward(request, response);
			}
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
