class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<Integer>();
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int idx = findPos(arr, nums[i]);
            if (idx == arr.size()) {
                arr.add(nums[i]);
            } else {
                arr.set(idx, nums[i]);
            }
            maxLen = Math.max(maxLen, arr.size());
            // System.out.println(arr);
        }
        
        return maxLen;
    }
    
    private int findPos(List<Integer> nums, int num) {
        int low = 0, high = nums.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) == num) return mid;
            else if (nums.get(mid) > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}