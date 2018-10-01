class ReverseInteger007 {
	// slower solution
	public int reverse(int x) {
        String max = String.valueOf(Integer.MAX_VALUE);
        String min = String.valueOf(Integer.MIN_VALUE);
        System.out.println(max+"\n"+min);
        char[] nums = String.valueOf(x).toCharArray();
        int n = nums.length;
        int end = (nums[0] == '-' ? 0 : 1);

        for (int i = 0; i < n / 2 + 1 - end; i++) {
        	if (i == 0 && nums[i] == '-') { continue; }
        	char temp = nums[i];
        	nums[i] = nums[n - end - i];
        	nums[n - end - i] = temp;
        }
        String reverse = new String(nums);
        if (reverse.length() == min.length()) {
            if (reverse.compareTo(min) > 0) return 0;
        }
        if (reverse.length() == max.length() && reverse.charAt(0) != '-') {
            if (reverse.compareTo(max) > 0) return 0;
        }
        return Integer.parseInt(reverse);
        
    }

    // faster solution
    public int reverse(int x) {
        boolean isNegative = x < 0; // 先把符号放一边
        long result = 0;
        x = Math.abs(x);
        while (x > 0) { // 得到reverse "int", 可能会overflow所以用long来盛放它
            result = result * 10 + x % 10;
            x /= 10;
        }
        // 如果Long和它的int类型不一样，那么认为肯定会导致overflow
        if ((int)result != result) return 0; 
        return isNegative == false ? (int)result : -(int)result;
        
    }
}