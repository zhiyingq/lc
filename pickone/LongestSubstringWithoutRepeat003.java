import java.util.Map;
import java.util.HashMap;

class LongestSubstringWithoutRepeat003 {
	public int lengthOfLongestSubstring(String s) {
		// idea: sliding window
		if (s == null || s.length() == 0) { return 0; }
		// use the sliding window
		int begin = 0; int end = 0; int max = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while (end < s.length()) {
            if (end - begin > max) { max = end - begin; }  // save the max
			// anyway, put the char into the map
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
			// if the map initially not contains the char, go further		
			if (map.get(s.charAt(end)) != 1) { 
				while (map.get(s.charAt(end)) > 1) {	// move "begin" until no duplicate
					map.put(s.charAt(begin), map.get(s.charAt(begin)) - 1); 
					begin++;
				}
			}
            end++;
		}
        // in this case, 如果最后是连续的几个不同的数且长度最大，由于最后一个end跳出了循环，所以就来不及更新
        // 因此在这里需要更新最后的max值（如果存在的话）
		return max = (end - begin > max ? end - begin : max);
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeat003 l = new LongestSubstringWithoutRepeat003();
		System.out.println(l.lengthOfLongestSubstring("aab"));
	}
}