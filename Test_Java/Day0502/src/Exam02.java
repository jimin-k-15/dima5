
public class Exam02 {

	public static void main(String[] args) {
		int[] data = {5, 1, 7, 14, 6, 23, 8, 2, 9, 10}; 
		int temp;
		
		// 정렬 전 출력
		System.out.println("** 정렬 전");
		for(int i=0; i<data.length; ++i) {
			System.out.print(data[i] + "  ");
		}
		System.out.println();
		
		// 내림차순 정렬 (교환정렬) ==> 빅오표기법
		for(int i=0; i<data.length; ++i) {
			for(int j = i; j<data.length-1; ++j) {			
				if(data[i] < data[j+1]) {
					temp = data[i];
					data[i] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
		
		// 정렬 후 출력
		System.out.println("** 정렬 후");
		for(int i=0; i<data.length; ++i) {
			System.out.print(data[i] + "  ");
		}
		System.out.println();
				
	}
}
