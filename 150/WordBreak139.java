class WordBreak139 {
	// ***********SOLUTION 1*******************
	private Set<String> dict;
	public boolean wordBreak(String s, List<String> wordDict) {
		// since the dictionary does not contain duplicate words
		// we just use a HashSet to save the words
        dict = new HashSet<String>(wordDict);

        // dp[i]: whether s.substring(0, i) can be broken into words
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // to judge dp[i]:
        // j: 0 -> i
        // as long as dp[j] && s.substring(j, i) is a word, dp[i] = true;
        for (int i = 1; i <= s.length(); i++) {
        	for(int j = 0; j < i; j++) {
        		if (dp[j] && dict.contains(s.substring(j, i))) {
        			dp[i] = true;
        			break;
        		}
        	}
        }

        return dp[s.length()];
    }


    // ******************SOLUTION 2**************************
    private Set<String> dict = new HashSet<String>();
	public boolean wordBreak(String s, List<String> wordDict) {
		// since the dictionary does not contain duplicate words
		// we just use a HashSet to save the words

		// 设置一个visited来看是否某个点之后的substring已经被访问过了
		// 如果显示被访问过了，那么肯定无解，因为有解的话已经返回true了
        boolean[] visited = new boolean[s.length()];
        int maxLen = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;
        // 设置minLen和maxLen来控制搜索的范围
        for (String word : wordDict) {
            dict.add(word);
            if (word.length() < minLen) { minLen = word.length(); }
            if (word.length() > maxLen) { maxLen = word.length(); }
        }
        return breakHelper(s, 0, minLen, maxLen, visited);
    }

    private boolean breakHelper(String s, int start, int minLen, int maxLen, boolean[] visited) {
    	// if the start reaches the end of s, meaning that the previous (start, end) matchs
    	// thus we can return true;
    	if (start == s.length()) return true;
    	// 如果已经访问过了，必定无解，因为有解的情况已经被返回了。
        if (visited[start]) return false;
    	for (int end = start + minLen; end <= s.length() && end <= start + maxLen; end++) {
    		if (this.dict.contains(s.substring(start, end))) {
    			// 后续的标记为访问过了
                visited[end - 1] = true;
    			if (breakHelper(s, end, minLen, maxLen, visited)) return true;
    		}
    	}
    	return false;
    }
        
}