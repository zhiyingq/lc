import java.util.HashMap;
import java.util.Map;

class Test {
	public static void main(String[] args) {
		Map<Integer, Integer> a = new HashMap<>();
		a.put(1,1);
		System.out.println(a.toString());
		a.put(1,2);
		System.out.println(a.toString());
		a.put(2,2);
		System.out.println(a.toString());
	}

}