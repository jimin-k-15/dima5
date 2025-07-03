package Inherit;

public class VehicleMain {

	public static void main(String[] args) {
		
	     // Vehicle 호출하기
	     Vehicle v = new Vehicle(4, 4, 500);
	     v.output();
	     System.out.println();
	      
	     Bus b = new Bus("157");
	     b.output();           // 자기 자신의 것 출력
//	     b.output();              // 부모한테서 받은것 출력 => outputBus()에 부모한테서 받은거 출력을 포함하면 생략 가능
	     System.out.println();
	      
	     Truck t = new Truck(6, 5, 1500, 500);
	      t.output();
	}
}
