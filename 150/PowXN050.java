import java.lang.Math;
class PowXN050 {
	public double myPow(double x, int n) {
		if (n == 0) { return 1; }
		if (n < 0) {
			return (1/x) * myPow(1/x, -(n+1));
		}
		return n % 2 == 0 ? myPow(x*x, n/2) : x * myPow(x*x, n/2);       
    }

    public static void main(String[] args) {
    	// double i = Infinity;
    	System.out.println(1 / Double.POSITIVE_INFINITY);
    }

}