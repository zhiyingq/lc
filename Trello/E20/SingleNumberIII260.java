import java.util.Iterator;	
class SingleNumberIII260 {
	/*
	public int[] singleNumber(int[] nums) {
		if (nums == null || nums.length < 2) { return new int[2]; }
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			if (set.contains(i)) { set.remove(i); }
			else { set.add(i); }
		}
		Iterator<Integer> iterator = set.iterator();
        return new int[] {iterator.next(), iterator.next()};  
    }
    */

    // use another idea: digit calculation
    // first, if we do XOR to all the numbers in nums, the result is single1 ^ single2
    // since single1 is different from single2, there must be an "one" digit in diff = single1 ^ single2
    // then we need to find out which digit it is
    // consider the expression of numbers in binary form in computer
    // if diff = 0...010100 then -diff = 1...101011+1 = 1...101100
    // which means that, diff & -diff which return 0...000100, the only digit that equals 1
    // this means that "the first one occrus in diff"
    // thus, we can split the numbers into two kinds: those that this digit equals 1, those that this digit equals 0
    // because the difference generates the "1" here
    // and the two ints must be contained in this two kinds, one for each

    public int[] singleNumber(int[] nums) {
    	int[] result = new int[2];
    	if (nums == null || nums.length < 2) { return result; }
    	int diff = 0;
    	for (int i : nums) { diff ^= i; } // get the single1 ^ single2
    	diff &= -diff; // get the first 1's location 
    	for (int i : nums) {
    		if ((i & diff) == 0) { // no one's
    			result[0] ^= i;
    		}
    		else {
    			result[1] ^= i;
    		}
    	}
    	return result;
    }

    public static void main(String[] args) {


    }
}