
class PlusOne {
	public int[] plusOne(int[] digits) {
		int i = digits.length - 1;
		if (digits[i] != 9) { digits[i] += 1; }
		else {
			while (digits[i] == 9) {
				digits[i] = 0;
				i -= 1;
				if (i < 0) {
					int[] arr = new int[digits.length + 1];
					arr[0] = 1;
					return arr;
				}
			}
			digits[i] += 1;
		}
		return digits;

	}

	public static void main(String[] args) {
		PlusOne p = new PlusOne();
		int[] p1 = p.plusOne(new int[] {9,9,9});
		for(int i : p1) {
			System.out.println(i);
		}
	}
}