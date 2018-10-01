class LongestConsecutiveSequence128 {
	public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
        	numSet.add(num);
        }

        int maxLength = 1;
        for (int num : nums) {
        	if (!numSet.contains(num - 1)) {
        		int length = 1;
        		while (numSet.contains(++num)) {
        			length++;
        		}
        		maxLength = length > maxLength ? length : maxLength;
        	}
        }

        return maxLength;
    }
}