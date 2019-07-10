class Solution {
    public List<Integer> pancakeSort(int[] A) {
        // starting from the largest number, check if it's on the position
        // if not, swap it to head, then swap the current length
        List<Integer> flips = new ArrayList<Integer>();
        int currLen = A.length;
        while (currLen > 1) {
            int i = 0;
            for (; i < currLen; i++) {
                if (A[i] == currLen) break;
            }
            
            if (i == --currLen) {
                continue;
            }
            if (i > 0) {
               reverse(A, i);
               flips.add(i + 1); 
            }
            reverse(A, currLen);
            flips.add(currLen + 1);
        }
        return flips;
    }
    
    private void reverse(int[] A, int index) {
        int low = 0, high = index;
        while (low < high) {
            int temp = A[low];
            A[low] = A[high];
            A[high] = temp;
            low++;
            high--;
        }
    }
}