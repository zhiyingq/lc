/*
If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.
*/
class GasStation134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] diff = new int[2 * gas.length];
		int arrsum = 0;
		for (int i = 0; i < 2 * gas.length; i++) {
			if (i < gas.length) {
				diff[i] = gas[i] - cost[i];
			}
			else {
				diff[i] = diff[i - gas.length];
			}
			arrsum += diff[i];
		}
		if (arrsum < 0) { return -1; }
		// find the consecutive largest integer sequence
		// kadane algorithm
		// sum: to save the sum STARTS at i
		// globalMax: the largest sum until now
		// start: the start point of the globalMax

		// 这里的主要思想是，首先增加数列的长度（2段），使得首尾可以相接
		// 从后往前行走，可记录指针的起始点
		// sum >= globalMax使得指针总是停留在第一个数列里
		int sum = Integer.MIN_VALUE; int start = 0; 
		int globalMax = Integer.MIN_VALUE;
		for (int i = diff.length - 1; i >= 0; i--) {
			sum = diff[i] + (sum > 0 ? sum : 0); // update the "local" sum
			if (sum >= globalMax) {
				globalMax = sum;
				start = i;
			}

		}

		// special case: if like this: [1,3,-1,-2,-1,-3,3]
		// in fact we should consider the last index and the first index
		// thus if start = 0, we should consider if the last index,
		// or even before is larger than 0

		return start;

	}

	public static void main(String[] args) {
		GasStation134 g = new GasStation134();
		System.out.println(g.canCompleteCircuit(
			new int[] {1,2,3,4,5},
			new int[] {3,4,5,1,2}));
	}
}












