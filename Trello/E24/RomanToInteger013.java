class RomanToInteger013 {
	public int romanToInt(String s) {
        if (s == null || s.length() == 0) { return 0; }
        if ( s.length() == 1) { return getInt(s.charAt(0)); }
        int sum = 0; int i = 1;
        while(i < s.length()) {
        	if (getInt(s.charAt(i)) <= getInt(s.charAt(i - 1))) {
        		sum += getInt(s.charAt(i - 1));       		
        	}
        	else {
        		sum -= getInt(s.charAt(i - 1));			
        	}
        	if (i == s.length() - 1) { sum += getInt(s.charAt(i)); }
        	i++; 
        }
        return sum;
    }

    private int getInt(char c) {
    	switch (c) 
    	{
    		case 'I': return 1;
    		case 'V': return 5;
    		case 'X': return 10;
    		case 'L': return 50;
    		case 'C': return 100;
    		case 'D': return 500;
    		case 'M': return 1000;
    		default: return 0; 
    	}
    }

    public static void main(String[] args) {
    	RomanToInteger013 r = new RomanToInteger013();
    	System.out.println(r.romanToInt("MDCXCV"));

    }
}