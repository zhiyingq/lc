class SpiralMatrixII059 {
	// Given a positive integer n, generate a square matrix 
	// filled with elements from 1 to n2 in spiral order.
	private int num = 1;
	public int[][] generateMatrix(int n) {
		// initialize the row, col and matrix
		int i = 0, j = 0;
		int start = 0, end = n - 1;
		int[][] matrix = new int[n][n];

        while (num <= n * n && start <= end) {
        	for (j = start; j <= end; j++) {
        		matrix[i][j] = num++;
        	}
            j--;
        	for (i = start + 1; i <= end; i++) {
        		matrix[i][j] = num++;
        	}
            i--;
        	for (j = end - 1; j >= start; j--) {
        		matrix[i][j] = num++;
        	}
            j++;
        	for (i = end - 1; i > start; i--) {
        		matrix[i][j] = num++;
        	}
            i++;
        	start++; end--;
        }

        return matrix;
    }
}