package org.kosa.job.controller;

import java.io.IOException;
import java.util.List;

import org.kosa.job.model.NewsService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Controller 에서 View 제어 이동 ( forward 연습 ) 
 */
@WebServlet("/NewsList")
public class NewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = NewsService.getInstance().findNewsList();
		request.setAttribute("newsList", list);
		// 뉴스 리스트를 클라이언트에게 보여주면 되므로 
		// request 에 공유하여 응답하는 것이 가장 적절.
		// request 가 유지되면서 제어 이동하는 방식이 forward 방식이다 
		request.getRequestDispatcher("news-list.jsp").forward(request, response);
	}
}














