import java.util.Set;
import java.util.HashSet;
class ContainsDuplicate217 {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (set.contains(i)) { return true; }
			set.add(i);
		}
		return false;
	}
}