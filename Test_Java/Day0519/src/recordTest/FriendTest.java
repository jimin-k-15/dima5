package recordTest;

public class FriendTest {

	public static void main(String[] args) {
		Friend f1 = new Friend("홍길동", 24);
		System.out.println(f1);
		
		String n = f1.name();
		int    a = f1.age();
		System.out.println("이름: " + n +", 나이:" + a);
		
		Friend f2 = new Friend("홍길동", 24);
		System.out.println(f1.equals(f2));
	}

}
