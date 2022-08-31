package lambda;

public class StringConcatTest {

	public static void main(String[] args) {
		
		System.out.println("***일반 구현 클래스***");
		StringConcat str = new StringConcatImpl();
		
		str.makeString("hill", "state");
		
		System.out.println("***람다식 구현 클래스***");
		StringConcat str2;
		str2 = (s1, s2) -> System.out.println(s1 + " " + s2);
		str2.makeString("힐", "스테이트");
	}
}
