class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<Integer>();
        if(p == null || p.length() == 0) {
            return rst;
        }
        int[] count = new int[256];
        for (char c : p.toCharArray()) {
            count[c]++;
        }
        int left = 0;
        int windowSize = 0;
        for (int i = 0; i< s.length(); ++i) {
            if (--count[s.charAt(i)] >= 0) {
                windowSize++;
            }
            if (windowSize == p.length()) {
                while (++count[s.charAt(left)] <= 0) {
                    left++;
                }
                if (i - left + 1 == p.length()) {
                    rst.add(left);
                }
                left++;
                windowSize--;
            }
        }
        return rst;
    }
}