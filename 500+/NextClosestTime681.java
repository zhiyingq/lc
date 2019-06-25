class NextClosestTime681 {
	public String nextClosestTime(String time) {
        // 1. save the digits to a hashset
		Set<Integer> digits = new HashSet<Integer>();
		for (char c : time.toCharArray()) {
			if (c != ':') digits.add(c - '0');
		}

		// 2. get the hour and minute representation of the time
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
        int mtime = 60 * hour + minute;

        int mindiff = Integer.MAX_VALUE;
        StringBuilder nextTime = new StringBuilder();

        // 3. construct the new time
        for (int a : digits) { for (int b : digits) { 
        	for (int c : digits) { for (int d : digits) {
        		int h = a * 10 + b;
        		int m = c * 10 + d;
        		if (h >= 24 || m >= 60) continue;
                // System.out.println("considering: "+a+b+":"+c+d);
        		int t = 60 * h + m;
        		int diff = 0;

        		// t > mtime
        		if (t > mtime) {
        			diff = t - mtime;
        		}
        		else {
        			diff = 24 * 60 - mtime + t;
        		}
                // System.out.println("diff = "+diff);
        		if (diff < mindiff) { 
                    mindiff = diff; 
                    nextTime = new StringBuilder();
        			nextTime.append((char) (a + '0'));
        			nextTime.append((char) (b + '0'));
        			nextTime.append(':');
        			nextTime.append((char) (c + '0'));
        			nextTime.append((char) (d + '0'));
        		} 		

        }}}}

        return nextTime.toString();
    }
}