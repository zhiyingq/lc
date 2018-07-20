class Search2DMatrixII {
	/*
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return false; }
		// You can search first the row, and the column
		// And you can search first the column and the row
		int low = 0; int high = matrix.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (matrix[mid][0] == target) { return true; }
			if (matrix[mid][0] > target) { high = mid - 1; continue; }
			else { low = mid + 1; continue; }
		}	
		// high is located at the index which is smaller than target
		// Thus just traverse all the rows whose index is less or equal to high
		System.out.println(high);
		while (high >= 0) {
			if (matrix[high][matrix[0].length - 1] < target) { break; }
			int collow = 0; int colhigh = matrix[0].length - 1;
			while (collow <= colhigh) {
				int mid = (collow + colhigh) / 2;
				if (matrix[high][mid] == target) { return true; }
				if (matrix[high][mid] > target) { colhigh = mid - 1; }
				else { collow = mid + 1; }
			}
			high--;
		}
		return false;
	}
	*/

	// Young Tableau method
	// once turn left, it will never turn right: this is because any element on right is larger.
	// once turn down, never turn up: this is because any elemnt on top is smaller.
	// can only turn left & turn down
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return false; }
		int row = 0; int col = matrix[0].length - 1;
		while (col >= 0 && row < matrix.length) {
			if (matrix[row][col] == target) { return true; }
			if (matrix[row][col] < target) { row++; }
			else { col--; }
		}
		return false;
	}

	public static void main(String[] args) {
		Search2DMatrixII s = new Search2DMatrixII();
		int[][] m = new int[][] {{1,4,7,11,15}, {2,5,8,12,19}, 
		{3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
		System.out.println(s.searchMatrix(m, 5));
	}
}