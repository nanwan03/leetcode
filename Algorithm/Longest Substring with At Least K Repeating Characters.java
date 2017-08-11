public class Solution {
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        return helper(chars, 0, s.length() - 1, k);
    }
    private int helper(char[] chars, int start, int end,  int k) {
        if (end - start + 1 < k) {
            return 0;
        }
        int[] count = new int[26];
        for (int i = start; i <= end; ++i) {
            int idx = chars[i] - 'a';
            count[idx]++;
        }
        for (int i = 0; i < 26; ++i) {
            if (0 < count[i] && count[i] < k) {
                for(int j = start; j <= end; ++j) {
                    if (chars[j] == i + 'a') {
                        int left = helper(chars, start, j - 1, k);
                        int right = helper(chars, j + 1, end, k);
                        return Math.max(left,right);
                    }
                }
            }
        }
        return end - start + 1;
    }
}