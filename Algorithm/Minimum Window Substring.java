public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null) {
            return "";
        }
        int[] total = new int[256];
        for (int i = 0; i < t.length(); ++i) {
            total[t.charAt(i)]++;
        }
        int start = -1;
        int end = s.length();
        int left = 0;
        int windowSize = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (--total[s.charAt(i)] >= 0) {
                windowSize++;
            }
            if (windowSize == t.length()) {
                while (++total[s.charAt(left)] <= 0) {
                    left++;
                }
                if (i - left < end - start) {
                    start = left;
                    end = i;
                }
                left++;
                windowSize--;
            }
        }
        return start == -1 ? "" : s.substring(start, end + 1);
    }
}