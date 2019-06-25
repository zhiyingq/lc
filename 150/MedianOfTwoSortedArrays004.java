class MedianOfTwoSortedArrays004 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) return 0.0;
        int m = nums1.length;
        int n = nums2.length;
        
        // ensure that n >= m 
        if (n < m) { return findMedianSortedArrays(nums2, nums1); }

        // n >= m
        // i: range from [0, m]
        // if i == 0: left side has no element
        // if i == m: right side has no element
        // if j == 0: left side has no element
        // if j == n: right side has no element
        int min = 0, max = m;
        while (min <= max) {
        	int i = min + (max - min) / 2;
        	int j = m + (n - m) / 2 - i;  // if n - m is odd, make nums2[j - 1] the middle
        	if (i > 0 && j < n && nums1[i - 1] > nums2[j]) { max = i - 1; }
        	else if (j > 0 && i < m && nums2[j - 1] > nums1[i]) { min = i; }
        	else {
        		// i符合要求
        		// 不管个数是奇数还是偶数，leftMax都是需要的
        		int leftMax;
        		if (i == 0) { leftMax = nums2[j - 1]; }
        		else if (j == 0) { leftMax = nums1[i - 1]; }
        		else {
        			leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
        		}

        		if ((m + n) % 2 == 1) return leftMax;

        		int rightMax;
        		if (i == m) { rightMax = nums2[n - 1]; }
        		else if (j == n) { rightMax = nums1[m - 1]; }
        		else {
        			rightMax = Math.max(nums1[m - 1], nums2[n - 1]);
        		}

        		return (leftMax + rightMax) / 2。0;
        	}


        }
        return 0.0;
    }
}










