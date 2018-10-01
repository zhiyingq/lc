class PalindromeNumber009 {
	public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String xstr = String.valueOf(x);
        int n = xstr.length();
        for (int i = 0; i < n / 2; i++) {
        	if (xstr.charAt(i) != xstr.charAt(n - 1 - i)) return false;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
    	if (x < 0 || (x % 10 == 0 && x != 0)) return false;
    	int reverse = 0;
    	while (reverse < x) {
    		reverse = reverse * 10 + x % 10;
    		x = x / 10;
    	}

    	return x == reverse || x == reverse / 10;
    }


    public static void main(String[] args) {
    	System.out.println(-121 % 10);
    	System.out.println(-121 / 10);
    }
}