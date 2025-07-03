package builderTest;

public class StudentTest {

	public static void main(String[] args) {
		Student s = new StudentBuilder()
                .id(2016120091)
                .name("임꺽정")
                .grade("Senior")
                .phoneNumber("010-5555-5555")
                .build();

    System.out.println(s);
    
    Student s2 = new Student(234512, "손오공", "1학년", "010-111");


	}
}
