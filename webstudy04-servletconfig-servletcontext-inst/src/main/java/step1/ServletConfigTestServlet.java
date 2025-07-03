package step1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ServletConfig 사용법을 보여주는 예제 
 * ServletConfig 는 ServletContext를 개별 서블릿에서 사용할 수 있도록 
 * 그 주소값을 저장하고 있다 
 * 필요시  ServletConfig 에 설정 정보를 저장하게 할 수도 있음 
 * 사례) Spring 의 DispatcherServlet 의 init(ServletConfig)  에 
 *          자신의 스프링 설정 파일 위치 정보를 전달할 수 있음. 
 */
@WebServlet(urlPatterns ="/config-test",
			initParams = {
					@WebInitParam(name="contextConfigLocation",value="/WEB-INF/springmvc-config.xml")
			}
		)
public class ServletConfigTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ServletConfig Study</title>");
		out.println("</head>");
		out.println("<body>");
		// web container 에 의해 init(ServletConfig) 호출시에 주입받았음 
		ServletConfig config=this.getServletConfig();
		// ServletConfig 가 사원(해당 Servlet)의 사원증이라고 하면 
		// ServletContext 는 그 사원이 속한 회사의 인트라넷이다 ( 공유 자원 ) 
		// ServletConfig 사원증을 가진 자 (Servlet) 만이 사내 인트라넷인 
		// ServletContext 를 이용할 수 있다 
		ServletContext context = config.getServletContext(); 
		out.println("<h3>Hello ServletConfig:"+config+"</h3>");
		out.println("<h3>Hi ServletContext:"+context+"</h3>");
		String springConfig=config.getInitParameter("contextConfigLocation");
		out.println("<strong>스프링 설정 파일 정보:"+springConfig+"</strong><br>");
		String securityInfo=
				this.getServletConfig().getServletContext().getInitParameter("securityConfigInfo");
		out.println("ServletContext의 securityInfo:"+securityInfo);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}



