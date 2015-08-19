public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        Queue<Long> heap = new PriorityQueue<Long>();
        heap.offer(2L);
        heap.offer(3L);
        heap.offer(5L);
        Set<Long> set = new HashSet<Long>();
        set.add(2L);
        set.add(3L);
        set.add(5L);
        --n;
        while (n > 1) {
            long cur = heap.poll();
            if (set.add(cur * 2)) {
                heap.offer(cur * 2);
            }
            if (set.add(cur * 3)) {
                heap.offer(cur * 3);
            } 
            if (set.add(cur * 5)) {
                heap.offer(cur * 5);
            }
            --n;
        }
        return heap.peek().intValue();
    }
}