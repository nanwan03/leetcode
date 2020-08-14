public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
	    if (n <= 0) {
            return new double[0];
        }
        double[] rst = new double[n];
        if (nums == null || nums.length == 0) {
            return rst;
        }
        int index = 0;
        Queue<Integer> minH = new PriorityQueue<Integer>();
        Queue<Integer> maxH = new PriorityQueue<Integer>(1, Collections.reverseOrder());
        for (int i = 0; i < nums.length; ++i) {
            if (i >= k) {
                int oldest = nums[i - k];
                if (!maxH.isEmpty() && oldest <= maxH.peek()) {
                    maxH.remove(oldest);
                    if (maxH.size() < minH.size()) {
                        maxH.offer(minH.poll());
                    }
                } else {
                    minH.remove(oldest);
                }
            }
            if (maxH.isEmpty() || nums[i] <= maxH.peek()) {
                maxH.offer(nums[i]);
            } else {
                minH.offer(nums[i]);
            }
            if (maxH.size() < minH.size()) {
                maxH.offer(minH.poll());
            }
            if (minH.size() + 1 < maxH.size()) {
                minH.offer(maxH.poll());
            }
            if (i + 1 >= k) {
                if (maxH.size() == minH.size()) {
                    rst[index++] = ((double)maxH.peek() + (double)minH.peek()) / 2.0;
                } else {
                    rst[index++] = (double)maxH.peek();
                }
            }
        }
        return rst;
    }
}