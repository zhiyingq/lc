import java.util.ArrayList;
import java.util.List;

class PascalTriangle2 {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> arr = new ArrayList<Integer>(rowIndex);
		arr.add(1);
		if (rowIndex == 1) { 		
			return arr;
		}
		arr.add(1);
		if (rowIndex == 2) { 
			return arr;
		}
		List<Integer> prev = getRow(rowIndex - 1);
		for (int i = 1; i < rowIndex - 1; i++) {
			arr.add(i, prev.get(i - 1) + prev.get(i));
		}
		return arr;
	}

	public static void main(String[] args) {
		PascalTriangle2 p = new PascalTriangle2();
		System.out.println((p.getRow(5)).toString());
	}

}