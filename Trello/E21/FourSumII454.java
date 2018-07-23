import java.util.Map;
import java.util.HashMap;

/*
	save the value of A + B to array AB, with n2 numbers in it
	duplicate is allowed, time : O(n2)

	then for every element in AB, note that this is a combination of index i & j
	we find the corresponding element in CD, which is also a combination of index k & l
	CD is saved in a map, the first index is used to record the value, and the second is times
	then if a number in AB find the value in CD, there are CD.get(value) kinds of combinations
	combinations += CD.get(value);
*/
class FourSumII454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // just combine A & B, B & C, and doing two sum in the new array
        // Note. ABCD have the same length
        if (A == null || A.length == 0) { return 0; }
        int[] AB = new int[A.length * B.length]; // construct an int array to save the value of A + B (n2 numbers)
        Map<Integer, Integer> CD = new HashMap<Integer, Integer>(); // construct a hashmap to save the value of C + D (n2 numbers)

        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < B.length; j++) {
        		AB[i * A.length + j] = A[i] + B[j];
        		CD.put(C[i] + D[j], CD.getOrDefault(C[i] + D[j], 0) + 1);
        	}
        }
        int combs = 0;
        for (int i : AB) { combs += CD.getOrDefault(-i, 0); }
        return combs;
    }

    public static void main(Stirng[] args) {

    }
}