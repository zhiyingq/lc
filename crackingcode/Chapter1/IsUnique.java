import java.util.Set;
import java.util.HashSet;
class IsUnique {
	// if a string has all unique characters
	// cannot use additional data structures

	// Method that use Set
	public boolean isUnique(String s) {
		if (s == null || s.length() == 0) { return false; }
		Set<Character> set = new HashSet<Character>();
		for (char c : s.toCharArray()) {
			if (set.contains(c)) { return false; }
			set.add(c);
		}
		return true;
	}

	// if ASCII
	// Time compleixty(O(min(128, n)) or O(128))
	public boolean isUniqueASCII(String s) {
		if (s == null || s.length() == 0 || s.length() > 128) return false;
		boolean[] set = new boolean[128];
		for (char c : s.toCharArray()) {
			int index = c;
			if (set[index] == true) { return false; }
			set[index] = true;
		}
		return true;
	}

	/* bit vector, only lowercase digits
	关于使用位运算，因为字符串都是由lowercase组成的，a-z即0-25，是小于32位的，
	因此，1可以表示成Ox0001,一旦出现一个字符，比如'c'，我们可以把'c'-'a'保存起来，
	作为1左移的距离。在这里就是左移两位，同时我们有一个计数器为counter，初始值为0，
	这样当前26个bit中某一个和左移后的1进行与运算大于0的时候，就知道是重复了。
	*/
	public boolean isUniqueBit(String s) {
		int checker = 0;
		for (char c : s.toCharArray()) {
			int val = c - 'a'; // System.out.println(val);
			val = 1 << val; // System.out.println(val);
			if ((checker & val) > 0) return false;
			checker |= val;
		}
		return true;
	}

	// 对于其他不占用数据结构的算法，只能有暴力求解法和排序算法。

	// No additional data structure
	public static void main(String[] args) {
		String s = "ca";
		IsUnique is = new IsUnique();
		System.out.println(is.isUniqueBit(s));
	}
}