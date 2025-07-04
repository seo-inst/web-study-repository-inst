package step5;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionOneServlet
 */
@WebServlet("/SessionThreeServlet")
public class SessionThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Session Study</title>");
		out.println("</head>");
		out.println("<body bgcolor=orange>");
		out.println("<h3>"+getServletConfig().getServletName()+"</h3>");
		//  getSession(false) : 기존 세션이 있으면 기존 세션 반환 , 없으면 null 을 반환 		
		HttpSession session=request.getSession(false);
		if(session==null)
			out.println("세션이 존재하지 않습니다");
		else {
			session.invalidate();
			out.println("session 무효화시킴  invalidate() 실행");			
		}
		out.println("<br><br><a href=index.html>home</a>");	
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}




