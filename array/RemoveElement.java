import java.lang.IndexOutOfBoundsException;

class RemoveElement {
	//Given an array nums and a value val, remove all instances of that value in-place and return the new length.
	//The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	public int removeElement(int[] nums, int val) {
		// 定位index至数组最后一位
		int index = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				while (nums[index] == val) { 
					index--; 
					// This is to ensure that the index should not be less than 0
					// because if < 0, the next loop while throw arrayindexoutofboundexceptino
					if (index < 0) { break; }
				}
				if (i < index) { 
					swap(nums, i, index);
				}
				// if i >= index means the swap has ended
				// and there is no need to continue
				else { break; }
			}
		}

		index++;
		return index;
	}

	private static void swap(int[] nums, int i, int index) {
		if (i < 0 || index >= nums.length) {
			throw new IndexOutOfBoundsException();
		}
		int temp = nums[i];
		nums[i] = nums[index];
		nums[index] = temp;
	}


	/* 推荐答案
	public int removeElement(int[] nums, int val) {
        int i = 0;
        // 在这里我们不要考虑剩余array的值
        // 比如，从第一个元素开始，如果nums[j]不是所要删除的值，那么就直接存放在nums[i]中，此时i跳到下一个位置
        // 而一旦nums[j]等于所要删除的值val，那么就直接跳过，直到碰到不同的值再把nums[j]的值存储在nums[i]中
        // 最后由于i永远是后一个值，正好是长度，所以直接返回i即可
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    */
}