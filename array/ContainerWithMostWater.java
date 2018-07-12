import java.lang.Math;
import java.util.Arrays;

class ContainerWithMostWater {
	/* BruteForce
	public int maxArea(int[] height) {
		int max = -1;
		int area = -1; 
		// sort the array
		Arrays.sort(height);

		for(int i = 0; i < height.length; i++) {
			for(int j = i; j < height.length; j++) {
				area = calArea(i+1, height[i], j+1, height[j]);
				if (area > max) {
					max = area;
				}
			}
		}
		return max;
	}
	*/
	
	// https://leetcode.com/problems/container-with-most-water/solution/
	// 太妙了 这道题主要的思想是：首先从最前和最后的两根柱子入手
	// 肯定会有一短一长，或者两者相等的情况
	// 如果移动长板inwards，那么无论怎么样都是不可能使面积增加的，因为“木桶原理”
	// 而如果移动短板inwards，那么有三种情况：更短、更长、不变
	// 也就是说，移动短板总是有机会变长的，由于已经记录了最大值max，所以总是移动短板inward
	// 就有机会达到最大的面积

	public int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int max = -1; int area = -1;
		while(i < j) {
			area = calArea(i+1, height[i], j+1, height[j]);
			if (area > max) { max = area; }
			if (height[i] < height[j]) { i++; }
			else { j--; }
		}
		return max;
	}

	private int calArea(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) * Math.min(y1, y2);
	}

	public static void main(String[] args) {
		ContainerWithMostWater c = new ContainerWithMostWater();
		int a = c.maxArea(new int[]{1,2,5,4,3,9,8,7,6});
		System.out.println(a);
	}

}