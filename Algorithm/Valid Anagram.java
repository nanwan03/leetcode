public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] totalChar = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            ++totalChar[s.charAt(i)];
            --totalChar[t.charAt(i)];
        }
        for (int i = 0; i < s.length(); ++i) {
            if (totalChar[s.charAt(i)] != 0) {
                return false;
            }
        }
        return true;
    }
}