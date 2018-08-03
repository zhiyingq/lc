import java.util.List;
import java.util.LinkedList;
class CountPrimes204 {
	public int countPrimes(int n) {
        // Count the number of prime numbers less than a non-negative number, n.
		if (n <= 2) { return 0; }
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!notPrime[i]) { 
				count++; 
				if (i <= n / i) {
					for (int j = i; i * j < n; j++) {
						notPrime[i*j] = true;
					}
				}
			}
		}
		return count;
    }

    public static void main(String[] args) {
    	CountPrimes204 c = new CountPrimes204();
    	System.out.println(c.countPrimes(5555555));
    }
}