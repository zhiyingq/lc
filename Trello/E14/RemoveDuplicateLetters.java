import java.util.Stack;
import java.lang.StringBuilder;

class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		/*
		Main Idea: 
		1. Whenever I put something into the stack, I will follow the sequence
		2. When I put a character into the stack, if the chars already in the stack
		, which is larger than the character at the same time, also exist in the following 
		char array, I will tick them off the stack.
		3. I will not put a same number into the stack if it already exists.
		*/

		if (s == null || s.length() == 0 || s.length() == 1) { return s; }
		int[] countNums = new int[26];
		for (char c : s.toCharArray()) {
			countNums[c - 'a']++;
		}
		// now we get the array, which counts the times that each character appears
		// now we need to construct an array to record whether the char is
		// contained in the stack. We also need to construct a stack
		boolean[] inStack = new boolean[26];
		Stack<Character> stack = new Stack<Character>();

		// now we need to put the characters into the stack
		// the condition to be put into the stack is:
	    // 
		for (char c : s.toCharArray()) {
			countNums[c - 'a']--;
			if (inStack[c - 'a']) { continue; }
			while(!stack.isEmpty() && countNums[stack.peek() - 'a'] > 0 && stack.peek() > c) {
				inStack[stack.pop() - 'a'] = false;
			}
			stack.push(c);
			inStack[c - 'a'] = true;
		}

		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		return sb.toString();



	}

	public static void main(String[] args) {
		RemoveDuplicateLetters r = new RemoveDuplicateLetters();
		System.out.println(r.removeDuplicateLetters("cbacdcbc"));

	}
}