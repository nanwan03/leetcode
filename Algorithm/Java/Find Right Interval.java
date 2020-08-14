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
    public int[] findRightInterval(Interval[] intervals) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> starts = new ArrayList<Integer>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
            starts.add(intervals[i].start);
        }

        Collections.sort(starts);
        int[] rst = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i].end;
            int start = binarySearch(starts, end);
            if (start == -1) {
                rst[i] = -1;
            } else {
                rst[i] = map.get(starts.get(start));
            }
        }
        return rst;
    }
    public int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) { 
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (list.get(left) >= target) {
            return left;
        } else if (list.get(right) >= target) {
            return right;
        }
        return -1;
    }
}