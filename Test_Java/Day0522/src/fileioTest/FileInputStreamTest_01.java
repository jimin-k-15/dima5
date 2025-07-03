package fileioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest_01 {

	public static void main(String[] args) {
		File file = new File("song.txt");		// stream으로는 영문만 읽을 수 있음. 한글까지 읽으려면 read 써야 함. 
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			
			int data;
			int cnt = 0;		// 읽어들여야 하는 글자의 개수
			while(true) {
				data = fis.read();		// 반환되는 데이터에는 읽어들인 글자의 값이 int로 저장
				if(data == -1) break;
				++cnt;
				System.out.print((char)data);
			}
			System.out.println("\n총 글자수: " + cnt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
