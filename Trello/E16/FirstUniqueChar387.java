
class FirstUniqueChar387 {
	public int firstUniqChar(String s) {
		// only lower case letters
		if (s == null || s.length() == 0) { return -1; }
		char[] c = new char[26]; // to save the 26 letters
		for (char ch : s.toCharArray()) { c[ch - 'a']++; }
		for (int i = 0; i < s.length(); i++) {
			if (c[s.charAt(i) - 'a'] == 1) { return i; }
		}
		return -1;
	}

	public static void main(String[] args) {
		FirstUniqueChar387 f = new FirstUniqueChar387();
		System.out.println(f.firstUniqChar(""));

	}
}