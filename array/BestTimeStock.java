class BestTimeStock {
	/*
	public int maxProfit(int[] prices) {
		// Brute Force
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] - prices[i] > max) {
					max = prices[j] - prices[i];
				}
			}
		}
		return max;
	}
	*/

	public int maxProfit(int[] prices) {
		// 把整个过程想想成一个折线图，首先我们需要确定一个目前最小的值
		// 然后将后续所有比它大的值和它求差值，保存在maxProfit中
		// 后面如果遇到了更小的值，那么就更新最小值，而之前的全部作废，只有maxProfit保存
		// 重复该过程...

		// 因此 最小值更新的过程 = 数值下降的过程
		// 而maxProfit更新的过程 = 数值上升的过程 （当然也有可能不更新）
		int minPrice = Integer.MAX_VALUE;
		int maxP = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
			else if (prices[i] - minPrice > maxP) {
				maxP = prices[i] - minPrice;
			}
		}
		return maxP;
	}





	public static void main(String[] args) {
		BestTimeStock b = new BestTimeStock();
		System.out.println(b.maxProfit(new int[] {7,1,5,3,6,4,11,20,9}));
	}
	
}