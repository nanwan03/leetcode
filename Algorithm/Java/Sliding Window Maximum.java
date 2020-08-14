public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
        	return nums;
        }
        int[] rst = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
        	while (!deque.isEmpty() && nums[deque.peekFirst()] <= nums[i]) {
        		deque.pollFirst();
        	}
        	deque.offerFirst(i);
        	while (!deque.isEmpty() && deque.peekLast() <= i - k) {
        		deque.pollLast();
        	}
        	if (i >= k - 1) {
        		rst[index++] = nums[deque.peekLast()];
        	}
        }
        return rst;
    }
}