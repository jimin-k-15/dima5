package baseball.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import baseball.sevice.BaseballService;
import baseball.sevice.BaseballServiceImpl;
import baseball.vo.Batter;
import baseball.vo.Pitcher;
import baseball.vo.Player;
/**
 * 사용자 인터페이스
 */
public class BaseballUI {
   Scanner input = new Scanner(System.in);
   BaseballService service = new BaseballServiceImpl();
   
   /**
    * 생성자
    */
   public BaseballUI() {
      int menuNum = 0;
      
      //프로그램 종료시까지 무한 반복
      while (true) {
         try {
            printMainMenu();
            menuNum = input.nextInt();
            
            switch(menuNum) {
            case 1: add(); break;
            case 2: delete(); break;
            case 3: update(); break;
            case 4: search(); break;
            case 0: 
               System.out.println("프로그램을 종료합니다.");
               return;
            default:
               System.out.println("[오류] 다시 선택해 주세요.\n");
            }
         } catch(Exception e) {
            System.out.println("[오류] 입력 형식이 잘못되었습니다.\n");
            input.nextLine();
         }
      }
   }
   
   /**
    * 메인 메뉴 출력
    */
   public void printMainMenu() {
      System.out.println("[ 야구 선수 정보 관리 ]");
      System.out.println(" 1. 선수 정보 입력 ");
      System.out.println(" 2. 선수 정보 삭제 ");
      System.out.println(" 3. 선수 정보 수정 ");
      System.out.println(" 4. 검  색 ");
      System.out.println(" 0. 프로그램 종료 ");
      System.out.print(" ** 번호 선택 > " );
   }
   
   /**
    * 선수 정보 입력(타자, 투수)
    */
   public void add() {
      int menuNum;
      // 입력을 받기 위한 지역변수 (Player)
      String id, name, team;
      int salary;
      double war;
      
      // 투수 정보 
      double era;
      int inning, wins, losses, save, hold;
      
      // 타자 정보
      double average;
      int atbat, rbi, score;
      
      boolean result;
      
      while(true) {
         System.out.println("[ 선수 등록 ] ");
         System.out.println(" 1. 투 수  ");
         System.out.println(" 2. 타 자  ");
         System.out.println(" 0. 돌아가기 ");
         System.out.print(" ** 선수 구분 선택 > ");
         
         try {
            menuNum = input.nextInt();
            if(menuNum == 0) return;
            
            // 선수정보 입력(공통데이터)
            System.out.print(" 선수 고유 번호 >"); id = input.next(); 
            
            // 동일한 등록번호가 있는지 확인하는 작업 필요
            Player player = service.searchId(id);
            
            // null인 경우는 동일한 등록번호가 없다는 뜻이므로 계속 진행
            if(player !=  null) {
               System.out.println("[오류] 이미 존재하는 번호입니다.");
               continue;
            }
            
            System.out.print(" 선수 이름 >");   name = input.next();
            System.out.print(" 소속팀 >");     team = input.next();
            System.out.print(" 연봉 >");     salary = input.nextInt();
            System.out.print(" WAR >");       war = input.nextDouble();
            
            
         
            
            switch(menuNum) {
            case 1: 
               // pitcher 투수 정보
               System.out.print(" 평균자책 >");     era = input.nextDouble();
               System.out.print(" 이닝 >");       inning = input.nextInt();
               System.out.print(" 승 >");       wins = input.nextInt();
               System.out.print(" 패 >");       losses = input.nextInt();
               System.out.print(" 세이브 >");       save = input.nextInt();
               System.out.print(" 홀드 >");       hold = input.nextInt();
               
               Pitcher pitcher = new Pitcher(id, name, team, salary, war, era, inning, wins, losses, save, hold);
               result = service.insertPlayer(pitcher);
               
               if(result) {
                  System.out.println("[정보] 저장되었습니다.");
               }
               
               
               break;
            case 2: 
               // Batter 타자 정보 
               System.out.print(" 타율 >");      average = input.nextDouble();
               System.out.print(" 타수 >");       atbat = input.nextInt();
               System.out.print(" 타점 >");       rbi = input.nextInt();
               System.out.print(" 득점 >");       score = input.nextInt();
                        
               // 객체 생성 
               Batter batter = new Batter(id, name, team, salary, war, average, atbat, rbi, score);
               result = service.insertPlayer(batter);
               
               if(result) {
                  System.out.println("[정보] 저장되었습니다.\n");
               }
               
               break;
            default: 
               System.out.println("[오류] 다시 선택하세요.\n");
            } // end switch
         
         } catch (Exception e) {
            input.nextLine();
            System.out.println("[오류] 잘못된 정보가 입력되었습니다.\n");
         } // end try
      }   // end while 
   }
   
   /**
    * 선수 정보 삭제
    */
   public void delete() {
	   String id;
	   System.out.println("[ 선수 삭제 ] ");
       System.out.print(" ** 삭제할 선수 번호 >"); 
       id = input.next(); 
       
       boolean result = service.deletePlayer(id);
       if(result) {
    	   System.out.println("[정보] 삭제되었습니다. \n");
       } else {
    	   System.out.println("[정보] 삭제대상이 존재하지 않습니다. \n");
       }
   }
   
   /**
0    * 선수 정보 수정
    */
   public void update() {
	   String id;
	   int salary = 0;
	   
	   System.out.println("[ 선수 수정 ] ");
	   System.out.print  (" ** 수정할 선수 번호: ");
	   id = input.next();
	   
	   Player player = service.searchId(id);
	   
	   if(player == null) {
		   System.out.println("[오류] 해당 번호의 선수정보가 없습니다.");
		   return;
	   }
	   
	   try {
		   System.out.println(" ** 수정할 선수 연봉: ");
		   salary = input.nextInt();
	   
	   } catch (Exception e) {
		   input.nextLine();
		   System.out.println("[오류] 잘못된 정보가 입력되었습니다.\n");
	   }
	   
	   player.setId(id);
	   player.setSalary(salary);
	   
	   
	   boolean result = service.updatePlayer(player);
	   if(result) {
		   System.out.println("[정보] 수정되었습니다.\n");
	   } else {
		   System.out.println("[오류] 수정이 되지 않았습니다.\n");
	   }
	   
   }
   
   /**
    * 선수 정보 검색
    */
   public void search() {
	   int menuNum;
	   int minSalary, maxSalary;
	   
	   List<Player> list = null;
	   
	   while(true) {
		   subMenu();
		   
		   menuNum = input.nextInt();
		   if(menuNum == 0) return; 
		   
		   switch(menuNum) {
		   case 1: 
			   list = service.playerListForType(1);		// 전체 조회
			   break;
		   case 2: 
			   list = service.playerListForType(2); 	// 투수 조회
			   break;
		   case 3: 
			   list = service.playerListForType(3); 	// 타자 조회
			   break;
		   case 4: 
			   list = service.bestPlayers();
			   break;
		   case 5: 
			   System.out.print("최저 연봉: ");  minSalary = input.nextInt();
			   System.out.print("최고 연봉: ");  maxSalary = input.nextInt();
			   list = service.playerListForSalary(minSalary, maxSalary);
			   break;
			   
		   }  // end switch
		   print(list);
	   }  // end while
	  
   }
   
   private void subMenu() {
	      System.out.println("[ 검색 ]");
	      System.out.println(" 1. 전체 ");
	      System.out.println(" 2. 투수 ");
	      System.out.println(" 3. 타자 ");
	      System.out.println(" 4. 베스트 플레이어 ");
	      System.out.println(" 5. 연봉 검색 ");
	      System.out.println(" 0. 돌아가기 ");
	      System.out.print(" ** 번호 선택 > " );
	
}

   // 목록 출력 (+ Collections.sort)를 사용해서 정렬해서 출력하는 코드로 수정
   // 시험 출력
   // 연봉의 내림차순으로 출력할지, 이름순으로 출력할지 결정하는 코드
   public void print(List<Player> list) {
	   int menuNum = 0;
       System.out.print("\n1) 연봉순 출력 2) 이름순 출력: ");   
       
       try {
	       menuNum = input.nextInt();
	       
	       switch(menuNum) {
	       case 1:
	   		Collections.sort(list, (a, b) -> a.getSalary() < b.getSalary() ? 1
					   : a.getSalary() > b.getSalary() ? -1 : 0); // 오름차순, 내림차순 바꾸고 싶으면 부등호 방향 바꾸기
	
			for(Player p : list)
				System.out.println(p);
	   		// list.forEach((x) -> System.out.println(x));
			System.out.println();
			break;
	       case 2:
	   		Collections.sort(list, (a, b) -> a.getName().compareTo(b.getName()) > 1 ? 1
					   : a.getName().compareTo(b.getName()) < -1 ? -1 : 0); // 오름차순
	
	   		list.forEach((x) -> System.out.println(x));
	   		System.out.println();
	    	   break;
	       }
       } catch(Exception e) {
    	   e.printStackTrace();
    	   input.nextLine();
    	   System.out.println("[오류] 메뉴 선택을 다시 하세요.\n");
       }
   }
   
   /**
    * 프로그램 종료
    */
   public void exit() {
	   
   }
   
}