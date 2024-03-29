/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/
import java.util.Set;
import java.util.HashSet;

class SingleNumber136 {
	/*
	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			if (set.contains(i)) { set.remove(i); }
			else { set.add(i); }
		}
        return set.iterator().next();
    }
    */
    public int singleNumber(int[] nums) {
    	int xor = 0;
    	for (int i : nums) { xor ^= i; }
    	return xor;
	}

    public static void main(String[] args) {
    	SingleNumber136 s = new SingleNumber136();
    	System.out.println(s.singleNumber(new int[] {4,1,2,1,2}));
    }

}