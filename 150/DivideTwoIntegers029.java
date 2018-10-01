class DivideTwoIntegers029 {
	public int divide(int dividend, int divisor) {
		// the corner cases 
		if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
		if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        // get the sign
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? true : false;

        // get the absolute value and transfer to long
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        int quotient = divHelper(longDividend, longDivisor, 0);
        return positive ? quotient : - quotient;    
    }

    // calculate the quotient by adding the numbers binarily
    // 这里multiply已经不可能>Integer.MAX_VALUE了
    // why? 因为>Integer.MAX_VALUE了只有两种情况，Integer.MIN_VALUE / 1 
    // 和 Integer.MIN_VALUE / -1 已经被遍历了
    // 但是dividend和divisor都还有可能是Long,因此不能转换为int
    private int divHelper(long dividend, long divisor, int multi) {
    	if (dividend < divisor) return multi;
    	long sum = divisor;
    	int multiply = 1;
    	while (sum + sum <= dividend) {
    		// 0, divisor, 2divisor, 4divisor, 8divisor,...,  dividend
    		// terminate unitl 2 * sum > dividend   
            sum += sum;
    		multiply += multiply;    	
    	}
    	return divHelper(dividend - sum, divisor, multi + multiply);
    	/*
		20 / 3: 
		loop1: (sum,multiply) = (3,1) (6,2) (12,4)  -> (8, 3, 4)
		loop2: (3, 1) (6, 2) -> (2, 3, 6)
		loop3: dividend < divisor return 6
    	*/
    }
}