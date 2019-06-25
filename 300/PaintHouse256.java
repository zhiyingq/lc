class PaintHouse256 {
	public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int lastRed = costs[0][0];
        int lastBlue = costs[0][1];
        int lastGreen = costs[0][2];
        int cost = Math.min(Math.min(lastRed, lastBlue), lastGreen);
        for (int i = 1; i < costs.length; i++) {
            // this time red
            int thisRed = Math.min(lastBlue, lastGreen) + costs[i][0];
            // this time blue
            int thisBlue = Math.min(lastRed, lastGreen) + costs[i][1];
            int thisGreen = Math.min(lastRed, lastBlue) + costs[i][2];
            lastRed = thisRed;
            lastBlue = thisBlue;
            lastGreen = thisGreen;
            cost = Math.min(Math.min(lastRed, lastBlue), lastGreen);
        }
        return cost;
    }
}