import java.lang.StringBuffer;
class StringCompression {
	// basic string compress
	// aabcccccaaa = a2b1c5a3
	// upper case and lower case
	public String compress(String s) {
		if (s == null || s.length() == 0 || s.length() == 1) { return s; }
		StringBuffer str = new StringBuffer();
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) { 
				count++; continue; 
			}
			str.append(s.charAt(i)); str.append((char) (count + '0'));  count = 1;
		}
		return (str.toString().length() < s.length() ? str.toString() : s);
	}

	public static void main(String[] args) {
		StringCompression s = new StringCompression();
		System.out.println(s.compress("aaAAZZBBBfffeeee"));
		System.out.println(s.compress("aaaaaaaAbbbbbbeee"));
		System.out.println(s.compress("aaABCDEe"));
		System.out.println(s.compress(""));
		System.out.println(s.compress("a"));
		System.out.println(s.compress("aB"));
		System.out.println(s.compress("aBBB"));
		// System.out.println(1 + '0');
		// System.out.println((char)(1 + '0'));

	}
}