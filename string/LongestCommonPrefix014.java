class LongestCommonPrefix014 {
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int i = 0;
        while (i < strs[0].length()) {
        	// check whether all the elements in strs has the same char in index i
        	for (int j = 1; j < strs.length; j++) {
        		if (i >= strs[j - 1].length() || i >= strs[j].length() || strs[j].charAt(i) != strs[j - 1].charAt(i)) {
        			return strs[0].substring(0, i);
        		}
        	}
        	i++;
        }
        return strs[0];
    }
}