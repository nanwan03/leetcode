public class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int size = s.length();
        int[] count = new int[26];
        int left = 0;
        int max = 0;
        int rst = 0;
        for (int i = 0; i < size; ++i) {
            max = Math.max(max, ++count[s.charAt(i) - 'A']);
            while (i - left + 1 > k + max) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            rst = Math.max(rst, i - left + 1);
        }
        return rst;
    }
}