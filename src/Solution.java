import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue < Integer > queue = new PriorityQueue < > ((a, b) -> b - a);
        int time = 0;
        for (int[] c: courses) {
            if (time + c[0] <= c[1]) {
                queue.offer(c[0]);
                time += c[0];
            } else if (!queue.isEmpty() && queue.peek() > c[0]) {
                time += c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }
    public static void main(String[] args) {
		int[][] arr= {{2,5},{2,19},{1,8},{1,3}};
		//scheduleCourse(arr);
		String str = "apple";
		String s1 = str.substring(0, 1);
		String s2 = str.substring(4,5);
	}
}