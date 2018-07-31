// import java.util.Math;
class SqrtX069 {
	public int mySqrt(int x) {
		int temp = x;
		while (temp != 0 && x / temp < temp) {
			System.out.println((temp - (x / temp)) / 2);
			temp = temp - (temp - x / temp) / 2;

			System.out.println(temp);
		}
		return temp;
	}

	public static void main(String[] args) {
		SqrtX069 s = new SqrtX069();
		System.out.println(s.mySqrt(8));
	}
}