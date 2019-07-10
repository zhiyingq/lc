class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int s1 = pq.poll(), s2 = pq.poll();
            if (s1 != s2) pq.add(s1 - s2);
        }
        return pq.isEmpty() ? 0 : pq.peek();
                                                               
    }
}