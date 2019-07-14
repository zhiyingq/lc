class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, curr = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int twoTarget = target - nums[i];
            int p = i + 1, q = nums.length - 1;
            while (p < q) {
                int twoSum = nums[p] + nums[q];
                if (twoSum == twoTarget) {
                    return target;
                } else if (twoSum > twoTarget) {
                    q--;
                } else {
                    p++;
                }
                if (Math.abs(twoSum - twoTarget) < diff) {
                    diff = Math.abs(twoSum - twoTarget);
                    curr = twoSum + nums[i];
                }
            }
        }
        return curr; 
    }
}