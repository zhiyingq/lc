class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low = 0, high = mountainArr.length() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int mid1 = mountainArr.get(mid), mid2 = mountainArr.get(mid + 1);
            if (mid1 < mid2) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        // now low is the peak
        int peak = low;
        
        if (mountainArr.get(peak) == target) return peak;
        low = 0; high = peak - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);
            if (val == target) {
                return mid;
            } else if (val > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        low = peak + 1; high = mountainArr.length() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);
            if (val == target) {
                return mid;
            } else if (val > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
        
    }
}