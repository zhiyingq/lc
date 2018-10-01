class CompareVersionNumbers165 {
	public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        // Compare two versions number-by-number
        while (i < v1.length && j < v2.length) {
        	int compare = compareString(v1[i], v2[j]);
        	if (compare > 0) return 1;
        	else if (compare < 0) return -1;
        	// when the two numbers are the same, jump 2 steps
        	else {
        		i++;
        		j++;
        	}
        }

        // All the numbers are the same, but one or both two have reached the end
        while (i < v1.length) {
        	if (compareString(v1[i++], "0") > 0) return 1;
        }

        while (j < v2.length) {
        	if (compareString(v2[j++], "0")> 0) return -1;
        }

        return 0;

    }

    private int compareString(String s1, String s2) {
    	int i = 0;
    	int j = 0;
    	// discard the leading 0s
    	while (i < s1.length() && s1.charAt(i) == '0') { i++; }
    	while (j < s2.length() && s2.charAt(j) == '0') { j++; }
    	// length of s1 > length of s2 (without 0)
    	if (s1.length() - i > s2.length() - j) return 1;
    	// length of s1 < length of s2 (without 0)
    	else if (s1.length() - i < s2.length() - j) return -1;
    	// length of s1 == length of s2 (without 0)
    	else {
    		while (i < s1.length() && j < s2.length()) {
    			if (s1.charAt(i) > s2.charAt(j)) return 1;
    			else if (s1.charAt(i) < s2.charAt(j)) return -1;
    			else {
    				i++;
    				j++;
    			}
    		}
    	}
    	return 0;
    }

    public static void main(String[] args) {
    	CompareVersionNumbers165 c = new CompareVersionNumbers165();
    	System.out.println(c.compareString("000000012323", "0123234"));
    	String[] v = "12323".split("\\.");
    	for (String s : v) {
    		System.out.println(s);
    	}
    }
}


















