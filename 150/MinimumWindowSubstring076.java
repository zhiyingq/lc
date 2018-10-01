class MinimumWindowSubstring076 {
	// sliding window
	public String minWindow(String s, String t) {
		// initialization: map -> count the characters in string t
		// start, end: control the sliding window
		// substart, subend: record the minlength of the substring window
		// count: how many different chars are there in t
		Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0; int end = 0;
        int substart = 0; int subend = s.length();
        int count = 0;

        // count the chars in t and put them into a map
        for (char c : t.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }
        count = map.size();

        while (end < s.length()) {
     		// only run when map contains the key
        	if (map.containsKey(s.charAt(end))) { 
        		// delete 1, if it is 0, count--
        		map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
        		if (map.get(s.charAt(end)) == 0) { count--; }  

        		// count == 0: means that all the numbers has been included
        		while (count == 0) {
        			if (map.containsKey(s.charAt(start))) { 
        				map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
        				if (map.get(s.charAt(start)) == 1) { count++; }
        			}
        			start++;
                    
                    // [start - 1, end] is where the sliding window locates
                    if (end - start + 2 < subend - substart) {
        			    subend = end + 1;
        			    substart = start - 1;
        		    }
        		}
        	}
        	end++;
        }

        if (end == s.length() && start == 0) return "";
        return s.substring(substart, subend);
    }

    public String minWindow(String s, String t) {
    	int[] charsCount = new int[128];

    	int start = 0; int end = 0;
        int substart = 0; int subend = s.length();
        int count = t.length();

        for (char c : t.toCharArray()) { charsCount[c]++; }

        while (end < s.length()) {

        	if (charsCount[s.charAt(end++)]-- > 0) { count--; }

        	while (count == 0) {
        		if (end - start + 1 < subend - substart) {
        			subend = end + 1;
        			substart = start;
        		}

        		if (charsCount[s.charAt(start++)]++ == 0) { count++; }
        	}
        }

        if (end == s.length() && start == 0) return "";
        return s.substring(substart, subend);


    }



}