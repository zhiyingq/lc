class BeautifulArrangement526 {
	public int countArrangement(int N) {
		int count = 1;
        for (int i = 1; i <= n / 2; i++) {
        	count *= (N / i);
        }
        return count;
    }
}