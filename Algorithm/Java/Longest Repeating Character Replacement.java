class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int windowSize = 0;
        int left = 0;
        int rst = 0;
        int[] count = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            windowSize = Math.max(windowSize, ++count[s.charAt(i)]);
            if (i + 1 - left > windowSize + k) {
                --count[s.charAt(left++)];
            } else {
                rst = Math.max(rst, i + 1 - left);
            }
        }
        return rst;
    }
}