package org.kosa.myproject.controller;
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
	// command 에 의거해서 적절한 담당 컨트롤러 객체를 생성해 반환하는 메서드 
	public Controller create(String command) {
		Controller controller = null;
		if (command.equals("findbyid")) {
			controller = new FindCustomerByIdController();
		}else if(command.equals("registerCustomer")) {
			controller = new RegisterCustomerController();
		}else if(command.equals("updateCustomer")) {
			controller = new UpdateCustomerController();
		}
		return controller;
	}
}






