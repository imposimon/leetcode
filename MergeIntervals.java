public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null || intervals.size() < 2) return intervals;
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		List<Interval> result = new LinkedList<Interval> ();
		Interval cur = intervals.get(0);
		for(int i = 1; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if(cur.end < interval.start) {
				result.add(cur);
				cur = interval;
			} else {
				cur = new Interval(Math.min(cur.start, interval.start), Math.max(cur.end, interval.end));
			}
		}
		result.add(cur);
		return result;
	}
}
