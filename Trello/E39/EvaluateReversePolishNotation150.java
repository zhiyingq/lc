import java.util.Stack;
class EvaluateReversePolishNotation150 {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>(); 
        for (String s : tokens) {
        	if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
        		int second = stack.pop();
        		int first = stack.pop();
        		if (s.equals("+")) { stack.push(first + second); }
        		if (s.equals("-")) { stack.push(first - second); }
        		if (s.equals("*")) { stack.push(first * second); }
        		if (s.equals("/")) { stack.push(first / second); }
        	}
        	else {
        		stack.push(Integer.parseInt(s));
        	}
        }
        return stack.pop();
    }

    public static void main(String[] args) {

    }


}