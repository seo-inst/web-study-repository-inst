package org.kosa.myproject.controller;

import java.io.IOException;

import org.kosa.myproject.model.CustomerVo;
import org.kosa.myproject.model.MockDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *  Front Controller Design Pattern :  모든 클라이언트 요청을 하나의 진입점으로 모아서 처리 
 *  Spring 에서는   DispatcherServlet 이 Front Controller 역할을 한다 
 */
@WebServlet("/FrontControllerServletVer1")
public class FrontControllerServletVer1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		try {
			System.out.println(request.getMethod());
			String requestType = request.getParameter("requestType");
			//System.out.println(requestType);
			if(requestType!=null&&requestType.equals("findbyid")) {
				// 클라이언트 요청 분석 : 클라이언트로부터 고객 아이디를 받아 온다 
				String id = request.getParameter("customerId");
				// MockDao 와 연동한다 
				CustomerVo customer = MockDao.getInstance().findCustomerById(id);
				// 고객이 존재하면  고객정보를 request 에 공유하여 forward 로 응답한다
				// 고객이 존재하지 않으면  redirect 방식으로 응답한다 
				if(customer!=null) {
						request.setAttribute("customer", customer);
						request.getRequestDispatcher("findbyid-ok.jsp").forward(request, response);
				}else {
						response.sendRedirect("findbyid-fail.jsp");
				}				
			}else if(requestType!=null && requestType.equals("registerCustomer")) {
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				MockDao.getInstance().registerCustomer(new CustomerVo(id,name,address));
				response.sendRedirect("register-result.jsp");
			}
		}catch(Exception e) { // 예외 처리 로직을 Front 에게 일관성 있게 정의, 이후 유지보수성도 향상
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doDispatch(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 기존 버전에서는(최신 버전이 아닌 ) post 방식일때는 별도의 한글 처리가 필요하다 
		request.setCharacterEncoding("UTF-8");
		this.doDispatch(request, response);
	}
}





