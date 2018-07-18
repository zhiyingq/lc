import java.lang.Math;
import java.lang.StringBuilder;

class MultiplyStrings {
	public String multiply(String num1, String num2) {
		// construct an int array to save the products
		int[] product = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				product[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				// System.out.println("product: "+product[i + j + 1]);
				// to save the numbers which belong to i+j+1
				// then we would add the numbers in unit and decade
			}
		}

		int carry = 0;
		for (int i = product.length - 1; i >= 0; i--) {
			int number = product[i];
			// System.out.println("carry: "+carry+" number: "+number);
			product[i] = (carry + number) % 10;
			// System.out.println("product[i]: "+product[i]);
			carry = (carry + number) / 10;

		}

		StringBuilder str = new StringBuilder();
		int zero = 0;
		while (zero < product.length) {
			if (product[zero] == 0) { zero++; continue; }
			break;
		}
		if (zero == product.length) { return "0"; }
		for (int i = zero; i < product.length; i++) {
			str.append(product[i]);
		}
		return str.toString();
	}

	public static void main(String[] args) {
		MultiplyStrings m = new MultiplyStrings();
		// String a = "456";
		// String b = "123";
		
		System.out.println(m.multiply("0","33232345"));

	}
}	