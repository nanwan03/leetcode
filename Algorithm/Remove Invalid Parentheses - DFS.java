class Solution {
    private int min = Integer.MAX_VALUE;
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return Arrays.asList(new String[]{""});
        }
        Map<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();
        helper(map, s, 0, "", 0, 0, 0);
        return new ArrayList<String>(map.get(min));
    }
    private void helper(Map<Integer, Set<String>> map, String s, int cur, String str, int left, int right, int deleteNum) {
        if (cur == s.length()) {
            if (left == right) {
                Set<String> set = map.getOrDefault(deleteNum, new HashSet<String>());
                set.add(str);
                map.put(deleteNum, set);
                min = Math.min(min, deleteNum);
            }
            return;
        }
        if (left < right) {
            return;
        }
        if (s.charAt(cur) == '(') {
            helper(map, s, cur + 1, str + "(", left + 1, right, deleteNum);
            helper(map, s, cur + 1, str, left, right, deleteNum + 1);
        } else if (s.charAt(cur) == ')') {
            helper(map, s, cur + 1, str + ")", left, right + 1, deleteNum);
            helper(map, s, cur + 1, str, left, right, deleteNum + 1);
        } else {
            helper(map, s, cur + 1, str + s.charAt(cur), left, right, deleteNum);
        }
    }
}