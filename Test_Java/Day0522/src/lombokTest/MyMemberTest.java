package lombokTest;

public class MyMemberTest {

	public static void main(String[] args) {
		MyMember m = new MyMember(0, null, null, null, null, null);
		System.out.println(m);
		
		// 이 방법을 더 선호
		MyMember m1 = MyMember.builder()
				.id(12)
				.name("김유신")
				.address("서울시 강남구")
				.gender("남성")
				.job("기획홍보")
				.birthday(LocalDate.now())
				.build();
		System.out.println(m1);
	}
}
