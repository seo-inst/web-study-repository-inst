package step1.test;

import java.util.Date;

public class TestTime {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString());// 쿠키는 공란을 허용하지 않음 
		System.out.println(date.toString().replace(" ", "-"));// 하이픈으로 대체 
	}
}
