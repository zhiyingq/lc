import java.lang.IllegalArgumentException;
class MissingNumber {
	/*
	public int missingNumber(int[] nums) {
		// linear time	
		int[] order = new int[nums.length];
		for (int i = 0; i < order.length; i++) {
			order[i] = -1;
		}
		for (int i : nums) {
			order[i] = i;
		}
		for (int i = 0; i < order.length; i++) {
			if (order[i] == -1) {
				return i;
			}
		}
		throw new IllegalArgumentException();

	}
	*/

	// O(n) complexity, O(1) space
	// 用位运算, 异或门XOR，即包含A也包含B，但不包括A和B的公共部分
	// 可知异或门XOR有如下性质：交换律、结合律
	// 异或门也可用于二进制的加法，因此A ^ B ^ C ^ D = D ^ C ^ B ^ A...
	// 由此，我们已知a^b^b=a,那么可以有ini=0
	// 只要对ini进行所有的从0-n的n+1个数的异或运算，由于nums只含有n个数：
	// ini^0^1^....^n^nums[0]^nums[1]^....^nums[n-1]
	// 最后得到的结果就是ini^number_left = number_left
	public int missingNumber(int[] nums) {
		int ini = 0; int i = 0;
		for (i = 0; i < nums.length; i++) {
			ini = ini ^ i ^ nums[i];
		}
		return ini ^ i;

	}
}