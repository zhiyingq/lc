class LC926	{
	public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() == 0) return 0;
        int allZero = 0;
        int allOne = 0;
        for (int i = 0; i < S.length(); i++) {
        	int prevZero = allZero;
        	allZero = allZero + (S.charAt(i) == '0' ? 0 : 1);
        	allOne = Math.min(prevZero + (S.charAt(i) == '0' ? 1 : 0),
        		allOne + (S.charAt(i) == '0' ? 1: 0));
        }
        return Math.min(allZero, allOne);
    }
}