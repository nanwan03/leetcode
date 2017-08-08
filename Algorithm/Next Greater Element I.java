public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }  
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.containsKey(findNums[i]) ? map.get(findNums[i]) : -1;
        }
        return findNums;
    }
}