class RotateMatrix {
	public void rotate(int[][] image) {
		if (image == null || image.length == 0 || image[0].length == 0) { return; }
		int n = image.length;
		for (int start = 0; start <= (n - 1) / 2; start++) {
			for (int i = start; i < n - start - 1; i++) {
				int temp = image[start][i];
				image[start][i] = image[n - i - 1][start];
				image[n - i - 1][start] = image[n - start - 1][n - i - 1];
				image[n - start - 1][n - i - 1] = image[i][n - start - 1];
				image[i][n - start - 1] = temp;
			}
			//print(image);
		}
	}

	private void print(int[][] image) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j <image.length; j++) {
				System.out.print(image[i][j] + "\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		RotateMatrix r = new RotateMatrix();
		int[][] image = new int [2][2];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j <image.length; j++) {
				image[i][j] = image.length*i + j;
			}
		}
		r.print(image);
		r.rotate(image);
		r.print(image);
	}
}