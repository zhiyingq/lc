class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		if (n <= 0) return false;
		while (n > 1) {
			if (n % 3 != 0) return false;
			n /= 3;
		}
        return true;
	}

	// Another method is to find out the maximum number under the range of Integer
	// Then divide the number by n and check whether the mod is 0
	// using O(1) time and O(1) space
}