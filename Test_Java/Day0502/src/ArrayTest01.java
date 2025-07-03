// 선형자료구조 : 배열

public class ArrayTest01 {

	public static void main(String[] args) {
		int[] ary = new int[10];  // 프로그램이 시작되고 난 후에 run time 시에는 방 크기 조절 불가
		
		System.out.println("방의 개수: " + ary.length);
		System.out.println("ary의 값: " + ary);         // hash 주소값
		
		System.out.println("ary[0]의 값: " + ary[0]);   // heap 영역의 데이터는 기본값으로 초기화
		
		ary[0] = 2;    // 2 0 0 0 0 0 0 0 0 0
		ary[1] = 4;    // 2 4 0 0 0 0 0 0 0 0
	}

}
