package fileioTest;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterTest_09 {

	public static void main(String[] args) throws Exception {
//		Scanner keyin = new Scanner(System.in);
//		BufferedReader bis = new BufferedInputStream(System.in); 
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));
		
		String name = "길동이";
		int kor = 89;
		int eng = 88;
		
		String data = String.format("%s 국어: %3d, 영어: %3d, 평균: %6.2f\n", 
				name, kor, eng, (kor + eng) / 2.0);
		
		bw.write(data);
		System.out.println(data);
		
		bw.close();
		
		System.out.println("종료");
	}
}
