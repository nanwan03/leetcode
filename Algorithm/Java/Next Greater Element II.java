public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int rst[] = new int[size];
        Arrays.fill(rst, -1);
        Stack<Integer> stack = new Stack<Integer>(); 
        for (int i = 0; i < size * 2; i++) {
            int num = nums[i % size]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                rst[stack.pop()] = num;
            }
            if (i < size) {
                stack.push(i);
            }
        }   
        return rst;
    }
}