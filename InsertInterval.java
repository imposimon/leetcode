public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals == null || newInterval == null) return intervals;
		List<Interval> result = new LinkedList<Interval> ();
		for(Interval interval : intervals) {
			if(newInterval.start > interval.end) {
				result.add(interval);
			} else if(newInterval.end < interval.start) {
				result.add(newInterval);
				newInterval = interval;
			} else {
				newInterval = new Interval(Math.min(newInterval.start, interval.start),
											Math.max(newInterval.end, interval.end));
			}
		}
		result.add(newInterval);
		return result;
	}
}
