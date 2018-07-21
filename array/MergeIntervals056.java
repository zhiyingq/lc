import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

class MergeIntervals056 {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) { return mergedIntervals; }
		Comparator<Interval> INTCOMP = new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				if (a.start > b.start) return 1;
				if (a.start == b.start) return ((Integer)(a.end)).compareTo(b.end);
				else { return -1; }
			}
		};
		Collections.sort(intervals, INTCOMP);
		
		int i = 0;
		while (i < intervals.size()) { // i max: intervals.size() - 1
			int j = i;
            int max = intervals.get(j).end; 
            // max: to record the max end value
            // as long as max > start, we can merge the intervals
			while (j < intervals.size() - 1 && max >= intervals.get(j + 1).start) { 
				if (intervals.get(j + 1).end > max) { max = intervals.get(j + 1).end; }
                j++;	
			}
			// 到j为止，此时加上i-j
			mergedIntervals.add(new Interval(intervals.get(i).start, max));
			i = j + 1;
		}
		return mergedIntervals;
	}

	class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		public String toString() {
			@Override
			return "["+s+" "+e+"]"
		}
	}

 
	public static void main(String[] args) {
		MergeIntervals056 m = new MergeIntervals056();
		


	}
}