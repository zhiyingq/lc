class HappyNumber202 {
	public boolean isHappy(int n) {
        // n is a positive number
        Set<Integer> set = new HashSet<Integer>();
        int sumsquare = n;
        while (set.add(sumsquare)) {
        	sumsquare = digitSquareSum(sumsquare);
        	if (sumsquare == 1) return true;
        }
        return false;
    }

    private int digitSquareSum(int n) {
    	int sum = 0;
    	while (n > 0) {
    		int digit = n % 10
    		sum += digit * digit;
    		n /= 10;
    	}
    	return sum;
    }
}