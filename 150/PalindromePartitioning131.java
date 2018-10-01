class PalindromePartitioning131 {
	public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<String>(), list);
        return list;
    }

    private void partitionHelper(String s, int start, List<String> part,
    	List<List<String>> list) {
    	if (start == s.length()) {
    		list.add(new ArrayList<String>(part));
    	}
        else {
            for (int end = start + 1; end <= s.length(); end++) {
                if (isPalindrome(s, start, end)) { 
                    part.add(s.substring(start, end)); 
                    partitionHelper(s, end, part, list);
                    part.remove(part.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
    	if (s.length() <= 0) return false;
    	if (s.length() == 1) return true;
    	while (start < end - 1) {
    		if (s.charAt(start++) != s.charAt((end--) - 1)) return false;
    	}
    	return true;
    }
}