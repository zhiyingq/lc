class RotateImage048 {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || (matrix.length != matrix[0].length) || matrix.length == 1) { return; }
		int start = 0; int end = matrix.length - 1;
		while (start < end) {
			periRotate(matrix, start, end);
			start++; end--;
		}
	}

	private void periRotate(int[][] matrix, int start, int end) {
		for (int i = start; i < end; i++) {
			// 这里i是绝对的位置，所以下标如果以start, end为界
			// 那么就不能直接减去i, 而是应该减去i的相对值，即i-start
			int temp = matrix[start][i];
			matrix[start][i] = matrix[end - i + start][start];
			matrix[end - i + start][start] = matrix[end][end - i + start];
			matrix[end][end - i + start] = matrix[i][end];
			matrix[i][end] = temp;
		}
	}
}