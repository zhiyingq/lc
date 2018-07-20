import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Arrays;

class CombinationSum039 {
	// 对于数组进行排序，从小到大
	// 对于每一个数，考虑1个，2个，3个....如果remain为0，则添加至list
	// 如果不为0， 则考虑(i+1)至尾部的数是否能组成remain，即只往后考虑的思想

	/*
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return combsub(candidates, target, 0);
	}

	private List<List<Integer>> combsub(int[] nums, int target, int start) {
		List<List<Integer>> thislevel = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) { return thislevel; }

		for (int i = start; i < nums.length; i++) {
			if (nums[i] > target) { break; }
			int times = target / nums[i];
			while (times > 0) {
				int remain = target - times * nums[i];
				if (remain == 0) { 
					thislevel.add(new ArrayList<Integer>(Collections.nCopies(times, nums[i])));
				}
				// if remain != 0
				else {
					if (remain < nums[0]) { times--; continue; }
					List<List<Integer>> prev = combsub(nums, remain, i + 1);
					for (List<Integer> l : prev) {
						for (int j = 0; j < times; j++) { l.add(0, nums[i]); }	
						thislevel.add(l);
					}
				}
				times--;
			}
		}
		return thislevel;
	}
	*/

	// 另一种思路
	// 首先对数组进行排序，保证每次考虑某个数只需要考虑该数及其之后的数
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return combsub(candidates, target, 0);
	}

	private List<List<Integer>> combsub(int[] nums, int target, int start) {
		List<List<Integer>> thislevel = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) { return thislevel; }

		for (int i = start; i < nums.length; i++) {
			if (nums[i] > target) { break; }
			int remain = target - nums[i];
			if (remain == 0) { 
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(nums[i]);
				thislevel.add(arr);
			}
			else {
				List<List<Integer>> prev = combsub(nums, remain, i);
				for (List<Integer> l : prev) {
					l.add(0, nums[i]);
					thislevel.add(l);
				}
			}		
		}
		return thislevel;
	}

	
	public static void main(String[] args) {
		CombinationSum039 c = new CombinationSum039();
		System.out.println(c.combinationSum(new int[] {2,3,5}, 8));

	}













}