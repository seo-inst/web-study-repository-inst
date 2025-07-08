package org.kosa.job.model;

import java.util.ArrayList;
import java.util.List;

/**
 *  Singleton Design Pattern 
 *  : 시스템 상에서 단 한번 객체를 생성하여 
 *    공유해서 사용하는 디자인 패턴 -> 스프링에서 기본적으로 객체를 운용(매니징)하는 방식
 *    why?  서버 자원의 효율성 : 불필요하게 반복적으로 객체를 여러개 생성하지 않음으로 자원절약
 *    			실제로 스프링 bean(자바컴포넌트) ,  서블릿 이  컨테이너에 의해 싱글톤으로 매니징된다
 *    
 *    private  Constructor 
 *    private static 인스턴스 변수
 *    public static  메서드 
 */
public class NewsService {
	private static NewsService instance = new NewsService();
	private NewsService() { // 외부에서 객체 생성 못하게 원천 봉쇄 
		System.out.println(getClass()+" 단 한번 객체를 생성해 사용");
	}
	public static NewsService getInstance() {
		return instance;
	}
	public String findNewsById(int newsId) {
		return newsId+"번 뉴스 정보";
	}
	public void registerNews(String newsInfo) {
		System.out.println(getClass()+" "+newsInfo+" 등록");
	}
	public List<String> findNewsList() {
		List<String> list = new ArrayList<String>();
		list.add("1번 뉴스");
		list.add("2번 뉴스");
		list.add("3번 뉴스");
		return list;
	}
}





















