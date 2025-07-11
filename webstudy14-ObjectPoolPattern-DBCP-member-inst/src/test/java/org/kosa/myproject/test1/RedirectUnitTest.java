package org.kosa.myproject.test1;

public class RedirectUnitTest {
	public static void main(String[] args) {
		String url = "  redirect:register-result.jsp ";
		// 서두 prefix 가 redirect 로 시작되는 가? 
		System.out.println(url.trim().startsWith("redirect:"));
		// trim() : 양여백을 제거 
		System.out.println(url.trim().substring(9));
	}
}
