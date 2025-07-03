package fileioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest_02 {

	public static void main(String[] args) {
		File file = new File("song.txt");		// stream으로는 영문만 읽을 수 있음. 한글까지 읽으려면 read 써야 함. 
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			
			int data;
			byte[] buffer = new byte[50];
			
			int cnt = 0;				// loop를 몇 번 도는지 확인하기 위한 변수
			while(true) {
				data = fis.read(buffer);		// 최대 50글자를 읽어 buffer에 저장, data는 읽은 글자 수
				
				for(int i=0; i<data; ++i) 
					System.out.println(buffer[i]);
				
				++cnt;
				if(data < buffer.length) break;
			}
			System.out.println("\n총 Loop수: " + cnt);
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
