import java.lang.StringBuilder;

class CountandSay038 {
	public String countAndSay(int n) {
		if (n == 1) return "1"; if (n == 2) return "11";
		char[] prev = countAndSay(n - 1).toCharArray();
		StringBuilder builder = new StringBuilder();
		int start = 0; int end = 0;
		while (end < prev.length && start < prev.length) {
			if (end < prev.length - 1 && prev[end] == prev[end + 1]) { end++; }
			else { 
				// System.out.println((char)('0' + end - start + 1));
				builder.append((char)('0' + end - start + 1));
				builder.append(prev[end]);
				start = ++end;
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		CountandSay038 c = new CountandSay038();
		System.out.println(c.countAndSay(4));
	}
}