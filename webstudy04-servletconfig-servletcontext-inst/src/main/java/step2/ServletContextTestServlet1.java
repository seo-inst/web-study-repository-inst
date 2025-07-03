package step2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextTestServlet1
 */
@WebServlet("/context-test1")
public class ServletContextTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ServletContext Study1</title>");
		out.println("</head>");
		out.println("<body bgcolor=yellow>");
		String securityInfo=
				this.getServletConfig().getServletContext().getInitParameter("securityConfigInfo");
		out.println("<h3>ServletContextTestServlet1</h3>");
		out.println("ServletContext의 securityInfo:"+securityInfo);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}





