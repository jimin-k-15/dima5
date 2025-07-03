package enumTest01;

public enum Season {
	봄, 여름, 가을, 겨울; 	// 데이터들끼리 있으면 ; 안 써도 되지만, 메소드를 추가하면 ; 써야 함
	
	Season() {
		System.out.println(this);
	}
}
