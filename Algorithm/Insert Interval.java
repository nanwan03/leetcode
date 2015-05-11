/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval>  rst = new ArrayList<Interval>();
        if (intervals == null || newInterval == null) {
        	return rst;
        }
        int lastInput = 0;
        for (Interval interval : intervals) {
        	if (interval.end < newInterval.start) {
        		rst.add(interval);
        		lastInput++;
        	} else if (newInterval.end < interval.start) {
        		rst.add(interval);
        	} else {
        		newInterval.start = Math.min(newInterval.start, interval.start);
        		newInterval.end = Math.max(newInterval.end, interval.end);
        	}
        }
        rst.add(lastInput, newInterval);
        return rst;
    }
}