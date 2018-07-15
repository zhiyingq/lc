import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class ThreeSum {

	/*
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ansList = new ArrayList<List<Integer>>();
		// if nums equals null, or there are less than 3 elements in the array, return 
		if (nums == null || nums.length < 3) { return ansList; }
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			// set the target
			if (i > 0  && nums[i] == nums[i - 1]) { continue; }
			int target = -nums[i];
			twoSum(nums, ansList, i, target);
		}
		return ansList;

	}

	private void twoSum(int[] nums, List<List<Integer>> ansList, int selected, int target) {
		if (nums == null || nums.length < 2) { return;}
		// Two Sum
		// construct a map and put the value & index into the map
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// 如果放在同一个for-loop中，那么在map.put里，重复的key会覆盖掉之前的
		// 由于后一步是remain = target - nums[i]，随后判断map是否含有remain以及相应的Index
		// 所以如果放在同一个loop中，index就会保持和i一致，这样重复的key就会不满足条件而被忽略掉
		for (int i = selected + 1; i < nums.length; i++) {
			// we don't put the initial number into the twoSum calculation
			// save the elements into the map
			map.put(nums[i], i);
		}
		// 如果放在两个for-loop中，首先selected肯定要跳过，get(remain)返回的是第一次出现的重复数
		// 而不是最后的重复数，因此有效
		for (int i = selected + 1; i < nums.length; i++) {
			if (i > selected + 1 && nums[i] == nums[i - 1]) { continue; }
			int remain = target - nums[i];
			if (map.containsKey(remain) && map.get(remain) > i) {				
				List<Integer> twoSumList = new ArrayList<Integer>();
				twoSumList.add(-target); twoSumList.add(nums[i]); twoSumList.add(remain);
				ansList.add(twoSumList);

				// boolean duplicate = false;
				// for (List<Integer> l : ansList) {
				// 	if (twoSumList.containsAll(l) && l.containsAll(twoSumList)) { duplicate = true; }
				// }
				// if (!duplicate) { ansList.add(twoSumList); }
			}
		}
	}
	*/

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ansList = new ArrayList<>();
		if (nums == null || nums.length < 3) { return ansList; }
		// sort the array first
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			// 如果有一系列重复数，只允许计算第一个数(即后续数全是重复数)
			if (i > 0 && nums[i] == nums[i - 1]) { continue; }
			if (nums[i] > 0) { break; }
			int target = -nums[i];
			// 只考虑后面的数字
			int j = i + 1; int k = nums.length - 1;
			while (j < k) {
				if (nums[j] + nums[k] == target) {
					ansList.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++; k--;
					while (j < k && nums[j] == nums[j - 1]) { j++; }
					// 这里如果k+1写成k-1的话
					// k+1的作用是，到达重复的最后一个数字
					// k-1的作用是，到达重复的第一个数字，这样的话如果需要用到两个重复的该数字，就无法得到答案了
					while (j < k && nums[k] == nums[k + 1]) { k--; }
				}
				else if (nums[j] + nums[k] < target) { j++; }
				else { k--; }			
			}
		}
		return ansList;

	}

	public static void main(String[] args) {
		ThreeSum s = new ThreeSum();
		// 
		System.out.println(s.threeSum(new int[] {-1,0,1,2,-1,-4}));
		int[] l1 = new int[] {1,2,3};
		int[] l2 = new int[] {1,2,3};
		System.out.println("l1 = l2? false: "+l1.equals(l2));

		// int a = 1; int b = -1; int c = 0;
		// List<Integer> l1 = new ArrayList<Integer>();
		// l1.add(a); l1.add(b); l1.add(c);
		// List<Integer> l2 = new ArrayList<Integer>();
		// l2.add(a); l2.add(b); l2.add(c);
		// List<Integer> l3 = new ArrayList<Integer>();
		// l2.add(-1); l2.add(1); l2.add(0);
		// System.out.println("l1 = l2? true: "+l1.containsAll(l2));
		// System.out.println("l1 = l3? false: "+l1.equals(l3));



	}
}