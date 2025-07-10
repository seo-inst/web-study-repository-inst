package org.kosa.myproject.model;
/*
 *  Singleton Design Pattern :  시스템 상에 단 한번 객체 생성하여 사용하는 패턴 
 *  스프링에서 기본적으로 객체를 매니징하는 패턴 
 *  
 *  Mock : 가짜 , 모의 ,  테스트를 위한 모의 객체를 명명할 때 관례적으로 사용 
 */
public class MockDao {
	private static MockDao instance = new MockDao();
	private MockDao() {}
	public static MockDao getInstance() {
		return instance;
	}
	public CustomerVo  findCustomerById(String id) {
		CustomerVo vo=null;
		if(id!=null&&id.equals("java"))
			vo = new CustomerVo(id,"손흥민","런던");
		return vo;
	}
	public void registerCustomer(CustomerVo customerVo) {
		System.out.println(getClass()+" 고객정보를 등록 "+customerVo);
	}
	public void updateCustomer(CustomerVo customerVo) {
		System.out.println(getClass()+" 고객정보를 수정 "+customerVo);
	}
	public void deleteCustomer(String id) {
		System.out.println(getClass()+" 고객정보를 삭제 "+id);
	}
}


















