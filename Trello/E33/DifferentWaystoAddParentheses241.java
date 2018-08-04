import java.util.List;
import java.util.ArrayList;
class DifferentWaystoAddParentheses241 {
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }

    private void compute(String s, List<Integer> results) {
    	// // 处理只含有一个运算符的情况
    	// char op1 = ifOneOp(s);
    	// if (op1 != '0') { results.add(computeSub(s, op1)); return; }
    	// 如果含有多个运算符
    	for (int i = 0; i < s.length(); i++) {
    		if (isOpeartor(s.charAt(i))) { continue; }
    		if (i == 0 || isOpeartor(s.charAt(i - 1))) { 
    			char op2 = '0';
    			for (int j = i + 1; j <= s.length(); j++) {
    				if (j == s.length() || isOpeartor(s.charAt(j))) {
    					if (op2 != '0') {
    						// System.out.println("substring: "+s.substring(i,j));
    						int res = computeSub(s.substring(i, j), op2);
    						System.out.println("res = "+res);
    						if (j - i == s.length()) { 
    							results.add(res); 
    							System.out.println("add: "+res);
    							return; 
    						}
    						
    						compute(s.substring(0, i) + String.valueOf(res) + s.substring(j), results);
    						System.out.println("string: "+s.substring(0, i) + String.valueOf(res) + s.substring(j));
    						break;
    					}
    					else {
    						if (j != s.length()) op2 = s.charAt(j);
    						
    					}
    				}
    			}
    		}
    	}

    }

    private boolean isMulti(char c) { return c == '*'; }
    private boolean isPlus(char c) { return c == '+'; }
    private boolean isMinus(char c) { return c == '-'; }
    private boolean isOpeartor(char c) { return isMulti(c) || isPlus(c) || isMinus(c); }
    private int computeSub(String s, char op) {
    	System.out.println(s);
    	String[] nums = new String[2];
    	if (op == '*') { nums = s.split("\\*"); }
    	else if (op == '+') { nums = s.split("\\+"); }
    	else { nums = s.split("-"); }
    	int num1 = Integer.parseInt(nums[0]);
    	int num2 = Integer.parseInt(nums[1]);
    	if (isMulti(op)) { return num1 * num2; }
    	if (isPlus(op)) { return num1 + num2; }
    	return num1 - num2;
    }
    
    public static void main(String[] args) {
    	DifferentWaystoAddParentheses241 d = new DifferentWaystoAddParentheses241();
    	System.out.println(d.diffWaysToCompute("23*1+5-6*3"));
    }

    
    	
}