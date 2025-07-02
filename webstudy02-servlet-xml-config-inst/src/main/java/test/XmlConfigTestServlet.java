package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XmlConfigTestServlet
 */
public class XmlConfigTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public XmlConfigTestServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답시 컨텐트 타입을 설정 , 브라우저에서 지금 응답은 HTML 문서야 라고 
				// 메세지를 보내기 위함 
				response.setContentType("text/html;charset=UTF-8");
				// HTML 을 브라우저로 전송하기 위한 출력 스트림 
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>web.xml config Servlet Study</title>");
				out.println("</head>");
				out.println("<body bgcolor=orange>");
				out.println("<h3>xml 로 메타데이터가 설정된  Servlet 입니다</h3>");
				out.println("</body>");
				out.println("</html>");
				out.close();
	}

}
