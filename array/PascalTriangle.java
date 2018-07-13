import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;


class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		// 0 case
		if (numRows <= 0) { throw new IllegalArgumentException(); }
		// construct a List<List<Integer>> object
		List<List<Integer>> rowList = new ArrayList<List<Integer>>();
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		rowList.add(row);
		// if numRows == 1, just return
		// why don't add these codes in the recursion?
		// like in the getRows function?
		// this is because there are two rows to generate at the beginning
		// thus, the recursion can only reach the 2nd row, but cannot reach the 1st row
		if (numRows == 1) { return rowList; }
		getRows(numRows, rowList);
		return rowList;

	}

	// a recursion 
	private List<Integer> getRows(int numRows, List<List<Integer>> rowList) {
		List<Integer> row = new ArrayList<Integer>();
		row.add(1); row.add(1);
		if (numRows == 2) {
			rowList.add(row);
			return row;
		}
		List<Integer> prev = getRows(numRows - 1, rowList);
		for (int i = 1; i < numRows - 1; i++) {
			row.add(i, prev.get(i) + prev.get(i - 1));
		}
		rowList.add(row);
		return row;
	}


}