class PowerOfTwo231 {
	public boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}

	public boolean isPowerOfTwo(int n) {
		if (n <= 0) return false;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (n >> 1 == 0) return true;
                return false;
            }
            n >>= 1;
        }
        return false;
	}
}