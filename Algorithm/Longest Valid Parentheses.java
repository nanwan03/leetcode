public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        int validStart = -1;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '(') {
        		stack.push(i);
        	} else {
        		if (stack.isEmpty()) {
        			validStart = i;
        		} else {
        			stack.pop();
        			int start = stack.isEmpty() ? validStart : stack.peek();
        			max = Math.max(max, i - start);
        		}
        	}
        }
        return max;
    }
}