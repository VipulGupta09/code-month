

// 13 add 1+3 = 4
// 48 add 4+8 = 12 -> 1+2=3


// weith same 
// 3 boxes weight same
// blue black mix
// label are incorrect

// W
// Blue Black Mix
// 1 - Black
// 1 - blue  -> Mix


public class Main {
//	static int sum = 0;
	public static void main(String[] args) {
		String str ="48";
	//	find(str);
		optimize(48);
	}
	
	// 4+8 = 12
	// n*n
	public static void find(String str) {
		int sum = 0;
		while(str.length()!=1) {
			 sum = 0;
			for(int i=0;i<str.length();i++) {
				char ch =  str.charAt(i);
				sum += (int)ch - 48;	
			}
			str = String.valueOf(sum);
		}
		System.out.println(sum);
	}
	
	// 48 -> 8+4 = 12
	public static void optimize(int num) {
		int sum = 0;
		while(num>0 || sum >9) {
			if(num==0) {
				num = sum;
				sum=0;
			}
			 sum += num%10;
			 num=num/10;
		}
		System.out.println(sum);
				
	}
	
}
