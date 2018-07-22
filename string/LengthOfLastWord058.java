class LengthOfLastWord058 {
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) { return 0; }
		// public String[] split(String regex)
		// Trailing empty strings are therefore not included in the resulting array.
		String[] words = s.split(" ");
		return words.length > 0 ? words[words.length - 1].length() : 0;     
    }

    public static void main(String[] args) {
    	LengthOfLastWord058 l = new LengthOfLastWord058();
    	System.out.println(l.lengthOfLastWord("  d     "));
    }
}