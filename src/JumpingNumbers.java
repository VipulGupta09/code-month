import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {

	public static void main(String[] args) {
		int x = 30;
		
		System.out.println("0 ");
		
		for(int i=1;i<=x && i<=9;i++) {
			bfs(x, i);
		}

	}
	
	public static void bfs(int num, int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		
		while(!queue.isEmpty()) {
			i = queue.poll();
			if(i<=num) {
				System.out.println(i+" ");
				int last_digit = i%10;
				
				if(last_digit == 0) {
					queue.add((i*10)+(last_digit+1));
				}
				else if(last_digit == 9) {
					queue.add((i*10)+(last_digit-1));
				}
				else {
					queue.add((i*10)+(last_digit-1));
					queue.add((i*10)+(last_digit+1));
				}
			}
		}
	}

}
