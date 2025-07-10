package org.kosa.myproject.controller;

import java.lang.reflect.InvocationTargetException;

/**
 * 	    Factory Design Pattern 
 * 		요청 처리 객체들을 전담해서 생성하는 Factory 객체 
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return instance;
	}
	public Controller create(String command) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {// throws 각종 Exception 
		Controller controller = null;
		// 동적 팩토리 구현 
		StringBuilder packageAndClassInfo = new StringBuilder(this.getClass().getPackageName());
		packageAndClassInfo.append(".").append(command).append("Controller");
		controller = (Controller) Class.forName(packageAndClassInfo.toString()).getDeclaredConstructor().newInstance();
		return controller;
	}
// 아래는 정적 팩토리 :  컨트롤러 구현체들이 신규로 정의될때마다 직접 구현체 생성 코드를 작성해야
//  한다 
// command 에 의거해서 적절한 담당 컨트롤러 객체를 생성해 반환하는 메서드 
//	public Controller create(String command) {
//		Controller controller = null;
//		if (command.equals("findbyid")) {
//			controller = new FindCustomerByIdController();
//		}else if(command.equals("registerCustomer")) {
//			controller = new RegisterCustomerController();
//		}else if(command.equals("updateCustomer")) {
//			controller = new UpdateCustomerController();
//		}
//		return controller;
//	}
}






