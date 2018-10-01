import java.util.List;
import java.util.ArrayList;
class GenerateParentheses022 {
	public List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<String>();
        backtrackHelper(parentheses, "", n, 0, 0);
        return parentheses;
    }

    public void backtrackHelper(List<String> list, String s, int n, int open, int close) {
    	if (s.length() == 2*n) { list.add(s); }
    	else {
    		if (open < n) { 
    			backtrackHelper(list, s + "(", n, open + 1, close);
    		}
    		if (open > close) {
    			backtrackHelper(list, s + ")", n, open, close + 1);
    		}
    	}
    }
}