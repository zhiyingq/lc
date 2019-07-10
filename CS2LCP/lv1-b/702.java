class Solution {
    public int search(ArrayReader reader, int target) {
        // first we need to figure out the size of the array
        int low = 0, high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int num = reader.get(mid);
            if (num > target) {
                high = mid - 1;
            } else if (num < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}