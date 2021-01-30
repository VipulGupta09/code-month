package javaconcepts;

class Address {
	private String streetName;
	private int pinCode;
	private String city;

	public Address(int pinCode, String city, String streetName) {
		this.pinCode = pinCode;
		this.city = city;
		this.streetName = streetName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return this.streetName + " " + this.city + " " + this.pinCode;
	}
}

class Person implements Cloneable {
	private String name;
	private int id;
	private Address address;

	public Person(String name, int id, Address address) {
		this.name = name;
		this.id = id;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return this.name + " " + this.id + " " + this.address.toString();
	}
}

public class ObjectClassCloneMethod {

	public static void main(String[] args) throws CloneNotSupportedException {
		Address address = new Address(560078, "Bangalore", "JP Nagar");
		Person pd1 = new Person("Vipul", 1, address);
		Person pd2 = (Person) pd1.clone();
		
		
		pd2.setId(2);
		pd2.setName("Gupta");
		pd2.setAddress(new Address(250002, "Meerut", "Westend Colony"));

		System.out.println(pd1);
		System.out.println(pd2);
		System.out.println(pd1);

	}

}
