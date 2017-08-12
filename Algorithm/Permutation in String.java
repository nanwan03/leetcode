public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) {
            return false;
        }
        int[] count = new int[256];
        for (char c : s1.toCharArray()) {
            count[c]++;
        }
        int left = 0;
        int windowSize = 0;
        for (int i = 0; i < s2.length(); ++i) {
            char c = s2.charAt(i);
            if(--count[c] >= 0) {
                windowSize++;
            }
            if (windowSize == l1) {
                while (++count[s2.charAt(left)] <= 0) {
                    left++;
                }
                if (i - left + 1 == s1.length()) {
                    return true;
                }
                windowSize--;
                left++;
            }
        }
        return false;
    }
}