package org.kosa.myproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 *   Command Design Pattern :  클라이언트 요청 처리를 전담하는 Command(Controller) 객체들을 
 *   											 캡슐화하기 위한 인터페이스 
 */
public interface Controller {
	public String handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
