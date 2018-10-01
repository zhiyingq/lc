class PalindromePartitioningII132 {
	// idea: dp的思想
	// dp[i]是看，对于所有的j < i
	// 如果s.substring(j, i)是palindrome的， 取Math.min(s.substring(j, i) + dp[j])
	public int minCut(String s) {
		if (s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = -1;
        // dp[i]: min cut of s.substring(0, i), where i is not included
        for (int i = 1; i <= s.length(); i++) {
        	// given i, for substring(j, i), where j ranges from [0, i - 1]
        	dp[i] = i - 1;
        	for (int j = 0; j < i; j++) {
        		// if s.substring(j, i) is a palindrome
        		// we take dp[j] + 1 as the new value and check whether it's smaller
        		if (isPalindrome(s, j, i)) {
        			dp[i] = Math.min(dp[i], dp[j] + 1);
        		}
        	}
        }
        return dp[s.length()];
    }

    // check whether s.substring(start, end) is palindrome
    private boolean isPalindrome(String s, int start, int end) {
    	while (start < end - 1) {
    		if (s.charAt(start++) != s.charAt(end-- - 1)) return false;
    	}
    	return true;
    }
}