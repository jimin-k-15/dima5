package fileioTest;
/*
 * 한글로 되어있는 파일을 읽어 화면에 출력하기
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest_08 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("Hansong.txt"); 
		BufferedReader br = new BufferedReader(fr);
		
		while (true) {
			String data = br.readLine();			// 줄 단위로 읽어들이기
			if(data == null) break;
			System.out.println(data);
		}
		br.close();
	}
}




