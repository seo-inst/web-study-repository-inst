package org.kosa.myproject.test3;

import java.lang.reflect.InvocationTargetException;

/**
 *   Reflection API : 런타임시 동적 객체 생성 , 제어 
 *   이번 테스트 예제의 목적은 패키지명을 동적으로 가져와
 *   이후 패키지명이 변경되더라도 동작되는 데 문제가 없도록 구성 
 */
public class ReflectionAPIPackageUnitTest2 {
	public Player autoCreate(String command) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Player player = null;
		// 현재 실행중인 객체의 패키지명을 가져와본다 
		StringBuilder packageAndClassName=new StringBuilder(this.getClass().getPackageName());
		packageAndClassName.append(".").append(command);
		System.out.println(packageAndClassName);
		player = (Player) Class.forName(packageAndClassName.toString()).getDeclaredConstructor().newInstance();
		return player; 
	}
	public static void main(String[] args) {
		ReflectionAPIPackageUnitTest2 factory = new ReflectionAPIPackageUnitTest2();
		String command = "Youtube";
		command ="CDPlayer";
		Player player;
		try {
			player = factory.autoCreate(command);
			System.out.println("Reflection API를 이용해 동적으로 객체를 생성 "+player);
			player.play();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
}







