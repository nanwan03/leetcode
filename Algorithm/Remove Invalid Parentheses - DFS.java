public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if (s.length() == 0) return new ArrayList<String>(Arrays.asList(""));
        Map<Integer, Set<String>> dics = new HashMap<Integer, Set<String>>();
        int[] min = new int[]{Integer.MAX_VALUE};
        char[] str = s.toCharArray();
        helper(dics, str, 0, "", 0, 0, min, 0);
        return new ArrayList<String>(dics.get(min[0]));
    }
    private void helper(Map<Integer, Set<String>> dics, char[] str, int start, String cur, 
                        int left, int right, int[] min, int delete) {
        // Base Cases
        if (start == str.length) {
            if (left != right) return;
            if (!dics.containsKey(delete)) dics.put(delete, new HashSet<String>());
            dics.get(delete).add(cur);
            min[0] = Math.min(min[0], delete);
            return;
        }
        if (left < right) return;
        if (str[start] == '(') {
            helper(dics, str, start + 1, cur + "(", left + 1, right, min, delete);
            helper(dics, str, start + 1, cur, left, right, min, delete + 1);
        } else if (str[start] == ')') {
            helper(dics, str, start + 1, cur + ")", left, right + 1, min, delete);
            helper(dics, str, start + 1, cur, left, right, min, delete + 1);
        } else {
            helper(dics, str, start + 1, cur + str[start], left, right, min, delete);
        }
    }
}