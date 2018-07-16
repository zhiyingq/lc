import java.util.Comparator;
import java.util.Arrays;

class QueueReconstructionByHeight{
	private Comparator<int[]> BY_RECON = new TwoArray();

	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0) { return new int[][]{}; }
		if (people.length == 1) { return people; }
		Arrays.sort(people, BY_RECON);
		
		for (int i = 1; i < people.length; i++) {
			if (i > people[i][1]) {
				int j = i;
				while(j > people[j][1]) {
					int[] temp = people[j];
					people[j] = people[j - 1];
					people[j - 1] = temp;
					j--;
				}
			}
		}

		// for (int[] i : people) {
		// 	for (int j : i) {
		// 		System.out.print(j+" ");
		// 	}
		// 	System.out.println();
		// }

		return people;

	}

	// 将数组按照第一个元素从大到小排序，如果第一个元素相同，第二个元素有小到大
	// 这样确保了如果把后面的元素往前移，也只会改变其自己本身的第二个元素值，不会影响其他
	private class TwoArray implements Comparator<int[]> {
		
		public int compare(int[] a1, int[] a2) {
			if (a1.length != 2 || a2.length != 2) {
				throw new IllegalArgumentException();
			}
			if (a1[0] > a2[0]) { return -1;}
			else if (a1[0] == a2[0]) {
				return ((Integer)a1[1]).compareTo(a2[1]);
			}
			return 1;
		}
	}

	public static void main(String[] args) {
		QueueReconstructionByHeight q = new QueueReconstructionByHeight();
		q.reconstructQueue(new int[][]{{7,0}, {4,4},{7,1},{5,0},{6,1},{5,2}});

	}

}