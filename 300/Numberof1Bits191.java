class Numberof1Bits191 {
	public int hammingWeight(int n) {
		int count = 0;
        for (long j = 1; j < 2 * (long) Integer.MAX_VALUE; j <<= 1) {
        	System.out.println(j);
        	if ((n & j) > 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
    	Numberof1Bits191 n = new Numberof1Bits191();
    	System.out.println(n.hammingWeight(11));
    }
}