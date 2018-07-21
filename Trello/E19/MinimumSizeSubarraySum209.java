import java.lang.Math; 
class MinimumSizeSubarraySum209 {
	public int minSubArrayLen(int s, int[] nums) {
		// sliding window
		if (nums == null || nums.length == 0) return 0;
		int start = 0; int end = 0; int len = Integer.MAX_VALUE; int sum = 0;
		while (end < nums.length && start < nums.length) {	
			// every time, end move to the index larger or equal to s
			// start move to the index smaller to s
			// range [start, end]
			while (end < nums.length && sum < s) { sum += nums[end++]; }
			while (sum >= s) {
				len = Math.min(end - start, len); 
				sum -= nums[start++];			
			}
		}
		return len = (len == Integer.MAX_VALUE ? 0 : len);
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum209 m = new MinimumSizeSubarraySum209();
		System.out.println(m.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
	}
}