class SearchA2DMatrix074 {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        
        // find the row
        int rowLow = 0; int rowHigh = m - 1;
        while (rowLow <= rowHigh) {
        	int mid = rowLow + (rowHigh - rowLow) / 2;
        	if (matrix[mid][0] == target) return true;
        	else if (matrix[mid][0] > target) { rowHigh = mid - 1; }
        	else { rowLow = mid + 1;}
        }

        // rowHigh always keep the lower row
        int colLow = 0; int colHigh = n - 1;
        while (colLow <= colHigh) {
        	int mid = colLow + (colHigh - colLow) / 2;
        	if (matrix[rowHigh][mid] == target) return true;
        	else if (matrix[rowHigh][mid] > target) { colHigh = mid - 1; }
        	else { colLow = mid + 1; }
        }

        return false;
    }
}