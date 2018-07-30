import java.lang.Math;

class ClimbingStairs070 {
	/*
	basically, this is a dynamic programming question
	becase, c(n) = c(n - 1) + c(n - 2)
	*/
	public int climbStairs(int n) {
		if (n == 1) { return 1; }
		if (n ==2 ) { return 2; }
		int[] ans = new int[n];
		ans[0] = 1; ans[1] = 2;
		for (int i = 2; i < n; i++) {
			ans[i] = ans[i - 1] + ans[i - 2];
		}
		return ans[n - 1];
	}

	

	public static void main(String[] args) {
		ClimbingStairs070 c = new ClimbingStairs070();
		System.out.println(c.climbStairs(44));
		// System.out.println(c.factorial(30));
	}
}
