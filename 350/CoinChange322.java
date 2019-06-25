class CoinChange322 {
	public int coinChange(int[] coins, int amount) {
        /* 这道题本身如果用back-tracking的方法想就会很难很难，首先因为back-tracking要么是用遍历(几乎不可能)
        /* 要么就是每次取最大的然后依次往下取，但是这样就不是最优解：比如考虑12：[5,4,1]，5+5+1+1 v.s. 4+4+4显然是后者更优，但是后者的解得不到
        /* 一旦发现这种问题，我们就需要用到dp，其basic idea就是，既然我们要得到amout,那么我们就设置一个dp[amount + 1]的数组
        /* 其中dp[i]表示：加到amount = i时所需要的最少的硬币数，那么很显然dp[0] = 0，因为加到0不需要用到任何硬币
        /* 我们dp从前往后做，对于每一个dp[i]，我们都已经算出了前面的0~i-1，然后接着我们要考虑每一个面值，是否会用到呢？
        /* 我们可以看看这个面值要不要用，如果当前我们得到的dp[i]已经很完美了，那么很有可能那个面值就没有用到，我们直接保持dp[i]的值就可以了
        /* 比如我们用1，那么dp[i]可以是dp[i - 1] + 1, 如果我们用10, 那么dp[i]可以是dp[i - 10] + 1，但是要注意coins[j] <= i，否则就会产生负数
        /* 然后我们只要取到其中的最小值就可以了，是不是so easy呢！ */
        
        // initialize the dp
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) continue;
                // 用这个的逻辑是防止dp[i - coins[j]]是max_value的情况下再加上1，这样会导致overflow
                // 现在这样的话即使dp[i - coins[j]] + 1是max_value,即使dp[i]无解 = max_value - 1, 得到的也只能是max_value - 1
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);     
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1? -1 : dp[amount];
    }
}