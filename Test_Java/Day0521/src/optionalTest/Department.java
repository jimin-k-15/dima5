package optionalTest;

public class Department {
	private String departName;
	private String city;
	private String zipcode;

	public Department() {}

	public Department(String departName, String city, String zipcode) {
		super();
		this.departName = departName;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Department [departName=" + departName + ", city=" + city + ", zipcode=" + zipcode + "]";
	}
	
	
}
