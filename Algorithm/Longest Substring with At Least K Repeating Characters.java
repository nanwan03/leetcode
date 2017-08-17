public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }   
        char[] chars = s.toCharArray();
        return helper(chars, 0, chars.length - 1, k);
    }
    private int helper(char[] chars, int left, int right, int k) {
        if (right - left + 1 < k) {
            return 0;
        }
        int[] count = new int[26];
        for (int i = left; i <= right; ++i) {
            count[chars[i] - 'a']++;
        }
        for (int i = left; i <= right; ++i) {
            if (count[chars[i] - 'a'] >= k) {
                continue;
            }
            return Math.max(helper(chars, left, i - 1, k), helper(chars, i + 1, right, k));
        }
        return right - left + 1;
    }
}