package org.kosa.myproject.controller;

import org.kosa.myproject.model.CustomerVo;
import org.kosa.myproject.model.MockDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 아이디로 고객 정보를 검색하는 요청 처리를 전담하는 컨트롤러 객체 -> 단일 책임 원칙
 */
public class FindCustomerByIdController {
	public String findCustomerById(HttpServletRequest request, HttpServletResponse response) {
		// 클라이언트 요청 분석 : 클라이언트로부터 고객 아이디를 받아 온다
		String id = request.getParameter("customerId");
		// MockDao 와 연동한다
		CustomerVo customer = MockDao.getInstance().findCustomerById(id);
		String path = null;
		if(customer==null)
			path = "findbyid-fail.jsp";
		else {
			path = "findbyid-ok.jsp";
			request.setAttribute("customer", customer);
		}
		return path;
	}
}
















