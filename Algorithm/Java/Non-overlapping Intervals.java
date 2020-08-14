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
    private class Cmp implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.end == i2.end ? i2.start - i1.start : i1.end - i2.end;
        }
    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Cmp());
        int end = Integer.MIN_VALUE;
        int rst = 0;
        for (Interval interval : intervals) {
            if (interval.start >= end) {
                end = interval.end;
            }
            else {
                rst++;
            }
        }
        return rst;
    }
}