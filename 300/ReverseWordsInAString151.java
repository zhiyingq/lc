class ReverseWordsInAString151 {
	public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder reverse = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
        	// System.out.println("strs["+i+"] = "+strs[i]);
        	reverse.append(strs[i]);
        	if (i > 0) { reverse.append(" "); }
        }
        return reverse.toString();
    }

    public static void main(String[] args) {
    	ReverseWordsInAString151 r = new ReverseWordsInAString151();
    	System.out.println(r.reverseWords("     the sky is . blue    "));
    }
}