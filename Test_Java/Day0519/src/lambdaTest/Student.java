package lambdaTest;

import java.util.Comparator;

public class Student implements Comparator<Student> {
	private String name;
	private int score;
	
	public Student() {}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.score > o2.score) return 1;
		else if(o1.score < o2.score) return -1;
		
		return 0;
	}
}
