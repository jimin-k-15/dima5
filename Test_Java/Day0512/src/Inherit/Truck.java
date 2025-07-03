package Inherit;

public class Truck extends Vehicle {
	private int maxLoad;
	
	public Truck() {
		super();
	}

	public Truck(int maxLoad) {
		super();
		this.maxLoad = maxLoad;
	}
	
	public Truck(int numberOfWheels, int numberOfSeat, double weight, int maxLoad) {
		super(numberOfWheels, numberOfSeat, weight);
		this.maxLoad = maxLoad;
	}

	public int getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(int maxLoad) {
		this.maxLoad = maxLoad;
	}
	
	@Override
	public void output() {
		super.output();
		System.out.println("Truck="+ this.maxLoad);
	}

	@Override
	public String toString() {
		return super.toString() + ", Truck [maxLoad=" + maxLoad + "]";
	}
}

