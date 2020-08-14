public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null) return res;
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.add(s);
        boolean reached = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                // Valid
                if (isValid(cur)) {
                    reached = true;
                    res.add(cur);
                }
                // Not Valid Then Delete 
                if (!reached) {
                    for (int j = 0; j < cur.length(); j++) {
                        if (cur.charAt(j) != '(' && cur.charAt(j) != ')') continue;
                        String newStr = cur.substring(0, j) + cur.substring(j + 1);
                        if (!visited.contains(newStr)) {
                            queue.add(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
            if (reached) break;
        }
        return res;
    }
    private boolean isValid(String str) {
        char[] s = str.toCharArray();
        int left = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') left++;
            else if (s[i] == ')') {
                if (left == 0) return false;
                left--;
            }
        }
        return left == 0;
    }
}