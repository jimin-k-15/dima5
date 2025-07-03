package lambdaTest;

public class Runner implements Comparable<Runner> {
	private String name;
	private double time;
	
	public Runner() {}

	public Runner(String name, double time) {
		super();
		this.name = name;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Runner [name=" + name + ", time=" + time + "]";
	}

	// 
	@Override
	public int compareTo(Runner o) {
		return this.time > o.time ? 1 : this.time < o.time ? -1 : 0 ;
	}
	
	
	
	
}
