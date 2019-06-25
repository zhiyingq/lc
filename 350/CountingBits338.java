class CountingBits338 {
	// first solution: brute force
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = count(i);
        }
        return bits;
    }
    
    private int count(int i) {
        int count = 0;
        while (i != 0) {
            if ((i & 1) == 1) count++;
            i >>= 1;
        }
        return count;
    }

    // second solution: * dp
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        bits[0] = 0;
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}