class UniqueBSTs096 {
	/*
	首先，我们把含有n个数的BST个数记为G(n)
	把以i为root,且包含数字1-n的BST个数记为F(i,n)
	即对G(n)作一个简单的拆分, G(n) = F(1, n) + F(2, n) + ... + F(n, n)

	再看F(i, n), 显然i的左子树含有1-i, i的右子树含有i+1 - n 
	那么左子树的组合显然有G(i - 1)种， 右子树的组合含有G(n - i)种
	则: F(i, n) = G(i - 1) * G(n - i)

	G(0) = 1 -> 这是为了确保不影响相乘的结果,即无左/右子树的情况
	G(1) = 1 (显然)
	G(2) = F(1, 2) + F(2, 2) = G(0) * G(1) + G(1) * G(0)
	.
	.
	. 
	G(n) = G(0) * G(n - 1) + G(1) * G(n - 2) + G(2) * G(n - 3) + ... + G(n - 1) * G(0)
		 = SIGMA(G(i - 1) * G(n - i))
	*/

	public int numTrees(int n) {
		if (n == 1) { return 1; }
		int[] G = new int[n + 1]; // n > 1, G.length >= 3
		G[0] = 1; G[1] = 1;
		for (int i = 2; i < G.length; i++) {
			for (int j = 1; j <= i; j++) {
				G[i] += G[j - 1] * G[i - j];
			}
		}
		return G[n];
	}
}