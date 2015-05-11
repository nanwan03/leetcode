public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return rst;
        }
        List<String> items = new ArrayList<String>();
        helper(rst, items, s);
        return rst;
    }
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private void helper(List<List<String>> rst, List<String> items, String s) {
        if (s.length() == 0) {
            rst.add(new ArrayList<String>(items));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String firstPart = s.substring(0, i + 1);
            if (isPalindrome(firstPart)) {
                items.add(firstPart);
                helper(rst, items, s.substring(i + 1));
                items.remove(items.size() - 1);
            }
        }
    }
}