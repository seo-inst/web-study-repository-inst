package org.kosa.myproject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/front")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
      	work flow 
     	클라이언트 요청(command)을 받아온다
     	요청 처리 담당 객체(Controller)를 받아온다.  HandlerMapping Factory 를 통해서 
     	요청을 처리할 담당 Controller를 실행한다 
     	실행 후 반환된 정보를 이용해  forward 또는 redirect 방식으로 
     	응답하게 View 로 제어를 이동한다 
 		예외 공통정책 :  예외 발생시 사용자에게는 점검중 페이지를 제공하고 시스템 콘솔에서는 예외 발생 경로와
 								 메세지를 출력한다 
     */
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
		String command = request.getParameter("command");
		//아래 라인 의미 => Factory pattern : 다양한 요청을 처리할 컨트롤러 객체를 단일한 방식으로 생성
		Controller controller=HandlerMapping.getInstance().create(command);
		//아래 라인 의미 => command pattern : 다양한 개별 컨트롤러를 단일한 방식으로 실행
		String path = controller.handleRequest(request, response);
		if(path.trim().startsWith("redirect:")) {
			response.sendRedirect(path.trim().substring(9));
		}else {
			request.getRequestDispatcher(path).forward(request, response);
		}		
		// 예외 처리에 대한 공통 정책 : Front Controller Pattern 적용을 해서
		//  각 서블릿 또는 jsp 에서 반복적으로 작업하던 것을 중앙 Front 에서 한번에 
		//  효율적으로 제어 , 유지보수성 향상 
		}catch(Exception e) { 
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 만약 웹 모듈 하위 버전이라면 POST 방식의 데이터 한글 처리가 아래와 같이 별도로 필요하다 
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}
		this.doDispatch(request, response);
	}
}









