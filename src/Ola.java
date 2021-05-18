import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Ola {
	public static void main(String[] args) {
		int[] nums1 = { 150, 210, 210, 80, 110 };
		System.out.println(minSteps(nums1));
		int[] nums2 = { 843, 247 };
		System.out.println(minSteps(nums2));
		int[] nums3 = { 2 };
		System.out.println(minSteps(nums3));
	}

	private static int minSteps(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		int res = 0;
		Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
		maxHeap.addAll(map.entrySet());
		while (maxHeap.size() > 1) {
			Map.Entry<Integer, Integer> entry1 = maxHeap.poll();
			Map.Entry<Integer, Integer> entry2 = maxHeap.poll();
			res += entry1.getValue();
			entry2.setValue(entry2.getValue() + entry1.getValue());
			maxHeap.offer(entry2);
		}
		return res;
	}
}
