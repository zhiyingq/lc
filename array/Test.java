import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Test {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) { s.push(i); }
		for (int i : s) {
			System.out.print(i+" ");
		}
	}

}