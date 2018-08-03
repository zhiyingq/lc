class StringRotation {
	// given two strings, check if s2 is a rotation of s1 using only one call
	// to isSubString
	public boolean isRotation(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) { return false; }
		int x1 = 0; int x2 = 0; boolean match = false;
		while (x1 < s1.length() && x2 < s2.length()) {
			if (s1.charAt(x1) == s2.charAt(x2)) { x1++; x2++; continue; }
			x1 = 0;
			if (s1.charAt(0) != s2.charAt(x2)) { x2++; }
			if (x2 == s2.length() && x1 > 0) match = true;
		}
		if (!match) { return false; }
		// else: len = x1;
		String subs1 = s1.substring(x1);
		String subs2 = s2.substring(0, s2.length() - x1);
		return subs1.equals(subs2);
	}

	public boolean isRotationEasy(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) { return false; }
		String s1s1 = s1 + s1;
		return s1s1.contains(s2);

		// s1 = ab, s2 = ba, s1s1 = abab -> abab always contains ba
	}

	public static void main(String[] args) {
		StringRotation s = new StringRotation();
		System.out.println(s.isRotationEasy("abcde", "deabc") + " = true");
		System.out.println(s.isRotationEasy("abcab", "ababc") + " = true");
		System.out.println(s.isRotationEasy("abcde", "abcde") + " = true");
		System.out.println(s.isRotationEasy("abcde", "daebc") + " = false");
		System.out.println(s.isRotationEasy("a", "d") + " = false");
		System.out.println(s.isRotationEasy("a", "a") + " = true");
		System.out.println(s.isRotationEasy("ab", "ba") + " = true");
		System.out.println(s.isRotationEasy("", "") + " = true");
	}
}