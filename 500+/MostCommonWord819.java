import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class MostCommonWord819 {
	public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("[!?',;. ]+");
        for (String word : words) {
        	System.out.println("get a word: "+ word + "\t");
        }
        // save the banned words into a hashset
        Set<String> set = new HashSet<String>();
        for (String bannedWord : banned) {
        	set.add(bannedWord);	
        }


        // save the words into a hashmap
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
        	// System.out.print("for word: "+word+"\n");
        	String lowerWord = word.toLowerCase();
        	if (!set.contains(lowerWord)) {
        		map.put(lowerWord, map.getOrDefault(lowerWord, 0) + 1);
        		// System.out.println("map added: "+lowerWord+" with value " + map.get(lowerWord));
        	}
        }

        int max = -1;
        String mostFrequent = "";
        for (String word : map.keySet()) {
        	if (map.get(word) > max) {
        		max = map.get(word);
        		mostFrequent = word;
        	}
        }

        return mostFrequent;
        
    }

    public static void main(String[] args) {
    	MostCommonWord819 m = new MostCommonWord819();
    	String s = m.mostCommonWord("'v x,x. !Z?Y'p Z;", new String[] {"z"});
    	System.out.println(s);
    }
}