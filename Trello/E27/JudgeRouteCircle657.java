import java.util.Stack;

class JudgeRouteCircle657 {
	public boolean judgeCircle(String moves) {
		if (moves.length() % 2 != 0) { return false; }
		String[] count = new String[4];
		for (char c : moves.toCharArray()) {
			if (c == 'U') { count[0]++; }
			if (c == 'D') { count[1]++; }
			if (c == 'L') { count[2]++; }
			if (c == 'R') { count[3]++; }
		}
		if (count[0] != count[1] || count[2] != count[3]) {
			return false;
		}
		return true;
	}
}