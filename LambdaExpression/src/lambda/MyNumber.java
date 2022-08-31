package lambda;

@FunctionalInterface
public interface MyNumber {
	
	//매개변수가 2개이고 return이 있는 추상 함수
	public int getMax(int n1, int n2);
}
