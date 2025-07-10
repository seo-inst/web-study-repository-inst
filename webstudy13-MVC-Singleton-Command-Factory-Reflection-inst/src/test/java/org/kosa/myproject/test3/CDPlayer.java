package org.kosa.myproject.test3;

public class CDPlayer implements Player {
	public CDPlayer() {
		System.out.println("CDPlayer 생성");
	}
	@Override
	public void play() {
		System.out.println("CDPlayer가 CD 를 재생하다");
	}
}
