class BitwiseANDOfNumbersRange201 {
	public int rangeBitwiseAnd(int m, int n) {
		// the parameter of log2 cannot be 0, handle the exception case
		if (m == 0 || n == 0) return 0;

        int log2M = log2(m);
        // if they are not in a range from [2**x, 2**(x+1)), the result must be 0
        if (log2M != log2(n)) return 0;

        int result = 1 << log2M;
        int power = power2(log2M);
        return result + rangeBitwiseAnd(m - power, n - power);

    }

    // return the Math.floor(log2(n))
    private int log2(int n) {
    	int count = 0;
    	while (n > 1) {
    		n >>= 1;
    		++count;
    	}
    	return count;
    }

    // return power of 2
    private int power2(int n) {
    	int power = 1;
    	for (int i = 0; i < n; i++) {
    		power <<= 1;
    	}
    	return power;
    }
}