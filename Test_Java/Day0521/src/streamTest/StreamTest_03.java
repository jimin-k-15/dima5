package streamTest;

import java.util.List;
import java.util.stream.Stream;

class Student {
	String name;
	int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
}

public class StreamTest_03 {
	public static void main(String[] args) {
		// [문제-1]
		// 5명의 학생 정보를 저장하는 리스트를 Stream으로 변환하시오.
		// 5명의 학생 중에서 점수가 80점 이상인 학생들의 정보만
		// 다시 추출해서 List로 변환하시오.
		
		// 1) 5명의 학생 정보 저장
		List<Student> list = List.of(
				new Student("손오공", 85),
				new Student("저팔계", 70),
				new Student("사오정", 90),
				new Student("파오리", 78),
				new Student("잠만보", 95));	
			
		// Stream으로 변환 후 점수 80점 이상 필터링하여 List로 변환
		Stream<Student> sData = list.stream();
		
		List<Student> finalList = 
				sData.filter((x) -> x.score >= 80).toList();
		
		
		// [문제-2]
		// 위에서 list를 이용해서 다시 스트림으로 만든 다음
		// 합격자(80점 이상)의 인원수를 출력하시오.
		
		long cnt = list.stream().filter((x) -> x.score >= 80).count();
		System.out.println("합격자 수: " + cnt);
	}
}


