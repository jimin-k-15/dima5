package lambdaTest;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MyMember {
	private String name;
	private String gender;
	private double height;
	private double weight;
	
	// 생성자 2종류
	public MyMember() {}
	
	public MyMember(String name, String gender, double height, double weight) {
		super();
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	
	// 표준 체중 계산
	
	public double calcStdWeight(Function<Double, Double> f) {
		return f.apply(this.height);
	}
	
	// BMI 계산
	
	public double calcBMI(BiFunction<Double, Double, Double> f) {
		return f.apply(this.height, this.weight);
	}

	@Override
	public String toString() {
		return "MyMember [name=" + name + ", gender=" + gender + ", height=" + height + ", weight=" + weight + "]";
	}
}
