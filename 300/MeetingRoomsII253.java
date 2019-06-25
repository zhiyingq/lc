class MeetingRoomsII253 {
	public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        // 1. Sort the intervals according to the starting time
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);

        // 2. 按照1的顺序，根据ent-time的大小来把intervals 放入min-heap中
        // 如果新放入的intervals的start-time >= heap.peak().end-time,
        // 那么heap就要进行pop，直到heap.empty()或者heap.peak() > start-time为止
        // 首先先放进去表示优先度高，已经开始了。后放进去的有可能会和先放进去的产生冲突
        // 根据上述规则，在heap中的一定是正在发生冲突的情况，因此需要不断记录heap的大小来看最大的房间数是多少
        int max = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
        	while (!pq.isEmpty() && intervals[i].start >= pq.peek()) {
        		pq.poll();
        	}
        	pq.offer(intervals[i].end);
        	int size = pq.size();
        	if (size > max) { max = size; }
        }

        return max;
    }

    class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e}
    }
}