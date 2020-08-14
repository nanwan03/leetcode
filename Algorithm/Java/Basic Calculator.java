public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        String ops = "()+-*/";
        List<String> input = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '"' || c == ' ') {
                if (sb.length() != 0) {
                	input.add(sb.toString());
                	sb = new StringBuilder();
                }
            } else if (ops.contains(String.valueOf(c))){
            	if (sb.length() != 0) {
                	input.add(sb.toString());
                	sb = new StringBuilder();
                }
            	input.add(String.valueOf(c));
            } else {
                sb.append(c);
            }
        }
        if (sb.length() != 0) {
        	input.add(sb.toString());
        }
        return expressionEvaluate(input);
    }
    private int eval(List<String> rpn, String ops) {
        if(rpn == null || rpn.size() == 0) {
            return 0;
        }
    	Stack<Integer> stack = new Stack<Integer>();
    	for (String str : rpn) {
    		if (!ops.contains(str)) {
    			stack.push(Integer.parseInt(str));
    		} else {
    			int b = stack.pop();
    			int a = stack.pop();
    			if (str.equals("+")) {
    				stack.push(a + b);
    			} else if (str.equals("-")) {
    				stack.push(a - b);
    			} else if (str.equals("*")) {
    				stack.push(a * b);
    			} else {
    				stack.push(a / b);
    			}
    		}
    	}
    	return stack.pop();
    }
    private int expressionEvaluate(List<String> expression) {
        String ops = "()+-*/";
    	List<String> rpn = getRPN(expression, ops);
    	return eval(rpn, ops);
    }
    private List<String> getRPN(List<String> expression, String ops) {
    	List<String> rpn = new ArrayList<String>();
    	Stack<String> stack = new Stack<String>();
    	for (String str : expression) {
    		if (str.equals("(") || str.equals(")") || str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
    			if (stack.isEmpty()) {
    				stack.push(str);
    			} else if (str.equals("(")) {
    				stack.push(str);
    			} else if (str.equals(")")) {
    				while (!stack.isEmpty()) {
    					String op = stack.pop();
    					if (op.equals("(")) {
    						break;
    					}
    					rpn.add(op);
    				}
    			} else {
    				if (mycmp(stack.peek(), str) == 1) {
    					stack.push(str);
    				} else {
    					while (!stack.isEmpty() && mycmp(stack.peek(), str) == 0) {
    						rpn.add(stack.pop());
    					}
    					stack.push(str);
    				}
    			}
    		} else {
    			rpn.add(str);
    		}
    	}
    	while (!stack.isEmpty()) {
    		rpn.add(stack.pop());
    	}
    	return rpn;
    }
    private int mycmp(String a, String b) {
    	if(b.equals("(")) {
    		return 1;
    	} else if((b.equals("*") || b.equals("/")) &&(a.equals("+") || a.equals("-") || a.equals("("))) {
    		return 1;
    	} else if((b.equals("+") || b.equals("-")) && (a.equals("("))) {
    		return 1;
    	} else {
    		return 0;
    	}
    }
}