class JewelsAndStones771 {
	public int numJewelsInStones(String J, String S) {
		// save the jewels to the array
        char[] jewels = new char[128];
        for (char j : J.toCharArray()) {
        	jewels[j] = 1;
        }

        int count = 0;
        for (char s : S.toCharArray()) {
        	if (jewels[s] == 1) count++;
        }

        return count;
    }
}