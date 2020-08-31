package kr.co.ch02.sub1;

/*
 * 날짜 : 2020/08/31
 * 이름 : 최정한
 * 내용 : 스프링 Ioc 실습하기
 */
public class IoCTest {
	
	public static void main(String[] args) {
		
		// Ioc적용(DI기법)을 안할 경우
		TV lgTV = new LgTV();
		lgTV.power();
		lgTV.chUp();
		lgTV.soundUp();
		
		TV SamsungTV = new SamsungTV();
		SamsungTV.power();
		SamsungTV.chUp();
		SamsungTV.soundUp();
	}
}
