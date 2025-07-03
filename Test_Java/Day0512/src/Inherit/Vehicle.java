package Inherit;

public class Vehicle {
	private int numberOfWheels;
	private int numberOfSeat;
	private double weight;
	
	public Vehicle() {}

	public Vehicle(int numberOfWheels, int numberOfSeat, double weight) {
		super();
		this.numberOfWheels = numberOfWheels;
		this.numberOfSeat = numberOfSeat;
		this.weight = weight;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public int getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void output() {
		System.out.println("Vehicle=" + numberOfWheels + ", " + numberOfSeat + ", " + weight);
	}

	@Override
	public String toString() {
		return "Vehicle [numberOfWheels=" + numberOfWheels + ", numberOfSeat=" + numberOfSeat + ", weight=" + weight
				+ "]";
	}
	
}
