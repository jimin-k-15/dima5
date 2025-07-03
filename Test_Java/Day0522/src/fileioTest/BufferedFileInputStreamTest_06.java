package fileioTest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedFileInputStreamTest_06 {

	public static void main(String[] args) {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("someonelikeyou.txt"));) {
			
			int data;
			int cnt = 0;		// 읽어들여야 하는 글자의 개수
			while(true) {
				data = bis.read();		// 반환되는 데이터에는 읽어들인 글자의 값이 int로 저장
				if(data == -1) break;
				++cnt;
				System.out.print((char)data);
			}
			System.out.println("\n총 글자수: " + cnt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}
}
