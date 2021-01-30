package javaconcepts;

//A Java program to demonstrate shallow copy 
//using clone() 
import java.util.ArrayList; 

//An object reference of this class is 
//contained by Test2 
class Test 
{ 
	 int x, y; 
	
	public Test(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	public String toString() {
		return x+" "+y; 
	}
	
} 

//Contains a reference of Test and implements 
//clone with shallow copy. 
class Test2 implements Cloneable 
{ 
	 int a,b;
	Test test;
	public Test2(int a, int b, Test test) {
		this.a = a;
		this.b = b;
		this.test = test;
	}
	
	public Object clone() throws
				CloneNotSupportedException 
	{ 
		 Test test1 = new Test(test.x, test.y); 
		 Test2 test2 = new Test2(a, b, test1);
		 return test2;
	} 
	@Override
	public String toString() {
		return a+" "+b+ " "+test; 
	}


	public void setTest(Test test) {
		this.test = test;
	}
	
} 

//Driver class 
public class Main 
{ 
	public static void main(String args[]) throws
						CloneNotSupportedException 
	{ 
	Test test = new Test(10,20);
	Test2 t1 = new Test2(30,40,test); 

	Test2 t2 = (Test2)t1.clone(); 
	t2.a = 300;;
	t2.b = 400;
	t2.test.x=100;
	t2.test.y=200;
	
	System.out.println(t1);
	System.out.println(t2);
	 
	
	} 
	
} 
