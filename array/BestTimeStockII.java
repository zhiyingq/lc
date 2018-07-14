class BestTimeStockII {
	public int maxProfit(int[] prices) {
		// construct a difference array
		if (prices == null || prices.length == 0) return 0;
		int maxProfit = 0;
		int[] diff = new int[prices.length - 1];
		for (int i = 0; i < diff.length; i++) {
			diff[i] = prices[i + 1] - prices[i];
			if (diff[i] > 0) {
				maxProfit += diff[i];
			}
		}
		return maxProfit;

	}

	public static void main(String[] args) {
		
	}
}