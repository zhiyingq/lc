class ValidPalindrome125 {
	public boolean isPalindrome(String s) {
        int head = 0; 
        int tail = s.length() - 1;
        while (tail > head) {
        	if (isValid(s.charAt(head)) && isValid(s.charAt(tail))) {
        		if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) return false;
        		head++;
        		tail--;
        	}
        	else {
        		if (!isValid(s.charAt(head))) head++;
        		if (!isValid(s.charAt(tail))) tail--;
        	}
        }
        return true;
    }

    private boolean isValid(char c) {
    	if ((c - 'a' >= 0 && c - 'z' <= 0) ||  (c - '0' >= 0 && c - '9' <= 0) ||
    		(c - 'A' >= 0 && c - 'Z' <= 0)) return true;
    	return false;
    }
}