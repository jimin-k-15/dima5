package test;	// 1개만

import vo.Pet;

public class PetTest {

	public static void main(String[] args) {
		Pet dog = new Pet();	// 기본생성자를 이용해서 객체 생성
		Pet cat = new Pet("다롱이", "샴고양이", 3);
		Pet bird = new Pet("까치", "앵무새", 10);
		
		dog.setName("우람이");
		dog.setKind("골든리트리버");
		dog.setAge(2);
		
		
		System.out.println(dog.output());
		System.out.println(cat.output());
		System.out.println(bird.output());
		
		System.out.println(); 			// 줄바꿈
		
		
		// ------------- 객체 배열 : 실제 데이터가 몇 개인지 기억해야 함!! -------------
		Pet[] pets = new Pet[10];		// 배열을 만든다!
		int count = 0;					// 데이터가 몇 개 저장되어 있는지 기억하는 변수
		
		pets[0] = new Pet("오월이", "푸들", 4);
		++count;
		
		pets[1] = new Pet("나비", "길고양이", 1);
		++count;
		
		pets[2] = new Pet("모모", "참새", 2);
		++count;
		
		// null ==> 참조하고 있지 않다. 
//		for(Pet myPet : pets)
//		System.out.println(myPet.output());
		
		for(int i=0; i<3; ++i)
			System.out.println(pets[i].output());	
		
	}

}
