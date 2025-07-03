package objIOTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class FriendTest {

	public static void main(String[] args) throws Exception {
		// 직렬화가 되어 있어야 저장 가능
		FriendVO f1 = FriendVO.builder()
				.name("손오공")
				.birthday(LocalDate.of(1995, 12, 25))
				.phone("010-1234-5678")
				.build();
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("friend.dat"));

		oos.writeObject(f1);
		oos.close();
		
		System.out.println("========================");
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("friend.dat"));
		
		FriendVO ff = (FriendVO)ois.readObject();
		System.out.println(ff);
		
		
		
		
		
		
		
		
	}
}
