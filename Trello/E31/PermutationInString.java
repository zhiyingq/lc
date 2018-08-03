import java.util.Map;
import java.util.HashMap;
class PermutationInString {
    
	public boolean checkInclusion(String s1, String s2) {
        // input strings only contain lower case letters
        if (s1 == null || s2 == null) { return false; }
        if (s1.length() == 0) { return true; }
        if (s2.length() == 0) { return false; }

        int[] letter1 = new int[26];
        for (char c : s1.toCharArray()) { letter1[c - 'a']++; } // initialize
        int count = 0; // count the # of distinct letters
        for (int i : letter1) { if (i > 0) { count++; }}
        int end = 0; int begin = 0;
        while (end < s2.length() && begin < s2.length()) { 
        	int i1 = s2.charAt(end) - 'a'; 
            letter1[i1]--;
            //    System.out.println("end = "+end+". char = "+s2.charAt(end)+". letter[end] = "+letter1[i1]);
        	// System.out.println("begin = "+begin);
        	if (letter1[i1] == 0) { 
        		count--;
        		if (count == 0)  return true; 
        	}
        	
        	while (letter1[i1] < 0) {
                int i2 = s2.charAt(begin) -'a';
        		letter1[i2]++;
        		if (letter1[i2] == 1) { count++; }
        		begin++;
        	}
        	end++;
        }
        return false; 
    }

    public boolean checkInclusionSlide(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) { return false; }
        if (s1.length() == 0) { return true; }
        if (s2.length() == 0) { return false; }

        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        if (isAllZero(letters)) { return true; }
        for (int i = s1.length(); i < s2.length(); i++) {
            letters[s2.charAt(i - s1.length()) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
            if (isAllZero(letters)) { return true; }
        }
        return false;
    }

    private boolean isAllZero(int[] nums) {
        for (int i : nums) {
            if (i != 0) { return false; }
        }
        return true;
    }
    

    public boolean checkInclusionMap(String s1, String s2) {
        if (s1 == null || s2 == null) { return false; }
        if (s1.length() == 0) { return true; }
        if (s2.length() == 0) { return false; }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // put the chars to the map
        for (char c : s1.toCharArray()) { map.put(c, map.getOrDefault(c, 0) + 1); } 
        int count = map.size();
        int end = 0; int begin = 0;
        while (end < s2.length() && begin < s2.length()) {
            char c1 = s2.charAt(end);
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) - 1);
                if (map.get(c1) == 0) { count--; }
                    
            }
            // 只有在含有key的时候才减
            // 到某一时刻，begin和end之间会出现所有满足条件的数
            // 如，我想寻求abc, s2 = aaaasbxxxchj
            // 那么到aaaasbxxxc时count会第一次为0

            // 在以上控制条件中，到c时，map.get(a)应该会等于-3
            // while-loop所控制的条件是: 在所有数齐全的情况下把begin向end移动
            while (count == 0) {
                if (end - begin + 1 == s1.length()) { return true; }
                char c2 = s2.charAt(begin);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) > 0) { count++; }
                }
                begin++;
            }
            end++;
        } 
        return false;
        
    }

    public static void main(String[] args) {
    	PermutationInString p = new PermutationInString();
    	String s1 = "trinitrophenylmethylnitramine";
    	String s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine";
    	System.out.println(p.checkInclusionSlide(s1, s2));
    }
}
















