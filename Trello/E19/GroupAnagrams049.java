import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class GroupAnagrams049 {
	// given an array of string, grou anagrams together
	/*
	public List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> groups = new ArrayList<List<String>>();
		// hashmaps to save the corresponding letters, with the same sequence as groups
		List<Map<Character, Integer>> mapList = new ArrayList<Map<Character, Integer>>();
		if (strs == null || strs.length == 0) { return groups; }
		for (String word : strs) { // for every "word"
			// construct a hashmap for word —— wordmap
			Map<Character, Integer> wordmap = new HashMap<Character, Integer>();
			for (char c : word.toCharArray()) { wordmap.put(c, wordmap.getOrDefault(c, 0) + 1); }
			// check whether the hashmap already exists somewhere
			boolean found = false;
			for (int i = 0; i < groups.size(); i++) { // for every "wordlist" in the groups
				// as long as a wordlist exits, it has at least one element
				List<String> wordlist = groups.get(i);
				if (wordlist.get(0).length() != word.length()) { continue; } // check the length first
				// this means that at least the length is the same
				// then we need to check whether the mashmap equals
				// wordmap V.S. wordlistmap
				Map<Character, Integer> wordlistmap = mapList.get(i);
				if (wordlistmap.entrySet().equals(wordmap.entrySet())) { wordlist.add(word); found = true; break; }
			}
			// how do I know that the word is added to the wordlist or not? 
			if (!found) {
				mapList.add(wordmap);
				List<String> thisword = new ArrayList<String>();
				thisword.add(word);
				groups.add(thisword);
			}

		}
		return groups;
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<Map<String>> groups = new ArrayList<List<String>>();
		List<String> combs = new ArrayList<String>();
		if (strs == null || strs.length == 0) { return groups; }
		for (String word : strs) {
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			String reword = new String(ch);
			boolean found = false;
			for (int i = 0; i < combs.size(); i++) {
				if (combs.get(i).equals(reword)) { groups.get(i).add(word); found = true; break; }	
			}
			if (!found) { 
				combs.add(reword);
				List<String> l = new ArrayList<String>();
				l.add(word);
				groups.add(l);
			}
		}
		return groups;
	}
	*/

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> groups = new HashMap<String, List<String>>();
		if (strs == null || strs.length == 0) { return new ArrayList<>(); }
		for (String word : strs) {
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			String reword = new String(ch);
			if (groups.containsKey(reword)) { groups.get(reword).add(word); continue; }
			groups.put(reword, new ArrayList<String>());
			groups.get(reword).add(word);
		}
		return new ArrayList(groups.values());

	}

	public static void main(String[] args) {
		// Map<Character, Integer> m1 = new HashMap<Character, Integer>();
		// Map<Character, Integer> m2 = new HashMap<Character, Integer>();
		// m1.put('a', 1); m1.put('b', 2);
		// m2.put('b', 2); m2.put('a', 1); 
		// System.out.println(m1.entrySet());
		// System.out.println(m2.entrySet());
		// System.out.println(m1.entrySet().equals(m2.entrySet()));
		GroupAnagrams049 g = new GroupAnagrams049();
		System.out.println(g.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));

	}
}