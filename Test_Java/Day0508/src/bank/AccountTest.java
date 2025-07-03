package bank;

public class AccountTest {

	public static void main(String[] args) {
		Account m1 = new Account();	 
		
		m1.setAccountNo("1234");
		m1.setAccountName("이몽룡");
		
		m1.deposit(10000);
		System.out.println(m1.output());
		
		Account w1 = new Account();
		w1.setAccountNo("4545");
		w1.setAccountName("성춘향");

		w1.deposit(1500000);
		System.out.println(w1.output());
	}

}
