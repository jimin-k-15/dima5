package fileioTest;

/*
 * 한글로 되어있는 파일을 읽어 화면에 출력하기
 */
import java.io.FileReader;

public class ReaderTest_07 {
	public static void main(String[] args) {
//		System.out.println("실행 경로: " + System.getProperty("user.dir"));
		try(FileReader fr = new FileReader("Hansong.txt")) {
			char[] buffer = new char[50];	
			int count = 0;	
		
			while(true) {
				count = fr.read(buffer);	// 128 ==> 50 50 28
				print(buffer, count);
				if(count<buffer.length) break;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void print(char[] buffer, int count) {
		for(int i=0; i<count; ++i)
			System.out.print(buffer[i]);
	}
}




