package array;

 class  Address implements Cloneable{
	private String city;
	private int zipCode;
	private int streetNum;
	
	
	
	public Address(String city, int zipCode,int streetNum) {
		this.city = city;
		this.zipCode = zipCode;
		this.streetNum = streetNum;
	}

	public String getCity() {
		return city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public int getStreetNum() {
		return streetNum;
	}
	
	public Address clone() throws CloneNotSupportedException {
		return (Address)super.clone();
	}
		
}

final class Student{
	private int roolNum;
	private String name;
	
	private Address address;
	
	public Student(int roolNum, String name, Address address) throws CloneNotSupportedException {
		this.roolNum = roolNum;
		this.name = name;
		
		this.address = address.clone();
	}

	public int getRoolNum() {
		return roolNum;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() throws CloneNotSupportedException {
		return address.clone();
	}

	
}


public class ImmutableClass {

	public static void main(String[] args) throws CloneNotSupportedException {
		Address address = new Address("ABC", 560078, 5);
		Student student = new Student(1, "Jack", address);
		
		
		

	}

}
