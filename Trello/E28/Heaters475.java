import java.util.Arrays;
import java.lang.Math;
class Heaters475 {
	/*
	1. sort the houses array
	2. sort the heaters array

	*/
	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		// for each house, find the nearest heater and record the distance
		int index = 0; int minR = 0;
		for (int house : houses) {
			while (index < heaters.length - 1 &&
				Math.abs(house - heaters[index]) >= Math.abs(house - heaters[index + 1])) {
				index++;
			}
			minR = Math.max(minR, Math.abs(house - heaters[index]));
		}
		return minR;

    }

    

    public static void main(String[] args) {
    	Heaters475 h = new Heaters475();
    	int[] houses = new int[] {1,2,3,20,17,14,8,30,27,29,31,33};
    	int[] heaters = new int[] {1,4,15,26,28,33,40};
    	System.out.println(h.findRadius(houses, heaters));

    }
}

















