class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] next = new int[nums.length];
        Arrays.fill(next, -1);
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int j = 0; j < nums.length * 2; j++) {
            int i = j % nums.length;
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                next[stack.pop()] = nums[i];
            }
            if (j < nums.length) stack.push(i);
        }
        return next;
    }
}