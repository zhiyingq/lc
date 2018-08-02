import java.util.Arrays;
class CheckPermutation {
	// given two strings
	// decode if one is a permutation of the other

	// 1. ASCII - 需要改进
	// 最初的方案是，把a和b直接放进两个数组里，然后再判断两个数组是否相等
	// 但是现在其实可以先保存a，然后再用b来减，后面的Map也是一样
	public boolean isPermutation(String a, String b) {
		if (a == null || b == null || a.length() == 0 || b.length() == 0 || a.length() != b.length()) { return false; }
		/* 
		****initial solutino****
		char[] charA = new char[128];
		char[] charB = new char[128];
		for (int i = 0; i < a.length(); i++) {
			charA[a.charAt(i) - 'a']++;
			charB[b.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 128; i++) {
			if (charA[i] != charB[i]) return false;
		}
		return true;
		*/

		// ****improved solutino****
		char[] arr = new char[128];
		for (char c : a.toCharArray()) {
			// 注意c既然是ASCII码的话直接就可以用了
			arr[c]++;
		}
		for (char c : b.toCharArray()) {
			arr[c]--;
			if (arr[c] < 0) { return false; } // 因为Length一样所以有不一致的地方必定会有一个-1产生
		}
		return true;
	}

	// 2. 存放到HashMap中

	// 3. Sort判断是否一致 O(NlogN)
	public boolean isPermutationSort(String a, String b) {
		if (a == null || b == null || a.length() == 0 || b.length() == 0 || a.length() != b.length()) { return false; }
		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();
		Arrays.sort(charA); Arrays.sort(charB);
		for (int i = 0; i < charA.length; i++) {
			if (charA[i] != charB[i]) return false;
		}
		return true;
		// return new String(charA).equals(new String(charB));
		// String pool: String s1 = "hello"存储在string pool 里
		// new String("hello") 存储在heap里, 但其指向的是string pool里的对象
		// 所以我们可以认为new String(charA)和new String(charB)是equal的
	}


	public static void main(String[] args) {
		CheckPermutation c = new CheckPermutation();
		char[] c1 = new char[] {'a', 'b', 'c'};
		char[] c2 = new char[] {'a', 'b', 'c'};

		System.out.println(Arrays.equals(c1, c2));
		System.out.println(c.isPermutationSort("advantage", "vantagead"));
	}
}