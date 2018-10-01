class Implementstr028 {
	public int strStr(String haystack, String needle) {
        // Return the index of the first occurrence of needle in haystack, 
        // or -1 if needle is not part of haystack.
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;

        int i = 0;
        while (i <= haystack.length() - needle.length()) {
        	boolean allEqual = true;
        	int j = 0;
        	for (; j < needle.length() && i + j < haystack.length(); j++) {          
        		if (haystack.charAt(i + j) != needle.charAt(j)) break;            
        	}

        	if (j == needle.length()) { return i; }
        	i++;
        }

        return -1;
    }
}