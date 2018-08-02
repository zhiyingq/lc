import java.util.Comparator;
import java.util.Collections;
import java.util.Arrays;
class HINDEX274 {
    
	public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) { return 0; }

        Arrays.sort(citations);
        reverse(citations);
        // for index 0 -> n - 1;
        // for citations[index], there are [index + 1] numbers larger than it
        // if it is where h-index locates, then citations[index] >= index + 1;
        // and citations[index + 1] <= index + 1;
        // or if the index is the last one, we just return the index + 1;
        for (int i = 0; i < citations.length; i++) {
        	if (citations[i] <= i) { return i; }
        }
        return citations.length;
    }
    

    /*/ counting sort
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) { return 0; }
        // 1. construct an array with length + 1
        // 2. count: numbers that larger than or equal to the index
        int[] count = new int[citations.length + 1];
        for (int i : citations) {
            // if i >= citations.length, put it to the last bag
            if (i >= citations.length) { count[citations.length]++; }
            else { count[i]++; }
        }
        // count: index rangs from 0 to n
        // count[i] = number of numbers that is larger or equal to it
        // 
        int sum = 0;
        for (int i = count.length - 1; i > 0; i--) {
            sum += count[i];
            if (sum >= i) { return i; }
        }
        return 0;

    }
    */

    private void reverse(int[] arr) {
        int i = 0; int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }

    public static void main(String[] args) {
    	HINDEX274 h = new HINDEX274();
    	System.out.println(h.hIndex(new int[] {3,0,6,1,5}));
    }
}