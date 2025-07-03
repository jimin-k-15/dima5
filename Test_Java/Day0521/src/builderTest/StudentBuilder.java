package builderTest;

// Student를 생성하고 초기화하는 Builder 객체 선언
	class StudentBuilder {
	    private int id;
	    private String name;
	    private String grade;
	    private String phoneNumber;
	    
	    public StudentBuilder id(int id) {
	        this.id = id;					// getter처럼 보이지만 아님.
	        return this;					// 빌더 객체 자신을 리턴함으로써 메서드 호출 후 연속적으로 빌더 메서드들을 체이닝(Chaining) 하여 호출할 수 있게 된다. 
	        								// ex) new StudentBuilder().id(값).name(값)
	    }

	    public StudentBuilder name(String name) {
	        this.name = name;
	        return this;
	    }

	    public StudentBuilder grade(String grade) {
	        this.grade = grade;
	        return this;
	    }

	    public StudentBuilder phoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	        return this;
	    }

	    public Student build() {
	        return new Student(id, name, grade, phoneNumber); // Student 생성자 호출
	    }
}
