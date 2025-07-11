package org.kosa.myproject.controller;

import java.lang.reflect.InvocationTargetException;

/**
 *  Factory Design Pattern : 객체 생성을 전담하는 설계 패턴 
 *  										 구체적 객체 생성부를 캡슐화 
 *  HandlerMapping :  요청(request or command) 처리를 위한 
 *  							  각 컨트롤러 객체 생성을 전담하는 
 *  							  Factory class 
 *  							  Spring 에서 동일한 이름으로 동일한 역할을 함
 *  
 *   일반적으로 Factory 는 시스템 상에서 단 하나만 존재하여 
 *   운영되므로 Singleton Pattern 을 적용한다 
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return instance;
	}
	/**
	 *  요청 command 에 의거해  요청을 처리할 구체적인 컨트롤러 객체 생성을 
	 *  전담하는 메서드 
	 *  
	 *  런타임시 동적으로 컨트롤러 객체를 생성하기 위해 Reflection API 를 이용  -> Dynamic Factory 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Controller create(String command) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		// 현재 위치의 package 와 class 정보를 저장하는 문자열 ( 동적으로 ) 
		StringBuilder packageAndClassInfo = new StringBuilder(this.getClass().getPackageName());
		packageAndClassInfo.append(".").append(command).append("Controller");
		return (Controller) Class.forName(packageAndClassInfo.toString()).getDeclaredConstructor().newInstance();
	}
}



















