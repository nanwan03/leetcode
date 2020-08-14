public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
        	return false;
        }
        Stack<Character> stack = new Stack<Character>();
        String brackets = "([{";
        for (char c : s.toCharArray()) {
        	if (brackets.contains(String.valueOf(c))) {
        		stack.push(c);
        	} else if (!stack.isEmpty() && checkMatch(stack.peek(), c)){
        		stack.pop();
        	} else {
        		return false;
        	}
        }
        return stack.isEmpty();
    }
    private boolean checkMatch(char c1, char c2) {
    	return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}