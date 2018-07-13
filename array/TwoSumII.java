import java.util.HashMap;
import java.util.Map;
import java.lang.IllegalArgumentException;

class TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			// only put the possible numbers into the map
			if (numbers[i] + numbers[0] <= target) {
				map.put(numbers[i], i);
			}
		}

		// for (int i : map.keySet()){
		// 	System.out.println(i);
		// }

		for (int i = 0; i < numbers.length; i++) {
			// the number we wanna seek
			int remain = target - numbers[i];
			// if the map contains this number &
			// the number is not itself
			if (map.containsKey(remain) && i != map.get(remain)) {
				return new int[] {i + 1, map.get(remain) + 1};
				
			}
		}

		throw new IllegalArgumentException();

	}

	// This is the improved method
	// 使用了逼近法
	public int[] twoSum2(int[] numbers, int target) {
		if (numbers.length < 2) { throw new IllegalArgumentException();}
		int low = 0; int high = numbers.length - 1;
		while(low < high) {
			if (numbers[low] + numbers[high] == target) {
				return new int[] {low + 1, high + 1};
			}
			else if (numbers[low] + numbers[high] > target) {
				high--;
			}
			else {
				low ++;
			}
		}

		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		TwoSumII t = new TwoSumII();
		int[] arr = t.twoSum2(new int[] {2,7,11,15}, 13);
		for (int i : arr) {
			System.out.println(i);
		}
	}

}