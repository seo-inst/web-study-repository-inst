package step4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.MemberVO;

/**
 * Servlet implementation class SessionOneServlet
 */
@WebServlet("/SessionTwoServlet")
public class SessionTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Session Study</title>");
		out.println("</head>");
		out.println("<body bgcolor=yellow>");
		out.println("<h3>"+getServletConfig().getServletName()+"</h3>");
		// 세션이 있으면 세션을 반환받고 없으면 null 을 반환 
		HttpSession session=request.getSession(false);
		if(session==null)
			out.println("세션이 존재하지 않습니다");
		else {
			out.println("세션이 존재합니다 "+session.getId());
			MemberVO member=(MemberVO) session.getAttribute("mvo");
			out.println("<br><br>"+member.getName()+"님 반갑습니다");
		}
		out.println("<br><br><a href=index.html>home</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}






