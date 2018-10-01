class DistinctSubsequences115 {
	/*
		dp[i][j] = s.substring(0, j).contains_how_many(t.substring(0, i));
		显然, 当t.substring(0,0)的时候，第一行全部为1，即取出空字符
		而当s.substring(0,0)的时候，第一列除了(0,0)外全部为0，因为空字符串无法取出
        
		考虑dp[i][j]和之前几个数的关系
		如果s.charAt(j) == t.charAt(i)，为了匹配t：
		   s: ********s
		   t:       **s
		   使用s.s: dp[i][j] = dp[i - 1][j - 1];
		   不使用s.s，即直接用前面的*匹配t的**s: dp[i][j] = dp[i][j - 1]
		如果s.charAt(j) != t.charAt(i):
		   s: ******s
		   t:    ***t
		   因为要匹配t，所以dp[i]是必须的,而s.s已经不能用了
		   dp[i][j] = dp[i][j - 1]
    */
	public int numDistinct(String s, String t) {
        if (t.length() > s.length()) return 0;
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        

        // 初始化第一行为1
        for (int j = 0; j < dp[0].length; j++) { dp[0][j] = 1; }
        for (int i = 1; i < dp.length; i++) {
        	// j 从 i开始，因为只要保证s.length() >= t.length()
        	for (int j = i; j < dp[0].length; j++) {
        		if (s.charAt(j) == t.charAt(i)) { 
        			dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        		}
        		else {
        			dp[i][j] = dp[i][j - 1];
        		}
        	}
        }
        return dp[t.length()][s.length()];
    }


    // using one-dimensional array
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) return 0;
        int[] dp = new int[s.length() + 1];   
        // 初始化第一行为1
        for (int j = 0; j < dp.length; j++) { dp[j] = 1; }
        
        
        for (int i = 1; i <= t.length(); i++) {
            int temp1 = dp[i - 1];
        	for (int j = i; j <= s.length(); j++) {
                if (j == i) { dp[j - 1] = 0; }
                
                int temp2 = dp[j];
        		if (s.charAt(j - 1) == t.charAt(i - 1)) { 
        			dp[j] = temp1 + dp[j - 1];
        		}
        		else {
        			dp[j] = dp[j - 1];
        		}
                temp1 = temp2;
        	}
            // for (int j : dp) { System.out.print(j + "\t");}
            // System.out.println();
        }
        return dp[s.length()];
    }
}