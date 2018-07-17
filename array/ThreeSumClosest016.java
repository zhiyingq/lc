import java.util.Arrays;
import java.lang.Math;

class ThreeSumClosest016 {
	// basic idea: first pick up a number 
	// then do 2-sum and save the number with the minimum absolute
	public int threeSumClosest(int[] nums, int target) {
		// nums.length >= 3
		// sort the array
		int closest = Integer.MAX_VALUE; // to save the closest difference between twotarget and the 2sum
		int answer = 0; // to return the answer
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) { continue; } // remove the duplicates
			// because we will have considered all the possible situations at i 
			int twotarget = target - nums[i]; // twotarget is the number we wanna find
			int j = i + 1; int k = nums.length - 1;
			while (j < k) {
				int diff = nums[j] + nums[k] - twotarget;
				if (Math.abs(diff) < closest) { // if the diff is lower
					closest = Math.abs(diff);	// update the closest difference
					answer = nums[i] + nums[j] + nums[k]; // update answer
				}
				if (diff == 0) { return answer; }
				else if (diff > 0) { k--; }
				else { j++; }
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		ThreeSumClosest016 t = new ThreeSumClosest016();
		System.out.println(t.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
	}
}