import java.lang.Math;
class ContainerWithMostWater011 {
	public int maxArea(int[] height) {
		// every time, move the lower height
		// to see if it's possible to make area larger
		// and record the area
		// because not moving the lower will not make the area larger
		int max = Integer.MIN_VALUE;
		int i = 0; int j = height.length - 1;
		while (i < j) {
			max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
			if (height[i] < height[j]) { i++; }
			else { j--; }
		}
		return max == Integer.MIN_VALUE ? 0 : max;
	}

}