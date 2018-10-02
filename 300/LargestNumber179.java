class LargestNumber179 {
	public String largestNumber(int[] nums) {
        // construct a string array of nums
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	strNums[i] = String.valueOf(nums[i]);
        }

        // sort the array according to certain rules
        // where the highest digit matters
        Arrays.sort(strNums, new Comparator<String>() {
        	public int compare(String s1, String s2) {
        		String s1s2 = s1 + s2;
        		String s2s1 = s2 + s1;
        		return s2s1.compareTo(s1s2);
        	}
        }); 

        // pay attention to the leading 0's
        // if there are leading 0s <=> the highest number is 0 <=> all numbers are 0
        if (strNums[0].equals("0")) { return "0"; }
            
        StringBuilder number = new StringBuilder();
        for (String str : strNums) {
        	number.append(str);
        }

        return number.toString();
    }
}