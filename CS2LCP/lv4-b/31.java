class Solution {
    public void nextPermutation(int[] nums) {
        // first we know that we must find the first pivot 1 2 3 2 5 3 1
        int i = nums.length - 1;
        while (i > 0 && nums[i-1] >= nums[i]) { i--; }
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        // we need to pick the first number that is larger than nums[i-1]
        int j = nums.length - 1;
        while (j >= i && nums[j] <= nums[i-1]) { j--; }
        
        // swap these two numbers
        swap(nums, i-1, j);
        reverse(nums, i, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}