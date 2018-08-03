class ZeroMatrix {
	// if an element in a MxN matrix is 0,
	// its entire row and column are set to 0
	public void zero(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return; }
		boolean[] rows = new boolean[matrix.length]; // initial: false; if true: cannot use
		boolean[] cols = new boolean[matrix[0].length]; // same as rows
		for (int i = 0; i < matrix.length; i++) {
			if (rows[i]) continue;  // true, cannot use
			for (int j = 0; j < matrix[0].length; j++) {
				if (cols[j]) continue;
				if (matrix[i][j] == 0) {
					rows[i] = true; cols[j] = true;
					setZero(matrix, i, j);
					break;
				}
			}
		}
	}

	
	private void setZero(int[][] matrix, int row, int col) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	private void print(int[][] image) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(image[i][j] + "\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		ZeroMatrix r = new ZeroMatrix();
		int[][] image = new int [2][5];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				image[i][j] = image.length*i + j;
			}
		}
		image[0][1] = 0;
		//image[2][3] = 0;
		
 		r.print(image);
		r.zeroNoExtraSpace(image);
		r.print(image);
	}
}