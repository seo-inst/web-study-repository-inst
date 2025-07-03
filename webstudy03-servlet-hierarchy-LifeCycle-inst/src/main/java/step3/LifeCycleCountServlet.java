package step3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleCountServlet
 */
@WebServlet("/life-count")
public class LifeCycleCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LifeCycleCountServlet() {
		super();
		System.out.println(getClass() + " 객체 생성");
	}
	private int count; // 0 으로 초기화 
	@Override
	public void init() throws ServletException {
		System.out.println(getClass() + " init() count:"+count++);
	}

	@Override
	public void destroy() {
		System.out.println(getClass() + " destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet LifeCycle</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>접속수:"+count+"</h1>");
		count++;
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}




