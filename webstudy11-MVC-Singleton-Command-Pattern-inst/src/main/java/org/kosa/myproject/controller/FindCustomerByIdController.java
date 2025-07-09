package org.kosa.myproject.controller;

import org.kosa.myproject.model.CustomerVo;
import org.kosa.myproject.model.MockDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
 *  Command 디자인 패턴 :  클라이언트의 요청 처리를 담당하는 객체 
 */
public class FindCustomerByIdController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("customerId");
		CustomerVo vo = MockDao.getInstance().findCustomerById(id);
		String path = null;
		if(vo != null) {
			path = "findbyid-ok.jsp";
			request.setAttribute("customer", vo);
		}else {
			path = "findbyid-fail.jsp";
		}
		return path;
	}
}








