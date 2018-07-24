import java.lang.StringBuilder;
import java.util.Stack;
class ReverseVowelsofaString345 {
	public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> charStack = new Stack<Character>();
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char c : chars) {
        	if (c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o' || c == 'A' || c == 'E' || c == 'I' || c == 'U' || c == 'O')
        	{ charStack.push(c); }	
        }

        for (int i = 0; i < chars.length; i++) {
        	if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'u' || chars[i] == 'o' || chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'U' || chars[i] == 'O')
       		{ chars[i] = charStack.pop(); }
       	}
        		
        	
 
        return new String(chars);
    }

    public static void main(String[] args) {
    	ReverseVowelsofaString345 r = ReverseVowelsofaString345();
    	System.out.println(r.reverseVowels("leetcode"));
    }
}