class EditDistance072 {
	/*
	DP
	定义dp[i][j] = word1[0, i - 1] -> word2[0, j - 1]所需要的操作
	我们知道dp[i][j]必定源于四种操作：
 	1. replace : dp[i - 1][j - 1] + 1
  	2. add: dp[i][j - 1] + 1
  	3. delete: dp = dp[i - 1][j] + 1
  	4. do Nothing: dp = dp[i - 1][j - 1] if word1[i - 1] = word2[j - 1];
  	其中前三种情况是word1[i - 1] != word2[j - 1]的，因为如果相等的操作就是0，肯定是取更少的操作的。
	因此，我们只需判断是否word1[i - 1] == word2[j - 1]，看看是否需要执行operation，如果不需要当然就是最好。
	如果需要的话取1、2、3中的最小值就可以了。
	*/
	public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) { dp[i][0] = i; }
        for (int j = 0; j <= n; j++) { dp[0][j] = j; }
        
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {   		
        		if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        			dp[i][j] = dp[i - 1][j - 1];
        		}
        		else {
        			dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
    			}
        	}
        }

        return dp[m][n];
    }
}