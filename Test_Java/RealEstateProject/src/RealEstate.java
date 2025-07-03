
public class RealEstate {
	private String address;
	private String houseType;
	private int size;
	
	public RealEstate() {}
	
	public RealEstate(String address, String houseType, int size) {
		super();
		this.address = address;
		this.houseType = houseType;
		this.size = size;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void output() {
		System.out.println("RealEstate=" + address + ", " + houseType + ", " + size);
	}

	@Override
	public String toString() {
		return "RealEstate [address=" + address + ", houseType=" + houseType + ", size=" + size + "]";
	}
	
	
	
	
	
	
}
