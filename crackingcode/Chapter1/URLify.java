import java.util.Arrays;
class URLify {
	// replace all spaces in a string with %20
	public String urlify(char[] str, int n) {
		if (str == null || str.length == 0 || n == 0) { return new String(); }
		// start from end
		int countspace = 0;
		for (int i = 0; i < n; i++) {
			if (str[i] == ' ') { countspace++; }
		}
		int end = n + 2 * countspace - 1;
		int endprev = n - 1;
		while (endprev >= 0 && end >= 0) {
			if (str[endprev] != ' ') { str[end--] = str[endprev]; }
			else { 
				str[end] = '0';
				str[end - 1] = '2';
				str[end - 2] = '%';
				end -= 3;
			}
			endprev--;
		}
		return new String(str);

	}

	public static void main(String[] args) {
		URLify u = new URLify();
		System.out.println(u.urlify(new char[] {' ', 'x','b','x',' ','c',' ',' ',' ',' ',' ',' '}, 6));
	}
}