package org.kosa.myproject.controller;

import org.kosa.myproject.model.CustomerVo;
import org.kosa.myproject.model.MockDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterCustomerController {
	public String registerCustomer(HttpServletRequest request,HttpServletResponse response) {
		String path = null;
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		MockDao.getInstance().registerCustomer(new CustomerVo(id,name,address));
		path = "register-result.jsp";
		return path;
	}
}








