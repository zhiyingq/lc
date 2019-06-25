class RegularExpressionMatching010 {
	public boolean isMatch(String s, String p) {
        /* dynamic programming
        /* create a 2d array to record whether S[i]P[j] matches
        /* where S[i] = s.substring(0, i); P[j] = p.substring(0, j)
        /* obvious that match[0][0] = True; 
        /* and the first row & column is Flase; */ 
        int ns = s.length() + 1;
        int np = p.length() + 1;
        boolean[][] match = new boolean[ns][np];
        match[0][0] = true;
        // we can intialize the first column to be false, no problem
        for (int i = 1; i < ns; i++) { match[i][0] = false; }
        // as for the first row, a*b*c*, a* sometimes will match the null string
        for (int j = 1; j < np; j++) { 
            if (p.charAt(j - 1) == '*' && match[0][j - 2]) { match[0][j] = true; }
            else { match[0][j] = false; }
        }

        /* consider the dp match[i][j] 以下S[i],P[j]实际指的是s[i - 1]和p[j - 1]
		/* 1. S[i] == P[j] || P[j] == '.' (implies that P[j] != '*') ? return match[i - 1][j - 1]
		/* 2. S[i] != P[j] && P[j] != '.', but P[j] == '*':
		/*		we have following choices, either true will make the statement true
		/*		2.1 match[i][j - 2] -- meaning: if we don't use the x* (or use 0 times), does it match?
		/*		2.2 if P[j - 1] == S[i] or P[j - 1] == '.', which means S[i] matches with x* and we just need to check whether S[i - 1] matches P[j]
		/*		in this case we just need to return match[i - 1][j]
        /* */
        for (int i = 1; i < ns; i++) {
        	for (int j = 1; j < np; j++) {
        		// the first case: s[i - 1] == p[i - 1] || p[i - 1] == '.', return match[i - 1][j - 1]
        		if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
        			match[i][j] = match[i - 1][j - 1];
        		}
        		// if s[i - 1] != p[i - 1] && p[i - 1] != '.'
        		// we can choose either one: match[i][j - 2]: use 0 times
        		// or if s[i - 1] == p[i - 2] (where p[i - 1] == '*'), 
        		// we can say that s[i - 1] already matches, we just need to know whether s.substring(0, i - 1) matches p
        		else if (p.charAt(j - 1) == '*') {
        			match[i][j] = match[i][j - 2] || ( (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') ? match[i - 1][j] : false);			
        		}
        		// if s[i - 1] != p[i - 1] && p[i - 1] != '.' && p[i - 1] != '*'
        		// it's just the unmatching between letters, definitely false
        		else {
        			match[i][j] = false;
        		}
        	}
        }
        
        // printArray(match);

        return match[ns - 1][np - 1];
    }
    
    private void printArray(boolean[][] match) {
        for (int i = 0; i < match.length; i++) {
            for (int j = 0; j < match[0].length; j++) {
                System.out.print(match[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}







