package Inherit;

public class Bus extends Vehicle {
	private String busNumber;
	
	public Bus() { }

	public Bus(String busNumber) {
		super();
		this.busNumber = busNumber;
	}
	// 이 방법은 사용하지 마세요!
	public Bus(int numberOfWheels, int numberOfSeat, double weight, String busNumber) {
		super(numberOfWheels, numberOfSeat, weight);
		this.busNumber = busNumber;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	
	@Override
	public void output() {
		super.output();		// 부모가 물려준 원본을 호출. this를 사용하면 자기 자신이므로 무한 호출이 됨. 
		System.out.println("Bus="+ this.busNumber);
	}

	@Override
	public String toString() {
		String temp = super.toString();
		return temp +", Bus [busNumber=" + busNumber + "]";
	}
	
	
}
