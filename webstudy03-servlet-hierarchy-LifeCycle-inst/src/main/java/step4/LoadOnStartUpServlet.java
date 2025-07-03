package step4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
	 	loadOnStartup = 1
	 	웹 어플리케이션이 실행이 시작되는 시점에 가장 우선적으로
	 	위 옵션이 명시된 서블릿을 초기화합니다. 
	 	서블릿 라이프 사이클 구조상 클라이언트의 첫 요청 시점에 
	 	서블릿이 초기화 작업을 하므로 
	 	웹 어플리케이션에서 중요한 역할을 하는 서블릿 ( 초기화 작업이 많은 서블릿 포함)
	 	은 위 옵션이 유용합니다. 
 */
@WebServlet(value="/onload-test",loadOnStartup = 1)
public class LoadOnStartUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoadOnStartUpServlet() {
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




