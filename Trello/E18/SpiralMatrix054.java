import java.util.List;
import java.util.ArrayList;

class SpiralMatrix054 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiral = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return spiral; }
		int start = 0; int colend = matrix[0].length - 1; int rowend = matrix.length - 1;
		while ((start <= colend) && (start <= rowend)) {
			spiral.addAll(periphery(matrix, start, colend, rowend));
			start++; colend--; rowend--;
		}
		return spiral;
	}

	// [colstart, colend] [rowstart, rowend]
	private List<Integer> periphery(int[][] matrix, int start, int colend, int rowend) {
		List<Integer> peri= new ArrayList<Integer>();
		if (start > colend || start > rowend) { return peri; }
		if (start == colend) { 
			for (int j = start; j <= rowend; j++) {
				peri.add(matrix[j][start]);
			}
			return peri;
		}
		if (start == rowend) {
			for (int j = start; j <= colend; j++) {
				peri.add(matrix[start][j]);
			}
			return peri;
		}
		for (int j = start; j <= colend; j++) {
			peri.add(matrix[start][j]);
		}
		for (int j = start + 1; j <= rowend; j++) {
			peri.add(matrix[j][colend]);
		}
		for (int j = colend - 1; j >= start; j--) {
			peri.add(matrix[rowend][j]);
		}
		for (int j = rowend - 1; j > start; j--) {
			peri.add(matrix[j][start]);
		}
		return peri;
	}

	public static void main(String[] args) {

	}





}