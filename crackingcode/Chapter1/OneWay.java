import java.lang.Math;
class OneWay {
	// given two strings, check if thery are one edit (or zero edits) away
	// one edit: insert a char, remove a char, replace a char
	public boolean oneWay(String s1, String s2) {
		if (s1 == null || s2 == null || Math.abs(s1.length() - s2.length()) > 1) { return false; }
		if (s1.length() < s2.length()) { return oneWay(s2, s1); }
		// s1 's length is always higher than or equal to s2 's length
		// 1. 如果两者长度相等，非常简单，同时移动记录不同的数字即可
		// 2. 如果两者长度不等，那么首先s1的长度永远大于s2的长度，如果第一个不相等
		// 比如abcdp 和 bcdp， 如果a和b不相等，考虑满足条件的情况，必须使得s2是s1的子集
		// 也就是说 必须使得a后面的所有数等于b
		// 另一种情况 abcdp VS abdp，当c出现不相等的情况，必须使得指针从c往后移，判断后面的全部相等
		int i = 0; int j = 0; boolean diff = false;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(j)) { // 情况: 若两者出现了不相等
				// System.out.println(s1.charAt(i) + " " + s2.charAt(j));
				if (diff == true) { return false; } // 如果已经有一个不相等，直接返回false
				diff = true;
				if (s1.length() != s2.length()) { i++; continue; } // 如果长度不等，那么长的加，短的不加		
			}
			i++; j++; // 相等的情况是都加
		}
		return true;

	}

	public static void main(String[] args) {
		OneWay o = new OneWay();
		System.out.println(o.oneWay("pale", "ple") + " : true");
		System.out.println(o.oneWay("pale", "pale") + " : true");
		System.out.println(o.oneWay("pale", "bcle") + " : false");
		System.out.println(o.oneWay("pale", "palex") + " : true");
		System.out.println(o.oneWay("pale", "pl") + " : false");
		System.out.println(o.oneWay("pale", "bple") + " : false");
		System.out.println(o.oneWay("pale", "balex") + " : false");

	}
}