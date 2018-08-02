class PalindromePermutation {
	// palindrome: a word or phrase that is the same forwards and backwards
	// check if it is a permutation of a palindrome
	// ** A string CANNOT have more than one odd!
	public boolean isPalindrome(String s) {
		// allow the space
		// allow upper and lower case
		if (s == null || s.length() == 0) { return false; }
		int checker = 0; int countLetter = 0; 
		for (char c : s.toCharArray()) {
			int val = -1;
			if ((c >= 'a' && c <= 'z')) {
				val = c - 'a';
			}
			else if ((c >= 'A' && c <= 'Z')) { 
				val = c - 'A';
			}
			if (val >= 0) { // its a letter
				checker ^= (1 << val);
				countLetter ++;
			}
		}
		if (countLetter == 0) { return false; } // corner case
		return ((checker - 1) & checker) == 0;

		/*
		if (countLetter <= 0) { return false; }
		if (countLetter % 2 == 0) { // even
			if (checker == 0) { return true; }
		}
		else {	// odd
			for (int i = 0; i <= 25; i++) {
				checker >>= 1;
				if ((checker & 1) == 1) break;
			}
			if (checker == 1) return true;
		}
		return false;
		*/
		

	}

	public static void main(String[] args) {
		PalindromePermutation p = new PalindromePermutation();
		System.out.println(p.isPalindrome("****") + " should be: false");
		System.out.println(p.isPalindrome("**a b**") + " should be: false");
		System.out.println(p.isPalindrome("**a b*a*") + " should be: true");
		System.out.println(p.isPalindrome("a aaaab**") + " should be: false");
		System.out.println(p.isPalindrome(" !-a bbcac*") + " should be: true");
		System.out.println(p.isPalindrome(" a") + " should be: true");
		System.out.println(p.isPalindrome("abc") + " should be: false");
		System.out.println(p.isPalindrome("zzx") + " should be: true");
		System.out.println(p.isPalindrome("zzjjkkhmmh") + " should be: true");
	}
}