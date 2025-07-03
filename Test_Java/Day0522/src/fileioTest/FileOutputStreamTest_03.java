package fileioTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest_03 {

	public static void main(String[] args) {
		try (FileOutputStream fos = new FileOutputStream(new File("target.txt")))  {	
	
			for(int i='A'; i<'z'; ++i) {
				fos.write(i);
			}
			System.out.println("끝!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


