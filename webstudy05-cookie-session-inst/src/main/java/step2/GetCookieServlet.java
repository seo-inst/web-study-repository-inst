package step2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Study</title>");
		out.println("</head>");
		out.println("<body bgcolor=orange>");
		out.println("<h3>GetCookieServlet</h3>");
		// client 가 전송한 request 로부터 쿠키 정보를 반환받는다 
		Cookie cookies[] = request.getCookies();
		if(cookies==null) {
			out.println("쿠키가 존재하지 않습니다");
		}else {
			String timeInfo = null;
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("timeCookie")) {
					timeInfo = cookies[i].getValue();
					break;
				}
			}			
			if(timeInfo !=null) {
				out.println("time 쿠키 정보:"+timeInfo);
			}else {
				out.println("time 쿠키 정보가 존재하지 않습니다");
			}
		}
		
		out.println("<br><strong>클라이언트로부터 time 쿠키 정보를 확인</strong>");
		out.println("<br><br><a href=index.html>home 으로 <br><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}






