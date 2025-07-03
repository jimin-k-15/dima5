package fileioTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyTest_04 {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("song.txt");
			 FileOutputStream fos = new FileOutputStream("song_copy.txt")) {	
			
			byte[] buffer = new byte[100];
			int count = 0;
			
			// 데이터가 254 ==> 루프를 2번 돌면서 200개 저장, 54
			while(true) {
				count = fis.read(buffer);
				
				if(count < buffer.length) {
					fos.write(buffer, 0, count);
					break;
				} else {
				fos.write(buffer);		// 위에서 읽은 데이터를 아래에서 저장
				}
			}
			
			System.out.println("복사 완료~!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

} // FileCopyTest_05 코드 (이미지 저장) 다운받고, 이미지 저장 오류 문제 해결하기 -> 오류는 해결!
