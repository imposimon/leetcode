public class Solution {
	public int maxPoints(Point[] points) {
		if(points == null) return 0;
		if(points.length < 3) return points.length;

		Map<Double, Integer> slope = new HashMap<Double, Integer> ();
		int max = 1;
		for(int i = 0; i < points.length - 1; i++) {
			slope.clear();
			int duplicate = 0;
			int vertical = 1;
			int tmp = 1;
			for(int j = i + 1; j < points.length; j++) {
				if(points[i].x == points[j].x && points[i].y == points[j].y) {
					duplicate++;
				} else if(points[i].x == points[j].x) {
					vertical++;	
				} else {
					double s = 0.0 + (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
					Integer count = slope.get(s);
					if(count == null) count = 1;
					slope.put(s, count + 1);
					tmp = Math.max(tmp, count + 1);
				}
				max = Math.max(max, tmp + duplicate);
				max = Math.max(max, vertical + duplicate);
			}
		}
		return max;
	}
}
