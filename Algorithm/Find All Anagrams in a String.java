public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return rst;
        }
        int[] total = new int[256];
        for (int i = 0; i < p.length(); ++i) {
            total[p.charAt(i)]++;
        }
        int left = 0;
        int windowSize = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (--total[s.charAt(i)] >= 0) {
                windowSize++;
            }
            if (windowSize == p.length()) {
                rst.add(left);
            }
            if (i - left + 1 == p.length()) {
                if (++total[s.charAt(left++)] > 0) {
                    windowSize--;
                } 
            }
        }
        return rst;
    }
}