package streamex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		/*
		List<String> companyList = new ArrayList<>();
		companyList.add("LG");
		companyList.add("Samsung");
		companyList.add("Hyundai");
		*/
		
		
		//배열을 처리하는 클래스 (Arrays)
		List<String> companyList = Arrays.asList("LG","Samsung","Hyundai");
		//String[]companyList2 = new String[] {"LG","Samsung","Hyundai"};
		
		for(String company : companyList) {
			System.out.println(company);
		}
		
		System.out.println("********");
		
		//stream 클래스 - 람다식으로 구현
		Stream<String> stream = companyList.stream();
		stream.forEach(company -> System.out.println(company));
		
		
	}

}
