public class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<Long>();
        queue.offer(1L);
        set.add(1L);
        while (--n > 0) {
            Long val = queue.poll();
            if (set.add(val * 2)) {
                queue.offer(val * 2);
            }
            if (set.add(val * 3)) {
                queue.offer(val * 3);
            }
            if (set.add(val * 5)) {
                queue.offer(val * 5);
            }
        }
        return queue.peek().intValue();
    }
}