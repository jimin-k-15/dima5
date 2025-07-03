package bank;

public class Account {
	private String accountNo;
	private String accountName;
	private int balance;
	
	// public Account() {}	// 기본생성자
	// ctrl + space 
	
	// getter
	public String getAccountNo() {
		return this.accountNo;
	}
	
	// setter
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	// 일반 method (static에서는 non-static에 접근 불가)
	
	public int deposit(int money) {
		this.balance += money;
		return this.balance;
	}
	
	public int withdraw(int money) {
		if(this.balance >= money) {
			this.balance -= money;
		} else {
			return -1;
		}
		return this.balance;
	}
	
	public String output() {
		String temp = this.accountNo + ":" + this.accountName + "==>" + this.balance + "원";
		return temp;
	}
	
	// 계좌번호, 계좌주, 잔액
	// 예금하다, 출금하다, 모든 멤버변수를 문자열로 바꾸는 메소드 
}
