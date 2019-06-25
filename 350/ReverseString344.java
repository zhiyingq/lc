class ReverseString344 {
	public String reverseString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - i - 1];
            chars[n - i - 1] =  temp;
        }
        return new String(chars);
    }
}