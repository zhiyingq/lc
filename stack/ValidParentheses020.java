import java.util.Stack;
class ValidParentheses020 {
	// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
	// determine if the input string is valid.
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
        	if (stack.isEmpty()) { stack.push(c); }
        	else {
        		char peek = stack.peek();
        		if ((c == ')' && peek == '(') || (c == '}' && peek == '{') || (c == ']' && peek == '[')) {
        			stack.pop();
        		}
        		else {
        			stack.push(c);
        		}
        	}
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
    	ValidParentheses020 v = new ValidParentheses020();
    	System.out.println(v.isValid("([)]"));
    }
}