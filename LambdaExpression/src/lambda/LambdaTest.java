package lambda;

@FunctionalInterface
interface PrintString {
	
	void showString(String str);
}


public class LambdaTest {

	public static void main(String[] args) {
		//람다식 - 매개 변수 1개이면 괄호 생략 가능
		PrintString lambdaPrint = str -> System.out.println(str);
		lambdaPrint.showString("안녕하세요");
		
		//함수 호출
		printString(lambdaPrint);
		
		PrintString printStr = returnPrint();
		printStr.showString("안녕하세요~");
	}
	
	
	//매개 변수가 함수형 인터페이스형 객체
	public static void printString(PrintString p) {
		p.showString("안녕하세요!");
	}
	
	//반환형이 함수형이 인터페이스인 return이 있는 메서드
	public static PrintString returnPrint() {
		return str -> System.out.println(str);
	}

}
