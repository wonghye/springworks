package lambda;

@FunctionalInterface
public interface StringConcat {
	
	//문자를 연결하는 추상 메서드
	public void makeString(String s1, String s2);
	
}
