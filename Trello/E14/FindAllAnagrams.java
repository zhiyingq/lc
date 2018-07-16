import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class FindAllAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0) { return result; }

		// construct a map and save the value
		Map<Character, Integer> pmap = new HashMap<Character, Integer>();
		for (char i : p.toCharArray()) {
			pmap.put(i, pmap.getOrDefault(i, 0) + 1);
		}
		// System.out.println(pmap);

		int start = 0, end = 0, count = p.length();
		while(end < s.length()) {
			// end指针：首先一直指向所有p的char都满足的那个字符为止
			// 比如p="abca"，那么当出现了2个a，1个b，1个c的时候end会停下，停在最后那个字符的后面
			char c = s.charAt(end);
			if (pmap.containsKey(c)) {
				pmap.put(c, pmap.get(c) - 1);
				if (pmap.get(c) == 0) { count--; }
			}		
			end++;

			// 当end停下时，此时的count为0，表示所有数都包含，此时开始缩短start
			// 只有在所有数都包含+end-start=p.length()的情况下才能满足正好符合条件
			// 而每次b的运算就表明——”如果去除这个数，从(begin, end)区间内的数是否还满足count=0的条件“
			// 当pmap.get(b)为正的时候，表示缺这个数，当其为负的时候，表示多了这个数
			// 所以一旦pmap.containsKey(b)的时候，因为b马上要被移走了，所以+1，表示即将缺省一个b
			// 当从0变为1的时候表示缺省b
			// 从而count就++， 整个思路是反过来的
			while (count == 0) {
				char b = s.charAt(start);
				if (pmap.containsKey(b)) {
					pmap.put(b, pmap.get(b) + 1);
					if (pmap.get(b) > 0) { count++; }
				}
				if (end - start == p.length()) { result.add(start); }
				start++;
			}
		}
		return result;
	}


	/*
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>(); 
		if (s == null || s.length() == 0) { return result; }
		// This is the map to save the characters in p
		Map<Character, Integer> pmap = new HashMap<Character, Integer>();
		// construct a map to conut the times that one character appears
		for (int i = 0; i < p.length(); i++) {
			if (pmap.containsKey(p.charAt(i))) { 
				pmap.put(p.charAt(i), pmap.get(p.charAt(i)) + 1);
			}
			else {
				pmap.put(p.charAt(i), 1);
			}
		}

		// s.length() - p.length() + 1
		// to save the space for the string p
		for (int i = 0; i < s.length() - p.length() + 1; i++) {
			// Map for saving the p.length() numbers to check 
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (int j = i; j < i + p.length(); j++) {
				if (map.containsKey(s.charAt(j))) { 
					map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
				}
				else {
					map.put(s.charAt(j), 1);
				}
			}

			boolean equal = true;
			for (Character c : map.keySet()) {
				if (!pmap.containsKey(c) || pmap.get(c) != map.get(c)) { 
					equal = false;
				}
			}	
			if (equal) { result.add(i); }
		}
		return result;
		


	}
	*/

	public static void main(String[] args) {
		FindAllAnagrams f = new FindAllAnagrams();
		System.out.println(f.findAnagrams("cbaebabacd", "abc"));
	}

}