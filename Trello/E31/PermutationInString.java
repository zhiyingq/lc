class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
        // input strings only contain lower case letters
        if (s1 == null || s2 == null) { return false; }
        if (s1.length() == 0) { return true; }
        if (s2.length() == 0) { return false; }

        int[] letter1 = new int[26];
        for (char c : s1.toCharArray()) { letter1[c - 'a']++; } // initialize
        // int count = 0; // count the # of distinct letters
        for (int i : letter1) { if (i > 0) { count++; }}
        int end = 0; int begin = 0;
        while (end < s2.length() && begin < s2.length()) { 
        	int i1 = s2.charAt(end) - 'a'; 
            letter1[i1]--;
            //    System.out.println("end = "+end+". char = "+s2.charAt(end)+". letter[end] = "+letter1[i1]);
        	// System.out.println("begin = "+begin);
        	if (letter1[i1] == 0) { 
        		count--;
        		if (count == 0)  return true; 
        	}
        	
        	while (letter1[i1] < 0) {
                int i2 = s2.charAt(begin) -'a';
        		letter1[i2]++;
        		if (letter1[i2] == 1) { count++; }
        		begin++;
        	}
        	end++;
        }
        return false; 
    }

    public static void main(String[] args) {
    	PermutationInString p = new PermutationInString();
    	String s1 = "trinitrophenylmethylnitramine";
    	String s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine";
    	System.out.println(p.checkInclusion(s1, s2));
    }
}