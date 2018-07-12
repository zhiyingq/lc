import java.util.HashMap;
import java.util.Map;
import java.lang.IllegalArgumentException;

class TwoSum {
	public int[] twoSumBrute(int[] nums, int target) {
		int[] solution = new int[2];
		boolean found = false;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					solution[0] = i;
					solution[1] = j;
					found = true;
					break;
				}
			}
			if (found == true) { break; }
		}
		return solution;
	}

	/*
		Java inferface Map:
		An object that maps keys to values. A map cannot contain duplicate keys; 
		each key can map to at most one value.
		
		——一个愚蠢的见解：
		由于一个map不能含有重复的key，所以用这个是默认了列表里不会有重复的元素
		如果重复的元素的话，key会被覆盖，这里key值就是列表中的元素值，而value
		则是其元素所对应的下标 ****这句话是错误的！

		这里有一个非常tricky的部分，就是如果有同样的key的话，不管是2个还是100个，
		后面的key会把前面的key的value给覆盖掉。这是第一个for-loop

		而在第二个for-loop中，由于i是从0开始的，那么这样判断的时候，则会有两种情况：
		1. remain = nums[i]， 那么这样的话就会找到最后一个相同的值，比如 
		[2,3,4,5,6,2,2,2,7]中target为4，那么会输出0和7
		2. remain != nums[i]，那么这样的话也还是会输出与remain相同的最后一个数的下标。
		[2,3,4,5,6,2,2,2,7,7]中target为9，会输出0和9
		3. 输出第一个下标永远是最小的那个: [2,2,2,3,4,5,6,2,2,2,7,7]中target
		为9，会输出0和11

		因为我们要找到元素值-从而判断是否有其对应的数存在，而map找key是constant
		time的，找value则需要遍历，因此这里是把元素值存在key中

	*/
	public int[] twoSumHash(int[] nums, int target) {
		// to initialize the map
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// to put the key & value into the hashtable
		for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); }
        
		for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain) && map.get(remain) != i) {
				return new int[]{i, map.get(remain)};
			}        
		}

		// if no result, throw exception
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String args[]) {
		TwoSum a = new TwoSum();
		// int[] as = a.twoSumBrute(new int[]{2,7,11,15}, 9);
		int[] as = a.twoSumHash(new int[]{2,7,11,15}, 9);
		for (int i:as) {
			System.out.println(i);
		}
	}
}