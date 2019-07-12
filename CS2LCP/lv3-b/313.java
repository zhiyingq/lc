class Solution {
    /* the basic idea is, we will fill the seq array one by one, the first element is 1 obviously
     * each prime has a chance to multiple itself with the seq number to generate a next number
     * THUS, index[i] records the next seq number to multiple for primes[i]
     * 
     * for example, at first the seq only has one element 1
     * then every prime has a chance to multiple it, thus every index[i], i=0,...,k equals to 0
     * then each prime multiple this number and we choose the smallest 
     * and then we add the index[i]++ for each product equals to the smallest value
     
     * ***improvement***
     * now if we save [prime_index, curr_product] in a heap
     * then each time we just put the node onto the heap
     * but primes[idx], index[idx] we can know the next time this prime will multiple which seq num, seq[index[idx]]
     * each time we poll the smallest node, and we also check the prev_min to avoid duplication
     */
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] index = new int[k]; // index[i] records that the next position for primes[i]
        int[] seq = new int[n];
        seq[0] = 1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(1, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{i, primes[i]});
        }
        
        int prevMin = -1;
        for (int i = 1; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[1] == prevMin) {
                int[] polled = pq.poll();
                int idx = polled[0];
                polled[1] = primes[idx] * seq[++index[idx]];
                pq.add(polled);
            }
            seq[i] = pq.peek()[1];
            prevMin = seq[i];
        }
        
        return seq[n - 1];  
    }
}