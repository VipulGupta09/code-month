package javaconcepts;

public class ObjectClassMethods {
	private String name;
	private int rollNo;

	public ObjectClassMethods(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return name + " " + rollNo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof ObjectClassMethods) {
			ObjectClassMethods obj1 = (ObjectClassMethods) obj;
			if (obj1.name.equals(this.name) && obj1.rollNo == this.rollNo) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+rollNo;
		
	}

	public static void main(String[] args) {

		ObjectClassMethods obj1 = new ObjectClassMethods("ABCD", 10);
		ObjectClassMethods obj2 = new ObjectClassMethods("EFGH", 11);
		ObjectClassMethods obj3 = new ObjectClassMethods("IJKL", 12);
		ObjectClassMethods obj4 = new ObjectClassMethods("ABCD", 10);
		ObjectClassMethods obj5 = obj1;
		ObjectClassMethods obj6 = null;
		
		

		System.out.println(obj1.equals(obj5));// true
		System.out.println(obj1.equals(obj2));// false
		System.out.println(obj1.equals(obj3));// false
		System.out.println(obj1.equals(obj4));// true

		System.out.println(obj2.equals(obj3));// false
		System.out.println(obj1.equals(obj4));// true
		System.out.println(obj1.equals(obj6));// false

		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		System.out.println(obj4.hashCode());
		System.out.println(obj5.hashCode());
		
		//System.out.println(obj6.hashCode());
	}
}
